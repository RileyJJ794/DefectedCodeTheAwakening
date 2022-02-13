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
    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        int price = gpu.getPrice();
        int shippingTime = gpu.getShippingTime();
        String handlingType = gpu.getHandlingType().get(1);
        Image image = gpu.getGpuImage();
        String name = gpu.getName();

        price *= 0.8;
        shippingTime -= 2;

        return new DisplayShell(image, name, Integer.toString(price), Integer.toString(shippingTime), handlingType, gpu.getDescription());
    }

    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        int price = potatoes.getPrice();
        int shippingTime = potatoes.getShippingTime();
        String handlingType = potatoes.getHandlingType().get(1);
        Image image = potatoes.getPotatoImage();
        String name = potatoes.getName();

        price *= 0.8;
        shippingTime -= 2;

        return new DisplayShell(image, name, Integer.toString(price), Integer.toString(shippingTime), handlingType, potatoes.getDescription());
    }

    @Override
    public DisplayShell visit(RentACarProduct car, int quantity) {
        int price = car.getPricePerDay();
        int shippingTime = car.getShippingTime();
        String handlingType = car.getHandlingType().get(1);
        Image image = car.getImage();
        String name = car.getName();

        price *= 0.8;
        shippingTime -= 2;

        return new DisplayShell(image, name, Integer.toString(price), Integer.toString(shippingTime), handlingType, car.getDescription());
    }
}
