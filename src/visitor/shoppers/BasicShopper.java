package visitor.shoppers;

import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;

/**
 * Basic amazon 2 shopper, shopper will buy like a regular consumer
 */
public class BasicShopper implements Shopper {
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
