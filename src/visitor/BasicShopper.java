package visitor;

/**
 * Basic amazon 2 shopper, shopper will buy like a regular consumer
 */
public class BasicShopper implements Shopper {
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
