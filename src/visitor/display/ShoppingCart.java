/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.display;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.products.Product;
import visitor.shoppers.Shopper;

import java.util.Collection;

/**
 * The Shopping Cart class is responsible to display the purchase orders that the user has made,
 * as well as to keep track of the products in the users cart and to remove them if the user
 * desires.
 */
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
            VBox.setMargin(button, new Insets(90,0,0,0));
            button.setOnAction((event) -> {
                productsInCart.remove(order);
                view.getChildren().remove(order);
                numProductsInCart.setText("" + (Integer.parseInt(numProductsInCart.getText()) - 1));
                generateView(view); //reset view
            });

            Pane productDisplay = order.getProduct().accept(shopper, order.getAmount()).displayCart();
            HBox productCard = new HBox(productDisplay, new VBox(button));
            productCard.setStyle("-fx-background-color: lightgray;");
            VBox.setMargin(productCard, new Insets(10));

            view.getChildren().add(productCard);
        }
        return view;
    }

    public Pane getView() {
        return cartView;
    }

    /**
     * This method creates a catalog out of the state of the shopping cart and a collection
     * of the full catalog passed in
     * @param products the catalog of products
     * @return a Catalog
     */
    public Catalog backToCatalog(Collection<Product> products) {
        return new Catalog(shopper, products, productsInCart, cartView, numProductsInCart);
    }
}
