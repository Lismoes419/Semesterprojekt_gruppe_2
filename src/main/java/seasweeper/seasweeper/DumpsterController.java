package seasweeper.seasweeper;

import GameLogic.Garbage;
import GameLogic.ItemDatabase;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class DumpsterController implements Initializable {

    private ImageView selection;
    private boolean selected = false;
    @FXML private ImageView dumpster_1;
    @FXML private ImageView dumpster_2;
    @FXML private ImageView dumpster_3;
    @FXML private AnchorPane inventory;
    @FXML private GridPane gridPane;
    @FXML private Button primary;
    @FXML private TextField pointsLabel;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayInventory();
        
        updatePoints();
    }
    
    private void selectItem(MouseEvent event)
    {
        if(!selected)
        {
            selection = (ImageView)event.getSource();
            
            selection.setFitWidth(selection.getFitWidth() * 1.2);
            selection.setFitHeight(selection.getFitHeight()* 1.2);
            selected = true;
        }
    }
    
    @FXML
    private void sort(MouseEvent event)
    {
        if(!selected)
        {
            return; //Stop metode
        }
        ImageView image = (ImageView)event.getSource();
        
        ItemDatabase database = new ItemDatabase();
        Garbage item = App.getGame().getPlayer().getItem(selection.getId());
        //Dumpster ID
        String[] parts = image.getId().split("_");
        int dumpsterID = Integer.parseInt(parts[1]);
        
        //Check if right
        if(item.getSortingID() == dumpsterID)
        {
            //We did it bois
            App.getGame().getPlayer().addPoints(item.getAmount());
        } else{
            //We didn't do it bois
            System.out.println("0 points");
        }
        
        //Remove Item
        gridPane.getChildren().remove(selection);
        selection = null;
        selected = false;
        
        App.getGame().getPlayer().removeItem(item);
        updatePoints();
    }
    
    @FXML
    private void OnMouseEnter(MouseEvent event)
    {
        ImageView image = (ImageView)event.getSource();
        image.setOpacity(100);
    }

    @FXML
    private void OnMouseExit(MouseEvent event)
    {
        ImageView image = (ImageView)event.getSource();
        image.setOpacity(0);
    }
    
    public void displayInventory()
    {
        ArrayList<Garbage> inventoryCopy = new ArrayList<>(App.getGame().getPlayer().getInventory());
        int index = 0;
        
        //Check om inventory size == 0
        if(inventoryCopy.size() != 0)
        {
            //Loop gennem inventoryCopy
            for(Garbage gb : inventoryCopy)
            {
                //Lav nyt imageview
                ImageView iv = new ImageView();
                
                //Ændre ikon, id, position
                File iconURL = new File(gb.getIcon());
                Image icon = new Image(iconURL.toURI().toString());
                iv.setImage(icon);
                
                //Id
                iv.setId(gb.getName());
                
                //Størrelse
                iv.setFitWidth(75);
                iv.setFitHeight(75);
                
                //Poisition
                gridPane.add(iv, 0, index);
                gridPane.setAlignment(Pos.CENTER);
                
                //Set OnClick
                iv.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        selectItem(event);
                        event.consume();
                    }
                });
                
                index++;
            }
        }
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
    
    
    private void updatePoints()
    {
        pointsLabel.setText("Points: " + App.getGame().getPlayer().getPoints());
    }
}
