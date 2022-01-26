package visitor;

/**
 * The RentACarProduct will be priced by the time it is rented (per hour or day)
 */
public class RentACarProduct implements Product {
    @Override
    public int accept(Shopper shopper) {
        return shopper.visit(this);
    }
}
