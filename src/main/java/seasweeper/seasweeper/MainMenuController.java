/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.seasweeper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author jakobrasmussen
 */
public class MainMenuController implements Initializable {


    @FXML private Button quit;
    @FXML private Pane helpPane;
    
    private boolean helpBool = false;
    /**
     * Initializes the controller class.
     */
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
