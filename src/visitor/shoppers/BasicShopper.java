/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author:
 */

package visitor.shoppers;

import javafx.scene.image.Image;
import visitor.display.DisplayShell;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.RentACarProduct;

/**
 * Basic amazon 2 shopper, shopper will buy like a regular consumer
 */
public class BasicShopper implements Shopper {

    /**
     * Scalps a gpu to the user, as there are no adjustments
     * made other than price being multiplied by quantity.
     * @param gpu instance of the GPU class to be modified
     * @param quantity the number of GPUs the customer is ordering
     * @return DisplayShell holding all of the modified values
     */
    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        int price = gpu.getPrice() * quantity;
        int shippingTime = gpu.getShippingTime();
        String handlingType = gpu.getHandlingType().get(0); //get worst handling type
        Image image = gpu.getGpuImage();
        String name = gpu.getName();
        return new DisplayShell(image, name, "$" + price, shippingTime + " days", handlingType, gpu.getDescription());
    }

    /**
     * Makes no changes to the behavior other than multiplying the price
     * by the quantity.
     * @param potatoes instance of the potatoes class to be modified
     * @param quantity the number of potatoes the customer is ordering
     * @return DisplayShell holding all of the modified potato values
     */
    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        int price = potatoes.getPrice() * quantity;
        int shippingTime = potatoes.getShippingTime();
        String handlingType = potatoes.getHandlingType().get(0); //get worst handling type
        String name = potatoes.getName();
        return new DisplayShell(potatoes.getPotatoImage(), name,
                "$" + price, shippingTime + " days", handlingType, potatoes.getDescription());
    }

    /**
     * Adjusts none of the values other than multiplying the
     * price by quantity before returning.
     * @param car instance of the RentACarProduct class to be modified
     * @param quantity the number of RentACars the customer is renting
     * @return DisplayShell holding all of the modified values
     */
    @Override
    public DisplayShell visit(RentACarProduct car, int quantity) {
        int price = car.getPricePerDay() * quantity;
        int shippingTime = car.getShippingTime();
        String handlingType = car.getHandlingType().get(0); //get worst handling type
        return new DisplayShell(car.getImage(), car.getName(),
                "$" + price, shippingTime + " days", handlingType, car.getDescription());
    }
}
