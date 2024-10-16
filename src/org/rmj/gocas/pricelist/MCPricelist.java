package org.rmj.gocas.pricelist;

import org.json.simple.JSONObject;
import org.rmj.appdriver.mob.base.MiscUtil;
import org.rmj.appdriver.mob.base.MySQLAESCrypt;
import org.rmj.appdriver.mob.base.SQLUtil;

public class MCPricelist implements Pricelist{    
    final String SIGNATURE = "20190625";
    
    String sMessagex = "";
    
    String sModelIDx = "";
    String sModelNme = "";
    double nRebatesx = 0.00;
    double nMiscChrg = 0.00;
    double nEndMrtgg = 0.00;
    double nMinDownx = 0.00;
    double nSelPrice = 0.00;
    double nLastPrce = 0.00;

    double nDownPaym = 0.00;
    int nAcctTerm = 0;
    
    @Override
    public boolean setModelInfo(JSONObject foJSON) {
        if (!foJSON.isEmpty()){
            if (!foJSON.containsKey("sModelIDx") ||
                !foJSON.containsKey("sModelNme") ||
                !foJSON.containsKey("nRebatesx") ||
                !foJSON.containsKey("nMiscChrg") ||
                !foJSON.containsKey("nEndMrtgg") ||
                !foJSON.containsKey("nMinDownx") ||
                !foJSON.containsKey("nSelPrice") ||
                !foJSON.containsKey("nLastPrce")){
            }
                
            sModelIDx = (String) foJSON.get("sModelIDx");
            sModelNme = (String) foJSON.get("sModelNme");
            nRebatesx = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nRebatesx"), SIGNATURE));
            nMiscChrg = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nMiscChrg"), SIGNATURE));
            nEndMrtgg = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nEndMrtgg"), SIGNATURE));
            nMinDownx = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nMinDownx"), SIGNATURE));
            nSelPrice = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nSelPrice"), SIGNATURE));
            nLastPrce = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nLastPrce"), SIGNATURE));
            
            nDownPaym = nMinDownx; //set miminum down as downpayment
            return true;
        }       
        return false;
    }

    @Override
    public void setDownPayment(double fnValue) {
        nDownPaym = fnValue;
    }

    @Override
    public void setPaymentTerm(int fnValue) {
        nAcctTerm = fnValue;
    }
    
    @Override
    public double getDownPayment() {
        return nDownPaym;
    }
    
    @Override
    public double getMinimumDP() {
        return nMinDownx;
    }
    
    @Override
    public double getSellingPrice(String fsValue){
        return Double.valueOf(MySQLAESCrypt.Decrypt(fsValue, SIGNATURE));
    }

    @Override
    public String getMessage() {
        return sMessagex;
    }

    @Override
    public PriceFactory.ProductType UIProductType() {
        return PriceFactory.ProductType.MOTORCYCLE;
    }
    
    @Override
    public double getMonthlyAmort(JSONObject foJSON) {
        double lnMonAmort = 0.00;
        
        if (foJSON.isEmpty()){
            sMessagex = "JSON parameter is empty.";
            return Math.round(lnMonAmort);
        }
        
        if (!foJSON.containsKey("nSelPrice") || 
            !foJSON.containsKey("nMiscChrg") ||
            !foJSON.containsKey("nFactorRt") ||
            !foJSON.containsKey("nRebatesx") ||
            !foJSON.containsKey("nEndMrtgg")){
            sMessagex = "Missing key detected. Required keys are nSelPrice, nMiscChrg, nFactorRt, nRebatesx, nEndMrtgg.";
            return Math.round(lnMonAmort);
        }
        
        if (nAcctTerm <= 0){
            sMessagex = "Invalid term detected.";
            return Math.round(lnMonAmort);
        }
        
        nSelPrice = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nSelPrice"), SIGNATURE));
        nMiscChrg = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nMiscChrg"), SIGNATURE));
        nRebatesx = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nRebatesx"), SIGNATURE));
        nEndMrtgg = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nEndMrtgg"), SIGNATURE));
        double lnFactorRt = Double.valueOf(MySQLAESCrypt.Decrypt((String) foJSON.get("nFactorRt"), SIGNATURE));

        if (nAcctTerm < 4)
            lnMonAmort = (nSelPrice - nDownPaym) * lnFactorRt / nAcctTerm;
        else
            lnMonAmort = ((nSelPrice - nDownPaym + nMiscChrg) * lnFactorRt / nAcctTerm) + nRebatesx + (nEndMrtgg / nAcctTerm);
        
        return Math.round(lnMonAmort);
    }
    
    @Override
    public String getSQ_Model(String fsValue, boolean fbByCode, boolean fbExactNm){
        String lsCondition;
        
        if (fbByCode)
            lsCondition = "a.sModelIDx = " + SQLUtil.toSQL(fsValue);
        else {
            if (fbExactNm)
                lsCondition = "a.sModelNme = " + SQLUtil.toSQL(fsValue);
            else
                lsCondition = "a.sModelNme LIKE " + SQLUtil.toSQL(fsValue + "%");
        }     
        
        String lsSQL = "SELECT" +
                            "  a.sModelIDx" +
                            ", a.sModelNme" +
                            ", b.nMinDownx" +
                            ", c.nRebatesx" +
                            ", c.nMiscChrg" +
                            ", c.nEndMrtgg" +
                            ", b.nSelPrice" +
                            ", b.nLastPrce" +
                        " FROM MC_Model a" +
                            ", MC_Model_Price b" +
                            ", MC_Category c" +
                        " WHERE a.sModelIDx = b.sModelIDx" +
                            " AND b.cRecdStat = '1'" +
                            " AND b.sMCCatIDx = c.sMCCatIDx";
                
        return MiscUtil.addCondition(lsSQL, lsCondition);
    }
    
    @Override
    public String getSQ_Monthly(){
        if (sModelIDx.isEmpty()){
            sMessagex = "No model has been selected!";
            return "";
        }
        
        if (nAcctTerm <= 0){
            sMessagex = "Invalid term detected.";
            return "";
        }
        
        return "SELECT" +
                    "  a.nSelPrice" +
                    ", a.nMinDownx" +
                    ", b.nMiscChrg" +
                    ", b.nRebatesx" +
                    ", b.nEndMrtgg" +
                    ", c.nAcctThru" +
                    ", c.nFactorRt" +
                " FROM MC_Model_Price a" +
                    ", MC_Category b" +
                    ", MC_Term_Category c" +
                " WHERE a.sMCCatIDx = b.sMCCatIDx" +
                    " AND a.sMCCatIDx = c.sMCCatIDx" +
                    " AND a.sModelIDx = " + SQLUtil.toSQL(sModelIDx) +
                    " AND c.nAcctThru = " + nAcctTerm;
    }
}
