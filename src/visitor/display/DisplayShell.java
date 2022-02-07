package visitor.display;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

    public DisplayShell(Image portrait, String productName, String price,
                        String shippingTime, String handlingType) {
        this.portrait = portrait;
        this.price = price;
        this.productName = productName;
        this.shippingTime = shippingTime;
        this.handlingType = handlingType;
    }

    public Pane displayMain() {
        return new HBox(new ImageView(portrait),
                new VBox(new Label(productName), new Label(price)));
    }

    public Pane displayCart() {
        return new HBox(new ImageView(portrait), new VBox(new Label(productName),
                new Label(price), new Label(shippingTime), new Label(handlingType)));
    }
}
