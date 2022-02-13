package visitor.display;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.display.Catalog;
import visitor.products.Product;
import visitor.shoppers.Shopper;

import java.util.Collection;
import java.util.Map;

public class ShoppingCart {

    private Shopper shopper;
    private Collection<PurchaseOrder> productsInCart;
    private VBox cartView;
    private Label numProductsInCart;

    public ShoppingCart(Shopper shopper, Collection<PurchaseOrder> productsInCart, VBox view, Label numProductsInCart){
        this.shopper = shopper;
        this.productsInCart = productsInCart;
        this.cartView = generateView(view);
        this.numProductsInCart = numProductsInCart;
    }

    private VBox generateView(VBox view) {
        view.getChildren().clear();
        for(PurchaseOrder order : productsInCart){
            Button button = new Button("Remove From Cart");
            button.setOnAction((event) -> {
                productsInCart.remove(order);
                view.getChildren().remove(order);
                numProductsInCart.setText("" + (Integer.parseInt(numProductsInCart.getText()) - 1));
                generateView(view); //reset view
            });

            view.getChildren().add(new HBox(order.getProduct().accept(shopper, order.getAmount()).displayCart(), button));
        }
        return view;
    }

    public Pane getView() {
        return cartView;
    }

    public Catalog backToCatalog(Collection<Product> products) {
        return new Catalog(shopper, products, productsInCart, cartView, numProductsInCart);
    }
}
