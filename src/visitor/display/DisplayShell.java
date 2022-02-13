package visitor.display;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * This class is used to collect information about the product. I use strings to be flexible
 * in what the product can enter into these fields.
 *
 * The two display methods need to be better implemented with good styling
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

        Label nameText = new Label(productName);
        nameText.setStyle("-fx-font-size: x-large; -fx-font-weight: bold;");

        Label priceText = new Label("Cost: " + price);
        priceText.setStyle("-fx-font-size: larger");
        VBox.setMargin(priceText, new Insets(10, 0, 20, 0));

        Text descriptionText = new Text("About this product: " + description);
        descriptionText.setStyle("-fx-font-size: larger");
        descriptionText.wrappingWidthProperty().setValue(280);

        VBox productDescription = new VBox(nameText, priceText, descriptionText);
        productDescription.setPrefWidth(300);
        productDescription.setPadding(new Insets(10, 10, 10, 10));

        return new HBox(imageView, productDescription);
    }

    public Pane displayCart() {
        return new HBox(new ImageView(portrait), new VBox(new Label(productName),
                new Label(price), new Label(shippingTime), new Label(handlingType)));
    }
}
