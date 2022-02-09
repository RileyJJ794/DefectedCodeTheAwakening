package visitor.shoppers;

import visitor.products.RentACarProduct;
import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;

/**
 * This is a premium shopper, they will get special deals and different options for
 * shipping and handling.
 */
public class PremiumShopper implements Shopper {
    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        return null;
    }

    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        return null;
    }

    @Override
    public DisplayShell visit(RentACarProduct deodorant, int quantity) {
        return null;
    }
}
