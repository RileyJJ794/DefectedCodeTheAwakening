package visitor;

public interface Shopper {
    int visit(GPU gpu);
    int visit(Potatoes potatoes);
    int visit(RentACarProduct deodorant);
}
