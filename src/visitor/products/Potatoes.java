package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

/**
 * The potatoes will be priced by the pound
 */
public class Potatoes implements Product {
    private int pricePerPound = 1;
    private int shippingTime = 10;
    private String handlingType = "plain box";
    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public String getHandlingType() {
        return handlingType;
    }
}
