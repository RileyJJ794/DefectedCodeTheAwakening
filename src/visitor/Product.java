package visitor;

public interface Product {
    DisplayShell accept(Shopper shopper);
}
