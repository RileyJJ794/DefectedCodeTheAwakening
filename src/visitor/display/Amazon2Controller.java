/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 4 Bees
 * Author:     Andrew Crisler
 * Date:       1/5
 */

package visitor.display;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visitor.products.GPU;
import visitor.products.Potatoes;
import visitor.products.Product;
import visitor.products.RentACarProduct;
import visitor.shoppers.BasicShopper;
import visitor.shoppers.Distributor;
import visitor.shoppers.PremiumShopper;
import visitor.shoppers.Shopper;

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
    public Button switchViews;
    @FXML
    public Label numProducts;

    @FXML
    public MenuItem basicUserButton;
    @FXML
    public MenuItem primeUserButton;
    @FXML
    public MenuItem distributorButton;

    private Collection<Product> products; //all products in the catalog

    @FXML
    public void initialize() {
        products = createProductCatalog(); //create product list

        setButtonMenuVisibility(false); //no user currently logged in
        logoutMenuSave = (Pane) mainDisplay.getChildren().get(0); //save the logout menu

        logout.setOnAction((event) -> {
            numProducts.setText("0");
            displayLogoutMenu();
        });

        basicUserButton.setOnAction((event) -> createCatalogMenu("Basic User", new BasicShopper(), products));

        primeUserButton.setOnAction((event) -> createCatalogMenu("Prime User", new PremiumShopper(), products));

        distributorButton.setOnAction((event) -> createCatalogMenu("Distributor", new Distributor(), products));
    }

    private void setButtonMenuVisibility(Boolean isVisible) {
        buttonMenu.setVisible(isVisible);
    }

    private void setCatalogButtonMenu(String user, Catalog catalog){
        welcomeLabel.setText("Welcome " + user);
        setButtonMenuVisibility(true);
        numProducts.setVisible(true);
        switchViews.setText("Shopping Cart");
        switchViews.setOnAction((event) -> {
            ShoppingCart cart = catalog.toShoppingCart();
            clearMainDisplay();
            mainDisplay.getChildren().add(cart.getView());
            setCartButtonMenu(user, cart);
        });
    }

    private void setCartButtonMenu(String user, ShoppingCart cart) {
        welcomeLabel.setText(user + "'s Shopping Cart");
        setButtonMenuVisibility(true);
        numProducts.setVisible(false);
        switchViews.setText("Back To Catalog");
        switchViews.setOnAction((event) -> {
            Catalog catalog = cart.backToCatalog(products);
            clearMainDisplay();
            mainDisplay.getChildren().add(cart.getView());
            setCatalogButtonMenu(user, catalog);
        });
    }

    private VBox clearMainDisplay(){
        mainDisplay.getChildren().clear();
        VBox productDisplay = new VBox();
        productDisplay.setPrefSize(900., 660.);
        return productDisplay;
    }

    private void displayLogoutMenu() {
        welcomeLabel.setText("Welcome to Amazon2");
        setButtonMenuVisibility(false);
        mainDisplay.getChildren().clear();
        mainDisplay.getChildren().add(logoutMenuSave);
    }

    private void createCatalogMenu(String user, Shopper shopper, Collection<Product> products){
        VBox newView = clearMainDisplay();
        Catalog catalog = new Catalog(shopper, products, newView, numProducts);
        mainDisplay.getChildren().add(catalog.getView());
        setCatalogButtonMenu(user, catalog);
    }

    private Collection<Product> createProductCatalog() {
        Collection<Product> products = new ArrayList<>();
        products.add(new GPU());
        products.add(new Potatoes());
        products.add(new RentACarProduct());
        return products;
    }
}
