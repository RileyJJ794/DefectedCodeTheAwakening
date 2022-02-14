/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author:
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
 * A GPU will be prices by the amount
 */
public class GPU implements Product {
    private int price = 1000;
    private int shippingTime = 8;
    private ArrayList<String> handlingType = new ArrayList<>(Arrays.asList("Plain Box", "RGB Box"));
    private final String name = "Nvidia GeForce RTX 3090";
    private Image gpuImage;
    private static String description = "we bought this gpu for a reasonable price and " +
            "are now selling it back to you for five times the price";

    public GPU() {
        try { //image was not happy with the string url, the file input stream fixed the problem
            gpuImage = new Image(new FileInputStream("src/resources/images/gpu.jpeg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DisplayShell accept(Shopper shopper, int quantity) {
        return shopper.visit(this, quantity);
    }

    public int getPrice() {
        return price;
    }

    public int getShippingTime() {
        return shippingTime;
    }


    public Image getGpuImage() {
        return gpuImage;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getHandlingType() {
        return handlingType;
    }

    public String getDescription(){
        return description;
    }
}
