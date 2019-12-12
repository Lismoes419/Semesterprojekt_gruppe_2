package GameLogic;

import GameLogic.Player;
import java.util.ArrayList;
import Presentation.GameInterface;
import javafx.application.Platform;

public class Game implements GameInterface
{
    //Attributter
    //private Parser parser; //Parser (input)
    private Room currentRoom; //currentRoom = nuværende rum
    private Player player = new Player(); //Ny player (med inventory)
    private ArrayList<Room> roomList = new ArrayList<>(); //Liste af rum
    private ItemDatabase database = new ItemDatabase(); //Item database
    
    //Game metode
    public Game()
    {
        createRooms(); //Kalder createRooms() metode
        //parser = new Parser(); //Laver ny parser der ikke tager nogen parametre
    }
    
    public Room primary, dumpster, pacific, atlantic, indian, arctic, southern; //Laver nye (tomme) rum
    public Shop shop;
    
    //CreateRooms metode
    private void createRooms()
    {
        //Laver objekterne til rummene, der tager en beskrivelse som parameter
        primary = new Room("in the main area");
        dumpster = new Room("next to a dumpster. Here you can recycle your collected plastic");
        shop = new Shop("in the shop. Here you can buy equipment");
        southern = new Room("in the Southern Ocean");
        indian = new Room("in the Indian Ocean", new ItemLock(database.Goggles));
        pacific = new Room("in the Pacific Ocean", new PointLock(25));
        atlantic = new Room("in the Atlantic Ocean", new ItemLock(database.OxygenTank));
        arctic = new Room("in the Arctic Ocean", new PointLock(80));
        
        
        //Add rooms to list
        roomList.add(pacific);
        roomList.add(atlantic);
        roomList.add(indian);
        roomList.add(arctic);
        roomList.add(southern);
        
        //Laver exits til alle vores rum (tager retning og nyt rum vi kommer til)
        // <editor-fold defaultstate="collapsed" desc=" EXITS ">
        primary.setExit("southern", southern);
        primary.setExit("pacific", pacific);
        primary.setExit("atlantic", atlantic);
        primary.setExit("indian", indian);
        primary.setExit("arctic", arctic);
        primary.setExit("dumpster", dumpster);
        primary.setExit("shop", shop);

        
        dumpster.setExit("primary", primary);
        dumpster.setExit("pacific", pacific);
        dumpster.setExit("atlantic", atlantic);
        dumpster.setExit("indian", indian);
        dumpster.setExit("southern", southern);
        dumpster.setExit("arctic", arctic);
        dumpster.setExit("shop", shop);
        
        shop.setExit("primary", primary);
        shop.setExit("pacific", pacific);
        shop.setExit("atlantic", atlantic);
        shop.setExit("indian", indian);
        shop.setExit("southern", southern);
        shop.setExit("arctic", arctic);
        shop.setExit("dumpster", dumpster);

        southern.setExit("primary", primary);
        southern.setExit("pacific", pacific);
        southern.setExit("atlantic", atlantic);
        southern.setExit("indian", indian);
        southern.setExit("dumpster", dumpster);
        southern.setExit("shop", shop);
        
        pacific.setExit("primary", primary);
        pacific.setExit("arctic", arctic);
        pacific.setExit("atlantic", atlantic);
        pacific.setExit("indian", indian);
        pacific.setExit("dumpster", dumpster);
        pacific.setExit("shop", shop);

        
        atlantic.setExit("primary", primary);
        atlantic.setExit("arctic", arctic);
        atlantic.setExit("pacific", pacific);
        atlantic.setExit("indian", indian);
        atlantic.setExit("dumpster", dumpster);
        atlantic.setExit("shop", shop);

        
        indian.setExit("primary", primary);
        indian.setExit("arctic", arctic);
        indian.setExit("atlantic", atlantic);
        indian.setExit("pacific", pacific);
        indian.setExit("dumpster", dumpster);
        indian.setExit("shop", shop);

        arctic.setExit("primary", primary);
        arctic.setExit("atlantic", atlantic);
        arctic.setExit("pacific", pacific);
        arctic.setExit("dumpster", dumpster);
        arctic.setExit("shop", shop);

        // </editor-fold>
        
        
        //Sætter vores nuværende rum til et af de rum vi har oprettet
        currentRoom = primary;
    }
    
    @Override
    public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction); //nyt rum = nuværende rum.getExit(retning)
        
        try{
            currentRoom = nextRoom;
        } catch(NullPointerException e){
            System.out.println("No such exit");
        }
    }
    
    @Override
    public void unlockRooms()
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            if(!roomList.get(i).hasLock())
            {
                continue; //Stop denne iteration
            }
            
            roomList.get(i).getLock().unlock(player);
        }
    }

    @Override
    public Player getPlayer()
    {
        return player;
    }

    @Override
    public void quit()
    {
        Platform.exit();
    }
    
    @Override
    public void pickup(String name)
    {
        player.addItem(database.getItem(name));
    }
}
