package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

public interface Product {
    DisplayShell accept(Shopper shopper);
}
