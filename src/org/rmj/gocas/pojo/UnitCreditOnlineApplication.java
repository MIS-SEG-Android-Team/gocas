package org.rmj.gocas.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Stream;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.rmj.appdriver.mob.iface.GEntity;

@Entity
@Table(name="Credit_Online_Application")

public class UnitCreditOnlineApplication implements Serializable, GEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "sTransNox")
    private String sTransNox;
    
    @Id
    @Basic(optional = false)
    @Column(name = "sBranchCd")
    private String sBranchCd;
    
    @Basic(optional = false)
    @Column(name = "dTransact")
    @Temporal(TemporalType.DATE)
    private Date dTransact;
    
    @Basic(optional = true)
    @Column(name = "dTargetDt")
    @Temporal(TemporalType.DATE)
    private Date dTargetDt;
    
    @Column(name = "sClientNm")
    private String sClientNm;
    
    @Column(name = "sGOCASNox")
    private String sGOCASNox;
    
    @Column(name = "sGOCASNoF")
    private String sGOCASNoF;
    
    @Column(name = "cUnitAppl")
    private String cUnitAppl;
    
    @Column(name = "sSourceCD")
    private String sSourceCD;
    
    @Column(name = "sDetlInfo")
    private String sDetlInfo;
    
    @Column(name = "sCatInfox")
    private String sCatInfox;
    
    @Column(name = "sDesInfox")
    private String sDesInfox;
    
    @Column(name = "sQMatchNo")
    private String sQMatchNo;
    
    @Column(name = "sQMAppCde")
    private String sQMAppCde;
    
    @Column(name = "nCrdtScrx ")
    private int nCrdtScrx;
    
    @Column(name = "nDownPaym")
    private double nDownPaym;
    
    @Column(name = "nDownPayF")
    private double nDownPayF;
    
    @Column(name = "sRemarksx")
    private String sRemarksx;
    
    @Column(name = "sCreatedx")
    private String sCreatedx;
    
    @Basic(optional = true)
    @Column(name = "dCreatedx")
    @Temporal(TemporalType.DATE)
    private Date dCreatedx;
    
    @Basic(optional = true)
    @Column(name = "dReceived")
    @Temporal(TemporalType.DATE)
    private Date dReceived;
    
    @Column(name = "sVerified")
    private String sVerified;
    
    @Basic(optional = true)
    @Column(name = "dVerified")
    @Temporal(TemporalType.DATE)
    private Date dVerified;
    
    @Column(name = "cTranStat")
    private String cTranStat;
    
    @Column(name = "cDivision")
    private String cDivision;
    
    @Basic(optional = false)
    @Column(name = "dModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dModified;

    LinkedList laColumns = null;
    
    public UnitCreditOnlineApplication(){
        sTransNox = "";
        sBranchCd = "";
        dTransact = null;
        dTargetDt = null;
        sClientNm = "";
        sGOCASNox = null;
        sGOCASNoF = null;
        cUnitAppl = "";
        sSourceCD = "";  
        sDetlInfo = null;
        sCatInfox = null;  
        sDesInfox = null;
        sQMatchNo = "";
        sQMAppCde = "";
        nCrdtScrx = 0; 
        nDownPaym = 0.00;
        nDownPayF = 0.00;
        sRemarksx = "";
        sCreatedx = "";
        dCreatedx = null;
        dReceived = null;
        sVerified = "";
        dVerified = null;
        cTranStat = "";
        cDivision = "";
        dModified = null;
        
        laColumns = new LinkedList();
        laColumns.add("sTransNox");
        laColumns.add("sBranchCd");
        laColumns.add("dTransact");
        laColumns.add("dTargetDt");
        laColumns.add("sClientNm");
        laColumns.add("sGOCASNox");
        laColumns.add("sGOCASNoF");
        laColumns.add("cUnitAppl");
        laColumns.add("sSourceCD");  
        laColumns.add("sDetlInfo");
        laColumns.add("sCatInfox");  
        laColumns.add("sDesInfox");
        laColumns.add("sQMatchNo");
        laColumns.add("sQMAppCde");
        laColumns.add("nCrdtScrx"); 
        laColumns.add("nDownPaym");
        laColumns.add("nDownPayF");
        laColumns.add("sRemarksx");
        laColumns.add("sCreatedx");
        laColumns.add("dCreatedx");
        laColumns.add("dReceived");
        laColumns.add("sVerified");
        laColumns.add("dVerified");
        laColumns.add("cTranStat");
        laColumns.add("cDivision");
        laColumns.add("dModified");
    }
    
    public void setTransactNo(String fsValue){
        sTransNox = fsValue;
    }
    public String getTransactNo(){
        return sTransNox;
    }
    
    public void setBranchCode(String fsValue){
        sBranchCd = fsValue;
    }
    public String getBranchCode(){
        return sBranchCd;
    }
    
    public void setTransactDate(Date fdValue){
        dTransact = fdValue;
    }
    public Date getTransactDate(){
        return dTransact;
    }
    
    public void setTargetDate(Date fdValue){
        dTargetDt = fdValue;
    }
    public Date getTargetDate(){
        return dTargetDt;
    }
    
    public void setClientName(String fsValue){
        sClientNm = fsValue;
    }
    public String getClientName(){
        return sClientNm;
    }
    
    public void setGOCASCode(String fsValue){
        sGOCASNox = fsValue;
    }
    public String getGOCASCode(){
        return sGOCASNox;
    }
    
    public void setGOCASCodeF(String fsValue){
        sGOCASNoF = fsValue;
    }
    public String getGOCASCodeF(){
        return sGOCASNoF;
    }
    
    public void setUnitApplied(String fsValue){
        cUnitAppl = fsValue;
    }
    public String getUnitApplied(){
        return cUnitAppl;
    }
    
    public void setSourceCode(String fsValue){
        sSourceCD = fsValue;
    }
    public String getSourceCode(){
        return sSourceCD;
    }
    
    public void setDetailInfo(String fsValue){
        sDetlInfo = fsValue;
    }
    public String getDetailInfo(){
        return sDetlInfo;
    }
    
    public void setCategorizedInfo(String fsValue){
        sCatInfox = fsValue;
    }
    public String getCategorizedInfo(){
        return sCatInfox;
    }
    
    public void setVerifiedInfo(String fsValue){
        sDesInfox = fsValue;
    }
    public String getVerifiedInfo(){
        return sDesInfox;
    }
    
    public void setQuickMatchNo(String fsValue){
        sQMatchNo = fsValue;
    }
    public String getQuickMatchNo(){
        return sQMatchNo;
    }
    
    public void setQMApprvlCode(String fsValue){
        sQMAppCde = fsValue;
    }
    public String getQMApprvlCode(){
        return sQMAppCde;
    }
    
    public void setCreditScore(int fnValue){
        nCrdtScrx = fnValue;
    }
    public int getCreditScore(){
        return nCrdtScrx;
    }
    
    public void setDownPayment(double fnValue){
        nDownPaym = fnValue;
    }
    public double getDownPayment(){
        return nDownPaym;
    }
    
    public void setDownPaymentF(double fnValue){
        nDownPayF = fnValue;
    }
    public double getDownPaymentF(){
        return nDownPayF;
    }
    
    public void setRemarks(String fsValue){
        sRemarksx = fsValue;
    }
    public String getRemarks(){
        return sRemarksx;
    }
    
    public void setCreatedBy(String fsValue){
        sCreatedx = fsValue;
    }
    public String getCreatedBy(){
        return sCreatedx;
    }
    
    public void setDateCreated(Date fdValue){
        dCreatedx = fdValue;
    }
    public Date getDateCreated(){
        return dCreatedx;
    }
    
    public void setDateReceived(Date fdValue){
        dReceived = fdValue;
    }
    public Date dReceived(){
        return dCreatedx;
    }
       
    public void setVerifiedBy(String fsValue){
        sVerified = fsValue;
    }
    public String getVerifiedBy(){
        return sVerified;
    }
    
    public void setDateVerified(Date fdValue){
        dVerified = fdValue;
    }
    public Date getDateVerified(){
        return dVerified;
    }
    
    public void setTransStat(String fsValue){
        cTranStat = fsValue;
    }
    public String getTransStat(){
        return cTranStat;
    }
    
    public void setDivision(String fsValue){
        cDivision = fsValue;
    }
    public String getDivision(){
        return cDivision;
    }
    
    public void setDateModified(Date dModified){
        this.dModified = dModified;
    }
    public Date getDateModified(){
        return dModified;
    }
    
    @Override
    public int hashCode(){
        int hash = 0;
        hash += (sTransNox != null ? sTransNox.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitCreditOnlineApplication)) {
            return false;
        }
        UnitCreditOnlineApplication other = (UnitCreditOnlineApplication) object;
        return !((this.sTransNox == null && other.sTransNox != null) || (this.sTransNox != null && !this.sTransNox.equals(other.sTransNox)) ||
                (this.sBranchCd == null && other.sBranchCd != null) || (this.sBranchCd != null && !this.sBranchCd.equals(other.sBranchCd)));
    }
    
    @Override
    public String toString() {
        return "org.rmj.gogas.pojo.UnitCreditOnlineApplication[sTransNox=" + sTransNox + " AND sBranchCd=" + sBranchCd +"]";
    }
    
    @Override
    public Object getValue(int fnColumn) {
        switch(fnColumn){
            case 1: return sTransNox;
            case 2: return sBranchCd;
            case 3: return dTransact;
            case 4: return dTargetDt;
            case 5: return sClientNm;
            case 6: return sGOCASNox;
            case 7: return sGOCASNoF;
            case 8: return cUnitAppl;
            case 9: return sSourceCD;  
            case 10: return sDetlInfo;
            case 11: return sCatInfox;  
            case 12: return sDesInfox;
            case 13: return sQMatchNo;
            case 14: return sQMAppCde;
            case 15: return nCrdtScrx; 
            case 16: return nDownPaym;
            case 17: return nDownPayF;
            case 18: return sRemarksx;
            case 19: return sCreatedx;
            case 20: return dCreatedx;
            case 21: return dReceived;
            case 22: return sVerified;
            case 23: return dVerified;
            case 24: return cTranStat;
            case 25: return cDivision;
            case 26: return dModified;
            default: return null;
        }
    }

    @Override
    public Object getValue(String fsColumn) {
        int lnCol = getColumn(fsColumn);
        
        if (lnCol > 0){
            return getValue(lnCol);
        } else
            return null;
    }

    @Override
    public String getTable() {
        return "Credit_Online_Application";
    }

    @Override
    public String getColumn(int fnCol) {
        if (laColumns.size() < fnCol){
            return "";
        } else 
            return (String) laColumns.get(fnCol - 1);
    }

    @Override
    public int getColumn(String fsCol) {
        return laColumns.indexOf(fsCol) + 1;
    }

    @Override
    public void setValue(int fnColumn, Object foValue) {
        switch(fnColumn){
            case 1: sTransNox = (String) foValue; break;
            case 2: sBranchCd = (String) foValue; break;
            case 3: dTransact = (Date) foValue; break;
            case 4: dTargetDt = (Date) foValue; break;
            case 5: sClientNm = (String) foValue; break;
            case 6: sGOCASNox = (String) foValue; break;
            case 7: sGOCASNoF = (String) foValue; break;
            case 8: cUnitAppl = (String) foValue; break;
            case 9: sSourceCD = (String) foValue; break;  
            case 10: sDetlInfo = (String) foValue; break;
            case 11: sCatInfox = (String) foValue; break;  
            case 12: sDesInfox = (String) foValue; break;
            case 13: sQMatchNo = (String) foValue; break;
            case 14: sQMAppCde = (String) foValue; break;
            case 15: nCrdtScrx = (int) foValue; break; 
            case 16: nDownPaym = (double) foValue; break;
            case 17: nDownPayF = (double) foValue; break;
            case 18: sRemarksx = (String) foValue; break;
            case 19: sCreatedx = (String) foValue; break;
            case 20: dCreatedx = (Date) foValue; break;
            case 21: dReceived = (Date) foValue; break;
            case 22: sVerified = (String) foValue; break;
            case 23: dVerified = (Date) foValue; break;
            case 24: cTranStat = (String) foValue; break;
            case 25: cDivision = (String) foValue; break;
            case 26: dModified = (Date) foValue; break;
        }    
    }

    @Override
    public void setValue(String fsColumn, Object foValue) {
        int lnCol = getColumn(fsColumn);
        if (lnCol > 0){
            setValue(lnCol, foValue);
        }
    }

    @Override
    public int getColumnCount() {
        return laColumns.size();
    }
    
    public void list(){
        //Stream.of(laColumns).forEach(System.out::println);        
    }
}
