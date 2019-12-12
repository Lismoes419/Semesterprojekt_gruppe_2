package seasweeper.seasweeper;


import GameLogic.ItemDatabase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ShopController implements Initializable {


    @FXML private ImageView oxygenTank;
    @FXML private ImageView suit;
    @FXML private ImageView goggles;
    @FXML private ImageView fins;
    @FXML private Button primary;
    @FXML private TextField suitText;
    @FXML private TextField tankText;
    @FXML private TextField finsText;
    @FXML private TextField gogglesText;
    @FXML private TextField pointsLabel;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hasEquipment();
        updatePoints();
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
    
    @FXML
    private void buy(MouseEvent event)
    {
        ImageView image = (ImageView) event.getSource();
        String equipment = image.getId();
        
        App.getGame().shop.buy(equipment, App.getGame().getPlayer());
        
        //Update
        hasEquipment();
        updatePoints();
    }
    
    
    private void hasEquipment()
    {
        ItemDatabase database = new ItemDatabase();
        
        if(App.getGame().getPlayer().hasEquipment(database.Suit))
        {
            //Change price to owned
            suitText.setText("Owned");
        }
        if(App.getGame().getPlayer().hasEquipment(database.OxygenTank))
        {
            //Change price to owned
            tankText.setText("Owned");
        }
        if(App.getGame().getPlayer().hasEquipment(database.Fins))
        {
            //Change price to owned
            finsText.setText("Owned");
        }
        if(App.getGame().getPlayer().hasEquipment(database.Goggles))
        {
            //Change price to owned
            gogglesText.setText("Owned");
        }
    }
    
    private void updatePoints()
    {
        pointsLabel.setText("Points: " + App.getGame().getPlayer().getPoints());
    }
}
