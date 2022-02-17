/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author:
 */

package visitor.shoppers;

import javafx.scene.image.Image;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;
import visitor.display.DisplayShell;

/**
 * The distributor is a shopper that will want to buy products in bulk. This will
 * result in different pricing, shipping times, and handling. Perfect for the pattern
 */
public class Distributor implements Shopper {
    private final String handlingType = "Shipping Container";
    private final double priceMultiplier = 0.6;
    private final int rentACarQuantity = 5; //quantity of cars that must be purchased at a time by distributor
    private final int gpuQuantity = 10; //quantity of gpus that must be purchased at a time by a distributor
    private final int potatoesQuantity = 50; //quantity of potatoes that must be purchased at a time by a distributor

    /**
     * Adjusts the price, shipping time, container, and turns
     * the order into batches of GPUs
     * @param gpu instance of the GPU class to be modified
     * @param quantity the number of GPUs the customer is ordering
     * @return DisplayShell holding all of the modified values
     */
    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        double price = gpu.getPrice() * gpuQuantity * priceMultiplier;
        int shippingTime = gpu.getShippingTime();
        Image image = gpu.getGpuImage();
        String name = gpu.getName().concat(" x").concat(Integer.toString(gpuQuantity).concat(" units"));
        return new DisplayShell(image, name, ("$" + price + " per " + gpuQuantity + " units"),
                shippingTime + " days", handlingType, gpu.getDescription());
    }

    /**
     * Adjusts the price, shipping time, container, and turns
     * the order into batches of potatoes
     * @param potatoes instance of the potatoes class to be modified
     * @param quantity the number of potatoes the customer is ordering
     * @return DisplayShell holding all of the modified potato values
     */
    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        double price = potatoes.getPrice() * potatoesQuantity * priceMultiplier;
        int shippingTime = potatoes.getShippingTime();
        String name = potatoes.getName().concat(" x").concat(Integer.toString(potatoesQuantity).concat(" units"));;
        return new DisplayShell(potatoes.getPotatoImage(), name,
                ("$" + price + " per " + potatoesQuantity + " units"),
                shippingTime + " days", handlingType, potatoes.getDescription());
    }

    /**
     *
     * Adjusts the price, shipping time, container, and turns
     * the order into batches of RentACars
     * @param car instance of the RentACarProduct class to be modified
     * @param quantity the number of RentACars the customer is renting
     * @return DisplayShell holding all of the modified values
     */
    @Override
    public DisplayShell visit(RentACarProduct car, int quantity) {
        double price = car.getPricePerDay() * rentACarQuantity * priceMultiplier;
        int shippingTime = car.getShippingTime();
        return new DisplayShell(car.getImage(),
                car.getName().concat(" x").concat(Integer.toString(rentACarQuantity).concat(" units")),
                ("$" + price + " per " + rentACarQuantity + " units"), shippingTime + " days", handlingType, car.getDescription());
    }
}
