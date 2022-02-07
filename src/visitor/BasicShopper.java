package visitor;

/**
 * Basic amazon 2 shopper, shopper will buy like a regular consumer
 */
public class BasicShopper implements Shopper {
    @Override
    public DisplayShell visit(GPU gpu) {
        return null;
    }

    @Override
    public DisplayShell visit(Potatoes potatoes) {
        return null;
    }

    @Override
    public DisplayShell visit(RentACarProduct deodorant) {
        return null;
    }
}
