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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable{

    @FXML private ImageView pacific;
    @FXML private ImageView indian;
    @FXML private ImageView southern;
    @FXML private ImageView atlantic;
    @FXML private ImageView arctic;
    @FXML private Button shop;
    @FXML private Button dumpster;
    @FXML private Button mainMenu;
    @FXML private TextField pointsLabel;
    
    @FXML private ImageView indianReq;
    @FXML private ImageView atlanticReq;
    @FXML private Text arcticReq;
    @FXML private Text pacificReq;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        App.getGame().unlockRooms();
        isLocked();
        
        pointsLabel.setText("Points: " + App.getGame().getPlayer().getPoints());
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
        File file = new File("./resources/glow.png");
        
        if(image.getId().equals("southern"))
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("indian") && App.getGame().indian.isLocked())
        {
            //Do something
            indianReq.setVisible(true);
            indianReq.setDisable(false);
        } else if(image.getId().equals("indian") && !App.getGame().indian.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("pacific") && App.getGame().pacific.isLocked())
        {
            //Do something
            pacificReq.setVisible(true);
            pacificReq.setDisable(false);
        } else if(image.getId().equals("pacific") && !App.getGame().pacific.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("atlantic") && App.getGame().atlantic.isLocked())
        {
            //Do something
            atlanticReq.setVisible(true);
            atlanticReq.setDisable(false);
        } else if(image.getId().equals("atlantic") && !App.getGame().atlantic.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("arctic") && App.getGame().arctic.isLocked())
        {
            //Do something
            arcticReq.setVisible(true);
            arcticReq.setDisable(false);
        } else if(image.getId().equals("arctic") && !App.getGame().arctic.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
    }

    @FXML
    private void OnMouseExit(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        File file = new File("./resources/notGlow.png");
        
        if(image.getId().equals("southern"))
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("indian") && App.getGame().indian.isLocked())
        {
            //Do something
            indianReq.setVisible(false);
            indianReq.setDisable(true);
        } else if(image.getId().equals("indian") && !App.getGame().indian.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("pacific") && App.getGame().pacific.isLocked())
        {
            //Do something
            pacificReq.setVisible(false);
            pacificReq.setDisable(true);
        } else if(image.getId().equals("pacific") && !App.getGame().pacific.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("atlantic") && App.getGame().atlantic.isLocked())
        {
            //Do something
            atlanticReq.setVisible(false);
            atlanticReq.setDisable(true);
        } else if(image.getId().equals("atlantic") && !App.getGame().atlantic.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
        if(image.getId().equals("arctic") && App.getGame().arctic.isLocked())
        {
            //Do something
            arcticReq.setVisible(false);
            arcticReq.setDisable(true);
        } else if(image.getId().equals("arctic") && !App.getGame().arctic.isLocked())
        {
            Image lightImage = new Image(file.toURI().toString());
            image.setImage(lightImage);
        }
    }

    @FXML
    private void go(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        String direction = image.getId();
        
        if(direction.equals("southern"))
        {
            App.getGame().goRoom(direction);
            
            try{
                App.setRoot(direction);
            } catch (IOException e){
                System.out.println("No such room");
            }
        }
        if(direction.equals("indian") && !App.getGame().indian.isLocked())
        {
            App.getGame().goRoom(direction);
            
            try{
                App.setRoot(direction);
            } catch (IOException e){
                System.out.println("No such room");
            }
        }
        if(direction.equals("pacific") && !App.getGame().pacific.isLocked())
        {
            App.getGame().goRoom(direction);
            
            try{
                App.setRoot(direction);
            } catch (IOException e){
                System.out.println("No such room");
            }
        }
        if(direction.equals("atlantic") && !App.getGame().atlantic.isLocked())
        {
            App.getGame().goRoom(direction);
            
            try{
                App.setRoot(direction);
            } catch (IOException e){
                System.out.println("No such room");
            }
        }
        if(direction.equals("arctic") && !App.getGame().arctic.isLocked())
        {
            App.getGame().goRoom(direction);
            
            try{
                App.setRoot(direction);
            } catch (IOException e){
                System.out.println("No such room");
            }
        }
    }
    
    public void isLocked()
    {
        File file = new File("./resources/locked.png");
        Image locked = new Image(file.toURI().toString());
        
        if(App.getGame().southern.hasLock() && (App.getGame().southern.isLocked()))
        {
            southern.setImage(locked);//Change image
        }
        if(App.getGame().indian.hasLock() && App.getGame().indian.isLocked())
        {
            indian.setImage(locked);//Change image
        }
        if(App.getGame().pacific.isLocked())
        {
            pacific.setImage(locked);//Change image
        }
        if(App.getGame().atlantic.isLocked())
        {
            atlantic.setImage(locked);//Change image
        }
        if(App.getGame().arctic.isLocked())
        {
            arctic.setImage(locked);//Change image
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
