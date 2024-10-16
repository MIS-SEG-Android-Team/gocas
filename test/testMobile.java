import org.rmj.gocas.pojo.ApplicantInfo;

public class testMobile {
    public static void main(String [] args){
        ApplicantInfo spouse = new ApplicantInfo();
        spouse.setMobileNoQty(1);
        spouse.setMobileNo(0, "11111111111");
        
        spouse.setMobileNoQty(2);
        spouse.setMobileNo(1, "22222222222");
        
        spouse.setMobileNoQty(3);
        spouse.setMobileNo(2, "33333333333");
        System.err.println(spouse.toJSONString());
    }
}

