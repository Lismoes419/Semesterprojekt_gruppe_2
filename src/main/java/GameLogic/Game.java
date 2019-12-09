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
        pacific = new Room("in the Pacific Ocean", new PointLock(20));
        atlantic = new Room("in the Atlantic Ocean", new PointLock(60));
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
        
        // <editor-fold defaultstate="collapsed" desc=" ITEMS ">
        //Tilføj items
        //Pacific
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        pacific.setRoomItem(database.bottle);
        
        //Southern
        southern.setRoomItem(database.bottle);
        southern.setRoomItem(database.randomItem());
        southern.setRoomItem(database.randomItem());
        //southern.setRoomItem(database.bag);
        
        //Atlantic
        atlantic.setRoomItem(database.can);
        atlantic.setRoomItem(database.jug);
        atlantic.setRoomItem(database.bottle);
        
        //Indian
        indian.setRoomItem(database.fishingNet);
        indian.setRoomItem(database.plastic);
        indian.setRoomItem(database.bottle);
        indian.setRoomItem(database.straw);
        
        //Arctic
        arctic.setRoomItem(database.fishingNet);
        arctic.setRoomItem(database.plastic);
        arctic.setRoomItem(database.bag);
        arctic.setRoomItem(database.bottle);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" SHOP ">
        shop.addEquipment(database.Goggles);
        shop.addEquipment(database.Suit);
        shop.addEquipment(database.OxygenTank);
        
        // </editor-fold>
        
        
        //Sætter vores nuværende rum til et af de rum vi har oprettet
        currentRoom = primary;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" PLAY ">
    //Play metode
    /*public void play() 
    {            
        printWelcome(); //printWelcome metode

                
        boolean finished = false; //ny boolean = false
        while (! finished) { //mens finished = false (Loop indtil finished = true)
            Command command = parser.getCommand(); //Ny kommando = vores text input
            finished = processCommand(command); //Hvis vi skriver quit vil processCommand returnere true og finished vil blive true
            unlockRooms();
        }
        System.out.println("Thank you for playing.  Good bye."); //Når finished = true ryger vi ud af vores loop (IKKE FØR), og vi er færdige med spillet
    }*/
    // </editor-fold>

    //printWelcome metode
    private void printWelcome()
    {
        System.out.println(); //printer ny linje
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help."); //CommandWord.HELP = help (Se CommandWord script)
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    // <editor-fold defaultstate="collapsed" desc=" PROCESSCOMMAND ">
    //Boolean metode (SKAL returnere true eller false)
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false; //ny boolean = false

        CommandWord commandWord = command.getCommandWord(); //ny CommandWord objekt = getCommandWord metode

        if(commandWord == CommandWord.UNKNOWN) { //Hvis vi ikke kender kommandoen
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) { //hvis vi skriver "help"
            printHelp(); //Kald metode
        }
        else if (commandWord == CommandWord.BUY) { //hvis vi skriver "buy"
            if(currentRoom == shop){
                //shop.buy(command, player);
            } else{
                System.out.println("You are not in the shop");
            }
        }
        else if (commandWord == CommandWord.GO) { //hvis vi skriver "go"
            //goRoom(command); //Kald metode
        }
        else if (commandWord == CommandWord.QUIT) { //Hvis vi skriver quit
            wantToQuit = quit(command); //boolean = hvad quit(command) returnerer
        }
        else if (commandWord == CommandWord.PICKUP) {
            player.addItem(command, currentRoom);
        }
        else if(commandWord == CommandWord.INVENTORY) {
            player.getAllItems();
        }
        else if(commandWord == CommandWord.ROOMITEMS) {
            System.out.println(currentRoom.getRoomItems());
        }
        else if(commandWord == CommandWord.SORT) {
            dumpster();
        }
        else if(commandWord == CommandWord.EXITS) {
            System.out.println(currentRoom.getExitString());
        }
        
        return wantToQuit; //returnerer boolean
    }
    // </editor-fold>

    //printHelp metode
    private void printHelp() 
    {
        System.out.println("You are in " + currentRoom.toString());
        System.out.println("The aim of the game is to try to collect garbage enough to unlock the next room");
        System.out.println(); //ny linje
        System.out.println("Your command words are:");
        //parser.showCommands();
    }

    // <editor-fold defaultstate="collapsed" desc=" GOROOM ">
    //goRoom metode (tager Command som parameter)
    /*public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) { //Hvis vores kommando IKKE har 2 ord
            System.out.println("Go where?");
            return; //stop metode
        }

        String direction = command.getSecondWord(); //ny string der indeholder vores 2. ord (retning)

        Room nextRoom = currentRoom.getExit(direction); //nyt rum = nuværende rum.getExit(retning)
        
        try{
            if(nextRoom instanceof Shop)
            {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                
                Shop shopRoom = (Shop)nextRoom;
                System.out.println(shopRoom.getList());
            } else{
                //Hvis næste rum er locked
                if(nextRoom.hasLock() && nextRoom.getLock().isLocked())
                {
                    System.out.println("Room is locked, you need " + nextRoom.getLock().getCondition());
                    return; //Stop metode
                }
        
                if (nextRoom == null) { //Check om der er et nextRoom (vi kunne have skrevet forkert)
                    System.out.println("There is no door!");
                }
                else { //Ellers ændrer vi vores nuværende rum til det næste rum vi har valgt
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription()); //printer beskrivelse af det næste rum (som nu er vores nuværende)
                }
            }
        } catch(NullPointerException e){
            System.out.println("No such Room exists");
        }
    }*/
    // </editor-fold>
    
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
    
    // <editor-fold defaultstate="collapsed" desc=" QUIT ">
    //Quit metode (tager Command som parameter)
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) { //Hvis vi har mere end 1 ord
            System.out.println("Quit what?");
            return false;
        }
        else { //Hvis vi kun har 1 ord
            return true;
        }
    }
    // </editor-fold>
    
    //dumpster metode
    public void dumpster()
    {
        //Check om vi er i det forkerte rum
        if(currentRoom != dumpster)
        {
            System.out.println("You are currently not located by the dumpster"); //Print at vi er i det forkerte rum
            return; //Stop metode
        }
        
        player.addPoints(player.getInventoryValue()); //Tilføj point
        player.emptyInventory(); //Tøm inventory
        
        //unlockRooms();
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
    
    public void isLocked(Room room)
    {
        
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
        //Loop gennem database liste
        for (int i = 0; i < database.garbage.size(); i++)
        {
            //Check om navnet matcher
            if(name.equals(database.garbage.get(i).getName()))
            {
                //Tilføj item til player inventory
                player.addItem(database.garbage.get(i));
                player.addPoints(1);
            }
        }
    }
}
