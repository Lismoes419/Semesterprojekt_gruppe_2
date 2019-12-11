package GameLogic;
import java.util.ArrayList;
import java.lang.reflect.*;

public class Player {
    private int points = 0;
    private ArrayList<Garbage> inventory = new ArrayList<Garbage>();
    private ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    

    public void addItem(Garbage garbage)
    {
        ItemDatabase database = new ItemDatabase();
        
        //Loop igennem inventory
        for (int i = 0; i < inventory.size(); i++)
        {
            //Check om vi har et lign. objekt
            if(inventory.get(i).getName().equals(garbage.getName()))
            {
                //Hvis vi har, tilføj opsamlet amount til amount af item i inv
                inventory.get(i).addAmount(database.getItem(garbage.getName()).getAmount());
                return; //Stop metode
            }
        }
        
        Garbage item = new Garbage(garbage.getName(), garbage.getAmount(), garbage.getIcon(), garbage.getSortingID());
        //System.out.println("Created new item: " + item.getName() + "(" + item.getAmount() + ")");
        inventory.add(item);
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
    
    public void removeItem(Garbage garbage)
    {
        inventory.remove(garbage);
    }
    
    public Garbage getItem(String name)
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            if(inventory.get(i).getName().equals(name))
            {
                return inventory.get(i);
            }
        }
        
        return null;
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
    
    public ArrayList<Garbage> getInventory()
    {
        return inventory;
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
