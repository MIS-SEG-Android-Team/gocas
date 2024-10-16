package org.rmj.gocas.pricelist;

import org.json.simple.JSONObject;

public interface Pricelist {
    public boolean setModelInfo(JSONObject foJSON);
    public void setDownPayment(double fnValue);
    public void setPaymentTerm(int fnValue);
    public double getDownPayment();
    public double getMinimumDP();
    public double getSellingPrice(String fsValue);
    public double getMonthlyAmort(JSONObject foJSON);
    public String getSQ_Model(String fsValue, boolean fbByCode, boolean fbExactNm);
    public String getSQ_Monthly();
    public String getMessage();
    public PriceFactory.ProductType UIProductType();
}
