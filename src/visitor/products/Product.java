/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.products;

import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

public interface Product {
    DisplayShell accept(Shopper shopper, int quantity);
}
