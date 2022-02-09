package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

/**
 * The RentACarProduct will be priced by the time it is rented (per hour or day)
 */
public class RentACarProduct implements Product {
    private int pricePerDay =  250;
    private int shippingTime = 10;
    private String handlingType = "plain box";
    private String name = "Jeep";

    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public String getHandlingType() {
        return handlingType;
    }

    public String getName() {
        return name;
    }
}
