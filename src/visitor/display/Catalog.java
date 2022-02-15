/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.display;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.products.Product;
import visitor.shoppers.Shopper;

import java.util.Collection;
import java.util.LinkedList;

/**
 * The catalog is responsible for creating a display of all products the store has to offer, and
 * to collect the users purchases.
 */
public class Catalog {
    private Shopper shopper;
    private Collection<Product> products;
    private Collection<PurchaseOrder> productsInCart;
    private VBox catalogView;
    private Label numProductsInCart;

    public Catalog(Shopper shopper, Collection<Product> products, VBox view, Label numProductsInCart){
        this.shopper = shopper;
        this.products = products;
        this.productsInCart = new LinkedList<>();
        this.numProductsInCart = numProductsInCart;
        catalogView = generateView(view);
    }

    public Catalog(Shopper shopper, Collection<Product> products, Collection<PurchaseOrder> productsInCart, VBox view, Label numProductsInCart){
        this(shopper, products, view, numProductsInCart);
        this.productsInCart = productsInCart;
    }

    private VBox generateView(VBox view) {
        view.getChildren().clear(); //clears the view
        for(Product product : products){
            TextField textField = new TextField();
            textField.setPromptText("amount");
            textField.setPrefWidth(100);
            VBox.setMargin(textField, new Insets(75,0,0,0));
            textField.textProperty().addListener((obs, text, newText) -> {
                if (!newText.matches("\\d*")) { //removes all non integer values
                    textField.setText(text); //sets the text field to the old text
                }
            });

            Button button = new Button("Add to Cart");
            button.setPrefWidth(100);
            VBox.setMargin(button, new Insets(10,0,0,0));
            button.setOnAction((event) -> {
                int amount = textField.getText().equals("") ? 1 : Integer.parseInt(textField.getText());
                productsInCart.add(new PurchaseOrder(product, amount));
                numProductsInCart.setText("" + (Integer.parseInt(numProductsInCart.getText()) + 1));
                button.setText("Buy Another");
            });

            Pane productDisplay = product.accept(shopper, 1).displayMain(); product.accept(shopper, 1).displayMain(); //using visitor pattern to get display
            HBox productCard = new HBox(productDisplay, new VBox(textField, button));
            productCard.setStyle("-fx-background-color: lightgray;");
            VBox.setMargin(productCard, new Insets(10));

            view.getChildren().add(productCard);
        }
        return view;
    }

    public Pane getView() {
        return catalogView;
    }

    /**
     * This method is to create a shopping cart out of the state held by this catalog.
     * @return a shopping cart instance
     */
    public ShoppingCart toShoppingCart(){
        return new ShoppingCart(shopper, productsInCart, catalogView, numProductsInCart);
    }
}
