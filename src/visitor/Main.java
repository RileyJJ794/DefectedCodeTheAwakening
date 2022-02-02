package visitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://mySite.com");

        Parent root = FXMLLoader.load(getClass().getResource("Amazon2.fxml"));
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
