package visitor.display;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.display.Catalog;
import visitor.products.Product;
import visitor.shoppers.Shopper;

import java.util.Collection;

public class ShoppingCart {

    private Shopper shopper;
    private Collection<Product> productsInCart;
    private VBox cartView;

    public ShoppingCart(Shopper shopper, Collection<Product> productsInCart, VBox view){
        this.shopper = shopper;
        this.productsInCart = productsInCart;
        this.cartView = generateView(view);
    }

    private VBox generateView(VBox view) {
        for(Product product : productsInCart){
            Button button = new Button("Remove From Cart");
            button.setOnAction((event) -> {
                productsInCart.remove(product);
                view.getChildren().remove(product);
            });
//            view.getChildren().add(new HBox(product.accept(shopper).displayCart(), button));
        }
        return view;
    }

    public Pane getView() {
        return cartView;
    }

    public Catalog backToCatalog(Collection<Product> products, VBox view) {
        return new Catalog(shopper, products, productsInCart, view);
    }
}
