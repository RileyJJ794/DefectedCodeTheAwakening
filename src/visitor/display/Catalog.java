package visitor.display;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.products.Product;
import visitor.shoppers.Shopper;

import java.util.Collection;
import java.util.LinkedList;

public class Catalog {

    private Shopper shopper;
    private Collection<Product> products;
    private Collection<Product> productsInCart;
    private VBox catalogView;

    public Catalog(Shopper shopper, Collection<Product> products, VBox view){
        this.shopper = shopper;
        this.products = products;
        this.productsInCart = new LinkedList<>();
        catalogView = generateView(view);
    }

    public Catalog(Shopper shopper, Collection<Product> products, Collection<Product> productsInCart, VBox view){
        this(shopper, products, view);
        this.productsInCart = productsInCart;
    }

    private VBox generateView(VBox view) {
        for(Product product : products){
            Button button = new Button("Add to Cart");
            button.setOnAction((event) -> {
                productsInCart.add(product);
            });
//            view.getChildren().add(new HBox(product.accept(shopper).displayMain(), button));
        }
        return view;
    }

    public Pane getView() {
        return catalogView;
    }

    public ShoppingCart toShoppingCart(VBox view){
        return new ShoppingCart(shopper, productsInCart, view);
    }
}
