package visitor;

/**
 * The potatoes will be priced by the pound
 */
public class Potatoes implements Product {

    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }
}
