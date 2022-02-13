package visitor.display;

import visitor.products.Product;

public class PurchaseOrder {
   private Product product;
   private int amount;

   public PurchaseOrder(Product product, int amount){
        this.amount = amount;
        this.product = product;
   }

    public int getAmount() {
        return amount;
    }

    public Product getProduct(){
       return product;
    }
}
