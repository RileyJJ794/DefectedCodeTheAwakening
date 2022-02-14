/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.display;

import visitor.products.Product;

/**
 * This class is a solution level class to keep track of individual product purchase orders.
 * It holds the product purchased and the amount purchased
 */
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
