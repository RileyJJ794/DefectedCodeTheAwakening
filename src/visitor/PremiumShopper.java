package visitor;

/**
 * This is a premium shopper, they will get special deals and different options for
 * shipping and handling.
 */
public class PremiumShopper implements Shopper {
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
