/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author:
 */

package visitor.shoppers;

import javafx.scene.image.Image;
import visitor.products.RentACarProduct;
import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;

/**
 * This is a premium shopper, they will get special deals and different options for
 * shipping and handling.
 */
public class PremiumShopper implements Shopper {
    double discount = 0.8;
    int shippingExpress = 2;
    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        double price = gpu.getPrice();
        int shippingTime = gpu.getShippingTime();
        String handlingType = gpu.getHandlingType().get(1);
        Image image = gpu.getGpuImage();
        String name = gpu.getName();

        price *= discount;
        shippingTime -= shippingExpress;

        return new DisplayShell(image, name, "$" + price, shippingTime + " days", handlingType, gpu.getDescription());
    }

    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        double price = potatoes.getPrice();
        int shippingTime = potatoes.getShippingTime();
        String handlingType = potatoes.getHandlingType().get(1);
        Image image = potatoes.getPotatoImage();
        String name = potatoes.getName();

        price *= discount;
        shippingTime -= shippingExpress;

        return new DisplayShell(image, name, "$" + price, shippingTime + " days", handlingType, potatoes.getDescription());
    }

    @Override
    public DisplayShell visit(RentACarProduct car, int quantity) {
        double price = car.getPricePerDay();
        int shippingTime = car.getShippingTime();
        String handlingType = car.getHandlingType().get(1);
        Image image = car.getImage();
        String name = car.getName();

        price *= discount;
        shippingTime -= shippingExpress;

        return new DisplayShell(image, name, "$" + price, shippingTime + " days", handlingType, car.getDescription());
    }
}
