package visitor.products;

import javafx.scene.image.Image;
import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The potatoes will be priced by the pound
 */
public class Potatoes implements Product {
    private int pricePerPound = 1;
    private int shippingTime = 10;
    private ArrayList<String> handlingType = new ArrayList<>(Arrays.asList("In a plain bag", "In a padded cooler"));
    private String name = "Potato";
    private static Image potatoImage = new Image("src/visitor/images/potatos.jpeg");

    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public ArrayList<String> getHandlingType() {
        return handlingType;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return potatoImage;
    }

}
