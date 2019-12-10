/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.seasweeper;

import GameLogic.Garbage;
import GameLogic.ItemDatabase;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jakobrasmussen
 */
public class DumpsterController implements Initializable {

    private ImageView selection;
    private boolean selected = false;
    @FXML private ImageView dumpster_1;
    @FXML private ImageView dumpster_2;
    @FXML private ImageView dumpster_3;
    @FXML private AnchorPane inventory;
    @FXML private GridPane gridPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayInventory();
    }
    
    private void selectItem(MouseEvent event)
    {
        if(!selected)
        {
            selection = (ImageView)event.getSource();
            System.out.println(selection.getId());
            
            selection.setFitWidth(selection.getFitWidth() * 1.2);
            selection.setFitHeight(selection.getFitHeight()* 1.2);
            selected = true;
        }
    }
    private void deselectItem(MouseEvent event)
    {
        selection.setScaleX(selection.getFitWidth() / 1);
        selection.setScaleX(selection.getFitWidth() / 1);
        selection = null;
        selected = false;
    }
    
    @FXML
    private void sort(MouseEvent event)
    {
        ImageView image = (ImageView)event.getSource();
        String[] parts = image.getId().split("_");
        int dumpster = Integer.parseInt(parts[1]);
        
        ItemDatabase database = new ItemDatabase();
        Garbage item = database.getItem(selection.getId());
        int points = App.getGame().getPlayer().getItem(selection.getId()).getAmount();
        
        if(selected)
        {
            //Check if right
            if(item.getSortingID() == dumpster)
            {
                //
                System.out.println("+" + points +  "point(s)");
                App.getGame().getPlayer().addPoints(points);
            } else{
                //
                System.out.println("0 points");
            }
        } else{
            System.out.println("You haven't selected any item");
        }
        
        //Remove Item
        gridPane.getChildren().remove(selection);
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
}
