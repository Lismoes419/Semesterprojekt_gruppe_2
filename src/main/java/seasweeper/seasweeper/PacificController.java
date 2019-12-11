package seasweeper.seasweeper;

import GameLogic.Garbage;
import GameLogic.ItemDatabase;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class PacificController implements Initializable {
    
    @FXML private ImageView Item_01;
    @FXML private ImageView Item_02;
    @FXML private ImageView Item_03;
    @FXML private ImageView Item_04;
    @FXML private ImageView Item_05;
    @FXML private ImageView Item_06;
    @FXML private ImageView Item_07;
    @FXML private ImageView Item_08;
    @FXML private ImageView Item_09;
    @FXML private ImageView Item_10;
    @FXML private ImageView Item_11;
    @FXML private ImageView Item_12;
    @FXML private ImageView Item_13;
    @FXML private ImageView Item_14;
    @FXML private ImageView Item_15;
    @FXML private ImageView Item_16;
    @FXML private ImageView Item_17;
    @FXML private ImageView Item_18;
    @FXML private ImageView Item_19;
    @FXML private ImageView Item_20;
    @FXML private AnchorPane anchorPane;
    private ArrayList<ImageView> items = new ArrayList<ImageView>();
    @FXML private Button primary;
    @FXML private Pane pacificComplete;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        items.add(Item_01);
        items.add(Item_02);
        items.add(Item_03);
        items.add(Item_04);
        items.add(Item_05);
        items.add(Item_06);
        items.add(Item_07);
        items.add(Item_08);
        items.add(Item_09);
        items.add(Item_10);
        items.add(Item_11);
        items.add(Item_12);
        items.add(Item_13);
        items.add(Item_14);
        items.add(Item_15);
        items.add(Item_16);
        items.add(Item_17);
        items.add(Item_18);
        items.add(Item_19);
        items.add(Item_20);
        
        
        instantiate();
    }
    
    private void switchToPrimary() throws IOException
    {
        App.setRoot("primary");
    }

    @FXML
    private void pickup(MouseEvent event) {
        ImageView image = (ImageView)event.getSource(); //Get source (which image was clicked?)
        String itemName = image.getId(); //Save id
        
        App.getGame().pickup(itemName); //Add Item to inventory
        anchorPane.getChildren().remove(image); //Remove image
        
        //Remove item from list
        for (int i = 0; i < items.size(); i++)
        {
            if(items.get(i).equals(image))
            {
                items.remove(i);
            }
        }
        
        //Check if room is empty
        isEmpty();
    }

    @FXML
    private void go(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String direction = btn.getId();
        
        App.getGame().goRoom(direction);
        
        try{
        App.setRoot(direction);
        } catch (IOException e){
            System.out.println("No such room");
        }
    }
    
    private void getInventory()
    {
        App.getGame().getPlayer().getAllItems();
    }
    
    private void instantiate()
    {
        ItemDatabase database = new ItemDatabase();
        
        //Loop op til amt
        for (int i = 0; i < items.size(); i++)
        {
            double x = 50 + (900 - 50) * Math.random();
            double y = 400 + (720 - 400) * Math.random();
            //System.out.println(x + "," + y);
            //Set Position
            items.get(i).setX(x);
            items.get(i).setY(y);
            Garbage randomItem = database.randomItem();
            //Add icon
            File iconURL = new File(randomItem.getIcon());
            Image icon = new Image(iconURL.toURI().toString());
            items.get(i).setImage(icon);
            //Set name
            items.get(i).setId(randomItem.getName());
            
            //System.out.println("Item_" + i + " is at (" + x + "," + y + ")");
        }
    }
    
    
    public void isEmpty()
    {
        if(items.size() == 0)
        {
            //System.out.println("WIN");
            pacificComplete.setDisable(false);
            pacificComplete.setVisible(true);
        }
    }
}
