package GameLogic;
import java.util.ArrayList;
import java.lang.reflect.*;

public class Player {
    private int points = 0;
    private ArrayList<Garbage> inventory = new ArrayList<Garbage>();
    private ArrayList<Item> equipment = new ArrayList<Item>();
    

    public void addItem(Garbage garbage)
    {
        inventory.add(garbage);
    }
    public void addItem(Command command, Room room)
    {
        if(!command.hasSecondWord()) { //Hvis vores kommando IKKE har 2 ord
            System.out.println("Pick up what?");
            return; //stop metode
        }
         
        String item = command.getSecondWord();
        
        //Check om item er i rummet
        if(!room.hasRoomItem(item))
        {
            System.err.println("Couldn't find this item");
            return; //Stop metode
        }
        
        System.out.println("You picked up " + item);
        
        //Loop igennem inventory
        for (int i = 0; i < inventory.size(); i++)
        {
            //Check om vi har et lign. objekt
            if(inventory.get(i).getName().equals(item))
            {
                //Hvis vi har, tilføj opsamlet amount til amount af item i inv
                inventory.get(i).addAmount(room.getRoomItem(item).getAmount());
                room.removeRoomItem(room.getRoomItem(item));
                return; //Stop metode
            }
        }
        
        inventory.add(room.getRoomItem(item));
        room.removeRoomItem(room.getRoomItem(item));
    }
    
    public String getAllItems()
    {
        if(inventory.size() == 0)
        {
            return "Your inventory is empty!";
        }
        
        String returnString = "Inventory:";
        for(int i = 0; i < inventory.size(); i++)
        {
            if(i == 0)
            {
                returnString += " " + inventory.get(i).getName() + "(" + inventory.get(i).getAmount() + ")";
            } else
            {
                returnString += ", " + inventory.get(i).getName() + "(" + inventory.get(i).getAmount() + ")";
            }
        }
        
        return returnString;
        //System.out.println(returnString);
    }
    
    public void removeItem(Garbage garbage, Room room)
    {
        room.setRoomItem(garbage);
        inventory.remove(garbage);
    }
    public void emptyInventory()
    {
        inventory.clear();
    }
    
    public int getInventoryValue()
    {
        int value = 0;
        for(int i = 0; i < inventory.size(); i++)
        {
            value += inventory.get(i).getAmount();
        }
        
        return value;
    }
    
    public boolean hasEquipment(Equipment item)
    {
        for(int i = 0; i < equipment.size(); i++)
        {
            if(equipment.get(i).getName().equals(item.getName()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public void addEquipment(Equipment item)
    {
        equipment.add(item);
    }
    
    public int getPoints()
    {
        return points;
    }
    public void addPoints(int amt)
    {
        this.points += amt;
        //System.out.println("You now have " + points + " points");
    }
    public void removePoints(int amt)
    {
        this.points -= amt;
    }
}
