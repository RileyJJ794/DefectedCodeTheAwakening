package visitor.products;

import javafx.scene.image.Image;
import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The RentACarProduct will be priced by the time it is rented (per hour or day)
 */
public class RentACarProduct implements Product {
    private int pricePerDay =  250;
    private int shippingTime = 10;
    private ArrayList<String> handlingType = new java.util.ArrayList<>(Arrays.asList("On an open trailer", "On a closed, climate controled trailer"));
    private String name = "Lambo";
    private static Image carImage = new Image("src/visitor/images/car.jpeg");

    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }

    public int getPricePerDay() {
        return pricePerDay;
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
        return carImage;
    }
}
