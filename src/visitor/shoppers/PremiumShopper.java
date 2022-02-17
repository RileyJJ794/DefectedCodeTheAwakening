/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Riley Jensen
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

    /**
     * Adjusts the packaging, shipping time and dollar value of the GPU to be
     * in line with what PremiumShopper visitor should expect.
     * @param gpu instance of the GPU class to be modified
     * @param quantity the number of GPUs the customer is ordering
     * @return DisplayShell holding all of the modified values
     */
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

    /**
     * Adjusts the price, packaging and shipping time of each batch of potatoes
     * to the PremiumShopper standard.
     * @param potatoes instance of the potatoes class to be modified
     * @param quantity the number of potatoes the customer is ordering
     * @return DisplayShell holding all of the modified potato values
     */
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

    /**
     * Adjusts the shipping time, packaging, and value of the RentACarProduct
     * to be in line with what a PremiumShopper should expect.
     * @param car instance of the RentACarProduct class to be modified
     * @param quantity the number of RentACars the customer is renting
     * @return DisplayShell holding all of the modified values
     */
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
