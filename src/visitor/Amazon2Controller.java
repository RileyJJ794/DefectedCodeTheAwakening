/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 4 Bees
 * Author:     Andrew Crisler
 * Date:       1/5
 */

package visitor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;

public class Amazon2Controller {

    @FXML
    public Pane mainDisplay;

    private Pane logoutMenuSave;

    @FXML
    public Label welcomeLabel;

    @FXML
    public HBox buttonMenu;
    @FXML
    public Button logout;
    @FXML
    public Button shoppingCartBtn;
    @FXML
    public Label numProducts;

    @FXML
    public MenuItem basicUserButton;
    @FXML
    public MenuItem primeUserButton;
    @FXML
    public MenuItem distributorButton;

    @FXML
    public void initialize() {
        Collection<Product> products = createProductCatalog(); //create product list

        buttonMenu.setVisible(false); //no user currently logged in
        logoutMenuSave = (Pane) mainDisplay.getChildren().get(0); //save the logout menu

        logout.setOnAction((event) -> {
            displayLogoutMenu();
        });

        basicUserButton.setOnAction((event) -> {
            displayCatalogMenu("Basic User", new BasicShopper(), products);
        });

        primeUserButton.setOnAction((event) -> {
            displayCatalogMenu("Prime User", new PremiumShopper(), products);
        });

        distributorButton.setOnAction((event) -> {
            displayCatalogMenu("Distributor", new Distributor(), products);
        });
    }

    private void displayLogoutMenu() {
        welcomeLabel.setText("Welcome to Amazon2");
        buttonMenu.setVisible(false);
        mainDisplay.getChildren().clear();
        mainDisplay.getChildren().add(logoutMenuSave);
    }

    private void displayCatalogMenu (String user, Shopper shopper, Collection<Product> products){
        welcomeLabel.setText("Welcome " + user);
        buttonMenu.setVisible(true);
        mainDisplay.getChildren().clear();
        VBox productDisplay = new VBox();
        productDisplay.setPrefSize(900., 660.);
        mainDisplay.getChildren().add(productDisplay);
        createCatalog(shopper, products, productDisplay);
    }

    public Collection<Product> createProductCatalog() {
        Collection<Product> products = new ArrayList<>();
        products.add(new GPU());
        products.add(new Potatoes());
        products.add(new RentACarProduct());
        return products;
    }

    //FIXME - this needs to be formatted right
    public void createCatalog(Shopper shopper, Collection<Product> products, Pane productDisplay){
        for(Product product : products){
            //productDisplay.getChildren().add(product.accept(shopper).displayMain());
        }
    }
}
