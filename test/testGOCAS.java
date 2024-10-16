
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.rmj.gocas.base.GOCASApplication;
import org.rmj.gocas.pojo.MeansInfo;
import org.rmj.gocas.pojo.ResidenceInfo;
import org.rmj.gocas.pojo.SpouseInfo;

public class testGOCAS {
    public static void main(String [] args){
        try {
            String lsSQL = "{\"present_address\":{\"sBrgyIDxx\":\"1100170\",\"sAddress1\":\"\",\"sLandMark\":\"Asdasdasd\",\"sAddress2\":\"\",\"sTownIDxx\":\"0346\",\"sHouseNox\":\"\"},\"cHouseTyp\":\"0\",\"sCtkReltn\":\"\",\"rent_others\":{\"nRentExps\":5000.0,\"nLenStayx\":3.0,\"cRntOther\":\"1\"},\"cOwnershp\":\"1\",\"cGaragexx\":\"1\",\"permanent_address\":{\"sBrgyIDxx\":\"1100170\",\"sAddress1\":\"\",\"sLandMark\":\"Asdasdasd\",\"sAddress2\":\"\",\"sTownIDxx\":\"0346\",\"sHouseNox\":\"\"}}";
        
            JSONParser loParser = new JSONParser();
            JSONObject loJSON = (JSONObject) loParser.parse(lsSQL);
                        
            ResidenceInfo info = new ResidenceInfo();
            info.setData(loJSON);
            
            System.out.println(info.toJSONString());
        } catch (ParseException ex) {
            Logger.getLogger(testGOCAS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
