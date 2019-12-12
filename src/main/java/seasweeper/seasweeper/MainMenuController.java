package seasweeper.seasweeper;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class MainMenuController implements Initializable {

    @FXML private Button quit;
    @FXML private Pane helpPane;
    
    private boolean helpBool = false;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void play() throws IOException
    {
        App.setRoot("primary");
    }
    
    @FXML
    public void quit()
    {
        App.getGame().quit();
    }
    
    @FXML
    public void help()
    {
        helpBool = !helpBool;
        
        //Opacity
        helpPane.setVisible(helpBool);
    }
}
