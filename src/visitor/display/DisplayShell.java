/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.display;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * This class is used to collect information about the product. I use strings to be flexible
 * in what the product can enter into these fields. It is a solution level class that is responsible
 * for producing a nice display for product info, both for the catalog and cart displays
 */
public class DisplayShell {
    private Image portrait;
    private String productName;
    private String price;
    private String shippingTime;
    private String handlingType;
    private String description;

    public DisplayShell(Image portrait, String productName, String price,
                        String shippingTime, String handlingType, String description) {
        this.portrait = portrait;
        this.price = price;
        this.productName = productName;
        this.shippingTime = shippingTime;
        this.handlingType = handlingType;
        this.description = description;
    }

    public Pane displayMain() {
        ImageView imageView = new ImageView(portrait);
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);
        HBox.setMargin(imageView,new Insets(10));

        Text nameText = new Text(productName);
        nameText.setStyle("-fx-font-size: x-large; -fx-font-weight: bold;");
        nameText.wrappingWidthProperty().setValue(280);

        Text priceText = secondaryTextDesign("Cost: " + price, null);
        VBox.setMargin(priceText, new Insets(10, 0, 20, 0));

        Text descriptionText = secondaryTextDesign("About this product: " + description, null);

        VBox productDescription = new VBox(nameText, priceText, descriptionText);
        productDescription.setPrefWidth(300);
        productDescription.setPadding(new Insets(10, 10, 10, 10));

        return new HBox(imageView, productDescription);
    }

    private Text secondaryTextDesign(String text, Insets padding){
        Text textDisplay = new Text(text);
        textDisplay.setStyle("-fx-font-size: larger");
        if(padding != null) {
            VBox.setMargin(textDisplay, padding);
        }
        textDisplay.wrappingWidthProperty().setValue(280);
        return textDisplay;
    }

    public Pane displayCart() {
        ImageView imageView = new ImageView(portrait);
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);
        HBox.setMargin(imageView,new Insets(10));

        Text nameText = new Text(productName);
        nameText.setStyle("-fx-font-size: x-large; -fx-font-weight: bold;");
        nameText.wrappingWidthProperty().setValue(280);

        Text priceText = secondaryTextDesign("Cost: " + price, new Insets(10, 0, 0, 0));
        Text shippingText = secondaryTextDesign("Shipping Time: " + shippingTime, new Insets(10, 0, 0, 0));
        Text handlingText = secondaryTextDesign("Handling: " + handlingType, new Insets(10, 0, 0, 0));

        VBox productInfo = new VBox(nameText, priceText, shippingText, handlingText);
        productInfo.setPrefWidth(300);
        productInfo.setPadding(new Insets(10, 10, 10, 10));

        return new HBox(imageView, productInfo);
    }
}
