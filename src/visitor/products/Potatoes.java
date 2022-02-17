/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Riley Jensen
 */

package visitor.products;

import javafx.scene.image.Image;
import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a potato that is priced by the pound.
 * Responsible for all the base information about a potato
 */
public class Potatoes implements Product {
    private int pricePerPound = 1;
    private int shippingTime = 10;
    private ArrayList<String> handlingType = new ArrayList<>(Arrays.asList("In a plain bag", "In a padded cooler"));
    private String name = "Potato";
    private static Image potatoImage;
    private static String description = "a bunch of potatoes sold online for all of your potato needs";

    public Potatoes() {
        try { //image was not happy with the string url, the file input stream fixed the problem
            potatoImage = new Image(new FileInputStream("src/resources/images/potatoes.jpeg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public DisplayShell accept(Shopper shopper, int quantity) {
        return shopper.visit(this, quantity);
    }

    public int getPrice() {
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

    public Image getPotatoImage() {
        return potatoImage;
    }

    public String getDescription(){
        return description;
    }
}
