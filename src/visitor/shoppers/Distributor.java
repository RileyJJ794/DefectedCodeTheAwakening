package visitor.shoppers;

import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;
import visitor.display.DisplayShell;

/**
 * The distributor is a shopper that will want to buy products in bulk. This will
 * result in different pricing, shipping times, and handling. Perfect for the pattern
 */
public class Distributor implements Shopper {
    @Override
    public DisplayShell visit(GPU gpu) {
        return null;
    }

    @Override
    public DisplayShell visit(Potatoes potatoes) {
        return null;
    }

    @Override
    public DisplayShell visit(RentACarProduct deodorant) {
        return null;
    }
}
