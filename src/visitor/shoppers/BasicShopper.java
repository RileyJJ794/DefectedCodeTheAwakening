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

    @Override
    public DisplayShell visit(GPU gpu, int quantity) {
        int price = gpu.getPrice();
        int shippingTime = gpu.getShippingTime();
        String handlingType = gpu.getHandlingType();
        Image image = gpu.getGpuImage();
        String name = gpu.getName();
        return new DisplayShell(image, name, Integer.toString(price), Integer.toString(shippingTime), handlingType);
    }

    @Override
    public DisplayShell visit(Potatoes potatoes, int quantity) {
        int price = potatoes.getPricePerPound();
        int shippingTime = potatoes.getPricePerPound();
        //String handlingType = potatoes.getHandlingType();
        String name = potatoes.getName();
        return null;
    }

    @Override
    public DisplayShell visit(RentACarProduct deodorant, int quantity) {
        return null;
    }
}
