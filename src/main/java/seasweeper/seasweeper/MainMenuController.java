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
/**
 * FXML Controller class
 *
 * @author jakobrasmussen
 */
public class MainMenuController implements Initializable {


    @FXML
    private Button quit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //System.out.println(new File(".").getAbsolutePath());
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
}
