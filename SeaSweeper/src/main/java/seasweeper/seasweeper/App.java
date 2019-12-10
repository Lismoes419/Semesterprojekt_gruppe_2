package seasweeper.seasweeper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import GameLogic.Game;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Game game;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        game = new Game();
        
        scene = new Scene(loadFXML("mainMenu"), 1280, 720);
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

    public static void load(String[] args) {
        launch();
    }    
    
    public static Game getGame()
    {
        return game;
    }
}