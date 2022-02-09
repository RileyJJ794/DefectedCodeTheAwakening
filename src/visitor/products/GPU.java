package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

/**
 * A GPU will be prices by the amount
 */
public class GPU implements Product {
    @Override
    public DisplayShell accept(Shopper shopper, int quantity) {
        return shopper.visit(this, quantity);
    }
}
