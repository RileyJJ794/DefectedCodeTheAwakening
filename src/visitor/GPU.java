package visitor;

/**
 * A GPU will be prices by the amount
 */
public class GPU implements Product {
    @Override
    public int accept(Shopper shopper) {
        return shopper.visit(this);
    }
}
