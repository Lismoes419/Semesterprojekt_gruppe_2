package GameLogic;

import java.util.*;

public class Room
{
    //Opretter beskrivelse og hashmap
    private String description;
    private HashMap<String, Room> exits;
    private Lock lock;

    //Lister
    private ArrayList<Garbage> itemList = new ArrayList<Garbage>();
    
    //Constructor der tager String som argument
    public Room(String description) 
    {
        this.description = description; //Sætter objectets beskrivelse = parameter beskrivelse
        exits = new HashMap<String, Room>(); //Opretter nyt hashmap kaldet "exits"
    }
    public Room(String description, ItemLock itemLock) 
    {
        this.lock = itemLock;
        this.description = description; //Sætter objectets beskrivelse = parameter beskrivelse
        exits = new HashMap<String, Room>(); //Opretter nyt hashmap kaldet "exits"
    }
    public Room(String description, PointLock pointLock) 
    {
        this.lock = pointLock;
        this.description = description; //Sætter objectets beskrivelse = parameter beskrivelse
        exits = new HashMap<String, Room>(); //Opretter nyt hashmap kaldet "exits"
    }

    //Function der laver nyt exit. Parametre: hvilken retning fra nuværende rum, til hvilket rum
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor); //Laver nyt exit
        
    }

    //Returnerer exit i bestemt retning
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public boolean hasLock()
    {
        if(lock != null)
        {
            return true;
        }
        return false;
    }
    public Lock getLock()
    {
        return lock;
    }
    
    public boolean isLocked()
    {
        return lock.isLocked();
    }
    
    
    @Override
    public String toString()
    {
        return description;
    }
}

