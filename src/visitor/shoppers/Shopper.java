package visitor.shoppers;

import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;

public interface Shopper {
    DisplayShell visit(GPU gpu);
    DisplayShell visit(Potatoes potatoes);
    DisplayShell visit(RentACarProduct deodorant);
}
