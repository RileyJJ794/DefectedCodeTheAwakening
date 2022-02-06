/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 4 Bees
 * Author:     Andrew Crisler
 * Date:       1/5
 */

package visitor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;

public class Amazon2Controller {

    @FXML
    public VBox mainDisplay;

    @FXML
    public MenuItem basicUserButton;
    @FXML
    public MenuItem primeUserButton;
    @FXML
    public MenuItem distributorButton;


    @FXML
    public void initialize() {
        Collection<Product> products = createProductCatalog(); //create product list

        basicUserButton.setOnAction((event) -> {
            createInterface(new BasicShopper(), products);
        });

        primeUserButton.setOnAction((event) -> {
            createInterface(new PremiumShopper(), products);
        });

        distributorButton.setOnAction((event) -> {
            createInterface(new Distributor(), products);
        });

        createInterface(new BasicShopper(), products); //default to basic user upon startup
    }

    public Collection<Product> createProductCatalog() {
        Collection<Product> products = new ArrayList<>();
        products.add(new GPU());
        products.add(new Potatoes());
        products.add(new RentACarProduct());
        return products;
    }

    public void createInterface(Shopper shopper, Collection<Product> products){
        for(Product product : products){ //this is not an ideal way of doing this
            if(product instanceof GPU){
                shopper.visit((GPU) product);
            } else if (product instanceof Potatoes) {
                shopper.visit((Potatoes) product);
            } else {
                shopper.visit((RentACarProduct) product);
            }
        }
    }
}
