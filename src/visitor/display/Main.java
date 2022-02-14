/*
 * SE 2811 031: Defected Code: The Visitor Pattern
 * author: Andrew Crisler
 */

package visitor.display;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This project creates an online shop like amazon where users can select the products they
 * desire and view them in there shopping cart (unfortunately, we have not created a massive
 * warehouse and distributing center yes, so we cannot sell the products at this current time).
 *
 * This project was created to show off the visitor patter, where the shoppers are the visitors
 * and the products are the elements. When shoppers look at products in the catalog or shopping
 * cart, they use the visitor pattern to implement the displaying of products, as each shopper
 * will see the product with different information depending on what kind of shopper they are.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/Amazon2.fxml"));
        primaryStage.setTitle("The Future of Amazon");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(900.0);
        primaryStage.setHeight(700.0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
