package visitor.products;

import javafx.scene.image.Image;
import visitor.shoppers.Shopper;
import visitor.display.DisplayShell;

/**
 * A GPU will be prices by the amount
 */
public class GPU implements Product {
    private int price = 100000;
    private int shippingTime = 8;
    private String handlingType = "plain box";
    private Image gpuImage;

    @Override
    public DisplayShell accept(Shopper shopper) {
        return shopper.visit(this);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(int shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String handlingType) {
        this.handlingType = handlingType;
    }

    public Image getGpuImage() {
        return gpuImage;
    }

    public void setGpuImage(Image gpuImage) {
        this.gpuImage = gpuImage;
    }
}
