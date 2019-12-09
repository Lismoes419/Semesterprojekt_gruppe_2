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

    //Returner beskrivelse
    public String getShortDescription()
    {
        return description;
    }

    //Returner lang beskrivelse
    public String getLongDescription()
    {
        if(itemList.size() == 0)
        {
            return System.lineSeparator() + "You are " + description + ".\n" + getExitString();
        } else
        {
            return System.lineSeparator() + "You are " + description + ".\n" + getExitString() + System.lineSeparator() + getRoomItems(); //".\n" = ny linje
        }
    }

    //Returner alle exits i en string
    public String getExitString()
    {
        String returnString = "Exits:"; //Ny string der skal returneres
        Set<String> keys = exits.keySet(); //Hashmap funktion
        
        int counter = 0;
        for(String exit : keys) { //Foreach loop
            if(counter == 0)
            {
                returnString += " " + exit; //Lægger et mellemrum + navnet på et exit til vores returnString
                counter++;
            } else
            {
                returnString += ", " + exit; //Lægger et mellemrum + komma + navnet på et exit til vores returnString
            }
        }
        return returnString;
    }

    //Returnerer exit i bestemt retning
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void setRoomItem(Garbage garbage)
    {
        //Opret nyt objekt
        Garbage temp = new Garbage(garbage.getName(), garbage.getAmount(), garbage.getIcon());
        //Tilføj til itemList
        itemList.add(temp);
    }
    public void removeRoomItem(Garbage garbage)
    {
        for(int i = 0; i < itemList.size(); i++)
        {
            if(itemList.get(i).equals(garbage))
            {
                itemList.remove(i);
            }
        }
    }
    
    public boolean hasRoomItem(String name)
    {
        for(int i = 0; i < itemList.size(); i++)
        {
            if(itemList.get(i).getName().equals(name))
            {
                return true;
            }
        }
        
        System.out.println("There is no such item in this room");
        return false;
    }
    
    public Garbage getRoomItem(String name)
    {
        for(int i = 0; i < itemList.size(); i++)
        {
            if(itemList.get(i).getName().equals(name))
            {
                return itemList.get(i);
            }
        }
        
        System.out.println("There is no such item in this room");
        return null;
    }
    
    public String getRoomItems()
    {
        if(itemList.size() == 0)
        {
            System.out.println("There are no items in this room");
            return null;
        }
        
        String returnString = "Items:";
        for(int i = 0; i < itemList.size(); i++)
        {
            if(i == 0)
            {
                returnString += " " + itemList.get(i).getName() + "(" + itemList.get(i).getAmount() + ")";
            } else
            {
                returnString += ", " + itemList.get(i).getName() + "(" + itemList.get(i).getAmount() + ")";
            }
        }
        
        return returnString;
    }
    
    public int getListLength()
    {
        return itemList.size();
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

