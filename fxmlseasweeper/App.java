package fxmlseasweeper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    
        scene = new Scene(loadFXML("primary"), 875, 656);
        stage.setScene(scene);
        stage.show();
    }
   
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    
}
