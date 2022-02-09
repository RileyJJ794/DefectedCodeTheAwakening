package visitor.shoppers;

import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;

public interface Shopper {
    DisplayShell visit(GPU gpu, int quantity);
    DisplayShell visit(Potatoes potatoes, int quantity);
    DisplayShell visit(RentACarProduct deodorant, int quantity);
}
