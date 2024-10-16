package org.rmj.gocas.pricelist;

public class PriceFactory {    
    public enum ProductType {
        MOTORCYCLE, MOBILE_PHONE;
    }
    
    public static Pricelist make(PriceFactory.ProductType type){
        switch (type) {
        case MOTORCYCLE:
            return new MCPricelist();
        case MOBILE_PHONE:
            return null;
        default:
            return null;
        }
    }
}
