package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

/**
 * The RentACarProduct will be priced by the time it is rented (per hour or day)
 */
public class RentACarProduct implements Product {
    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }
}
