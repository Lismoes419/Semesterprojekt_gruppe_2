package seasweeper.seasweeper;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import GameLogic.Command;
import GameLogic.CommandWord;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PrimaryController implements Initializable{

    @FXML private ImageView pacific;
    @FXML private ImageView indian;
    @FXML private ImageView southern;
    @FXML private ImageView atlantic;
    @FXML private ImageView arctic;
    @FXML
    private Button shop;
    @FXML
    private Button dumpster;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        App.getGame().unlockRooms();
        isLocked();
    }
    
    private void getInventory()
    {
        App.getGame().getPlayer().getAllItems();
    }
    
    private void quit()
    {
        App.getGame().quit();
    }

    @FXML
    private void OnMouseOver(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        File file = new File("/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/glow.png");
        Image lightImage = new Image(file.toURI().toString());
        
        image.setImage(lightImage);
    }

    @FXML
    private void OnMouseExit(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        File file = new File("/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/notGlow.png");
        Image lightImage = new Image(file.toURI().toString());
        
        image.setImage(lightImage);
    }

    @FXML
    private void go(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        String direction = image.getId();
        
        App.getGame().goRoom(direction);
        
        try{
        App.setRoot(direction);
        } catch (IOException e){
            System.out.println("No such room");
        }
    }
    
    public void isLocked()
    {
        File file = new File("./resources/locked.png");
        Image locked = new Image(file.toURI().toString());
        
        if(App.getGame().southern.hasLock() && (App.getGame().southern.isLocked()))
        {
            southern.setImage(locked);//Change image
            southern.setMouseTransparent(false);//Disable mouse transparency
        }
        if(App.getGame().indian.hasLock() && App.getGame().indian.isLocked())
        {
            indian.setImage(locked);//Change image
            indian.setMouseTransparent(true);//Disable mouse transparency
        }
        if(App.getGame().pacific.isLocked())
        {
            pacific.setImage(locked);//Change image
            pacific.setMouseTransparent(true);//Disable mouse transparency
        }
        if(App.getGame().atlantic.isLocked())
        {
            atlantic.setImage(locked);//Change image
            atlantic.setMouseTransparent(true);//Disable mouse transparency
        }
        if(App.getGame().arctic.isLocked())
        {
            arctic.setImage(locked);//Change image
            arctic.setMouseTransparent(true);//Disable mouse transparency
        }
    }

    @FXML
    private void goButton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String direction = btn.getId();
        
        App.getGame().goRoom(direction);
        
        try{
        App.setRoot(direction);
        } catch (IOException e){
            System.out.println("No such room");
        }
    }
}
