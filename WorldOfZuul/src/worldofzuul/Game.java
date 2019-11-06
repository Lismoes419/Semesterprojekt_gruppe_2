package worldofzuul;

import java.util.ArrayList;

public class Game 
{
    //Ny parser og nyt rum (currentRoom = nuværende rum)
    private Parser parser;
    private Room currentRoom;
    private Player player = new Player();
    private ArrayList<Room> roomList = new ArrayList<>();
    
    
    //Game metode
    public Game()
    {
        createRooms(); //Kalder createRooms() metode
        //createItems(); //Kalder createItems() metode
        parser = new Parser(); //Laver ny parser der ikke tager nogen parametre
    }
    
    public Room map, dumpster, pacific, atlantic, indian, arctic, southern; //Laver nye (tomme) rum
    
    //CreateRooms metode
    private void createRooms()
    {
        //Laver objekterne til rummene, der tager en beskrivelse som parameter
        map = new Room("in the main area");
        dumpster = new Room("next to a dumpster. Here you can recycle your collected plastic");
        pacific = new Room("in the Pacific Ocean", new PointLock(1));
        atlantic = new Room("in the Atlantic Ocean", new PointLock(10));
        indian = new Room("in the Indian Ocean", new PointLock(15));
        arctic = new Room("in the Arctic Ocean", new PointLock(20));
        southern = new Room("in the Southern Ocean");
        
        //Add rooms to list
        roomList.add(pacific);
        roomList.add(atlantic);
        roomList.add(indian);
        roomList.add(arctic);
        roomList.add(southern);
        
        //Laver exits til alle vores rum (tager retning og nyt rum vi kommer til)
        // <editor-fold defaultstate="collapsed" desc=" EXITS ">
        map.setExit("southern", southern);
        map.setExit("pacific", pacific);
        map.setExit("atlantic", atlantic);
        map.setExit("indian", indian);
        map.setExit("arctic", arctic);
        map.setExit("dumpster", dumpster);
        
        dumpster.setExit("map", map);
        dumpster.setExit("pacific", pacific);
        dumpster.setExit("atlantic", atlantic);
        dumpster.setExit("indian", indian);
        dumpster.setExit("southern", southern);
        dumpster.setExit("arctic", arctic);
        
        southern.setExit("map", map);
        southern.setExit("pacific", pacific);
        southern.setExit("atlantic", atlantic);
        southern.setExit("indian", indian);
        southern.setExit("dumpster", dumpster);
        
        pacific.setExit("map", map);
        pacific.setExit("arctic", arctic);
        pacific.setExit("atlantic", atlantic);
        pacific.setExit("indian", indian);
        pacific.setExit("dumpster", dumpster);

        atlantic.setExit("map", map);
        atlantic.setExit("arctic", arctic);
        atlantic.setExit("pacific", pacific);
        atlantic.setExit("indian", indian);
        atlantic.setExit("dumpster", dumpster);

        indian.setExit("map", map);
        indian.setExit("arctic", arctic);
        indian.setExit("atlantic", atlantic);
        indian.setExit("pacific", pacific);
        indian.setExit("dumpster", dumpster);

        arctic.setExit("map", map);
        arctic.setExit("atlantic", atlantic);
        arctic.setExit("pacific", pacific);
        arctic.setExit("dumpster", dumpster);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" ITEMS ">
        //Tilføj items
        //Pacific
        pacific.setRoomItem(new Item("bottles", 5));
        
        //Southern
        southern.setRoomItem(new Item("can", 1));
        southern.setRoomItem(new Item("bag", 1));
        southern.setRoomItem(new Item("bottles", 2));
        
        //Atlantic
        atlantic.setRoomItem(new Item("can", 2));
        atlantic.setRoomItem(new Item("garbage", 20));
        atlantic.setRoomItem(new Item("jug", 1));
        atlantic.setRoomItem(new Item("bottle", 1));
        
        //Indian
        indian.setRoomItem(new Item("net", 2));
        indian.setRoomItem(new Item("garbage", 15));
        indian.setRoomItem(new Item("bottle", 1));
        indian.setRoomItem(new Item("straw", 2));
        
        //Arctic
        arctic.setRoomItem(new Item("net", 2));
        arctic.setRoomItem(new Item("garbage", 12));
        arctic.setRoomItem(new Item("bag", 1));
        arctic.setRoomItem(new Item("bottle", 1));
        // </editor-fold>
        
        //Sætter vores nuværende rum til et af de rum vi har oprettet
        currentRoom = map;
    }
    
    //Play metode
    public void play() 
    {            
        printWelcome(); //printWelcome metode

                
        boolean finished = false; //ny boolean = false
        while (! finished) { //mens finished = false (Loop indtil finished = true)
            Command command = parser.getCommand(); //Ny kommando = vores text input
            finished = processCommand(command); //Hvis vi skriver quit vil processCommand returnere true og finished vil blive true
        }
        System.out.println("Thank you for playing.  Good bye."); //Når finished = true ryger vi ud af vores loop (IKKE FØR), og vi er færdige med spillet
    }

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
        else if (commandWord == CommandWord.GO) { //hvis vi skriver "go"
            goRoom(command); //Kald metode
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
            Dumpster();
        }
        else if(commandWord == CommandWord.EXITS) {
            System.out.println(currentRoom.getExitString());
        }
        return wantToQuit; //returnerer boolean
    }

    //printHelp metode
    private void printHelp() 
    {
        System.out.println("You are in " + currentRoom);
        System.out.println("Try to collect garbage enough to unlock the next room");
        System.out.println(); //ny linje
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    //goRoom metode (tager Command som parameter)
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) { //Hvis vores kommando IKKE har 2 ord
            System.out.println("Go where?");
            return; //stop metode
        }

        String direction = command.getSecondWord(); //ny string der indeholder vores 2. ord (retning)

        Room nextRoom = currentRoom.getExit(direction); //nyt rum = nuværende rum.getExit(retning)
        
        //Hvis næste rum er locked
        if(nextRoom.hasLock() && nextRoom.getLock().isLocked())
        {
            System.out.println("Room is locked, you need " + nextRoom.getLock().getCondition() + "points");
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
    
    //dumpster metode
    public void Dumpster()
    {
        //Check om vi er i det forkerte rum
        if(currentRoom != dumpster)
        {
            System.out.println("You are currently not located by the dumpster"); //Print at vi er i det forkerte rum
            return; //Stop metode
        }
        
        player.addPoints(player.getInventoryValue()); //Tilføj point
        player.emptyInventory(); //Tøm inventory
        
        //Loop igennem alle rum
        for(int i = 0; i < roomList.size(); i++)
        {
            if(!roomList.get(i).hasLock())
            {
                return; //Stop metode
            }
            
            //Unlock rum
            roomList.get(i).getLock().unlock(player);
        }
    }
}
