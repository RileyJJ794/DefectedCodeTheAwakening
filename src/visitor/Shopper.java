package visitor;

public interface Shopper {
    DisplayShell visit(GPU gpu);
    DisplayShell visit(Potatoes potatoes);
    DisplayShell visit(RentACarProduct deodorant);
}
