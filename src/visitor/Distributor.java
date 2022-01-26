package visitor;

/**
 * The distributor is a shopper that will want to buy products in bulk. This will
 * result in different pricing, shipping times, and handling. Perfect for the pattern
 */
public class Distributor implements Shopper {
    @Override
    public int visit(GPU gpu) {
        return 0;
    }

    @Override
    public int visit(Potatoes potatoes) {
        return 0;
    }

    @Override
    public int visit(RentACarProduct deodorant) {
        return 0;
    }
}
