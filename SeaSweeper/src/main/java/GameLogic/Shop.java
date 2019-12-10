package GameLogic;

import java.util.ArrayList;

public class Shop extends Room{
    
    //Variables
    public ArrayList<Equipment> list = new ArrayList<>();
    ItemDatabase database = new ItemDatabase();
    
    public Shop(String description)
    {
        super(description);
    }
    
    public void addEquipment(Equipment equipment)
    {
        Equipment item = new Equipment(equipment.getName(), equipment.getPrice(), equipment.getIcon());
        list.add(item);
    }
    
    public String getList()
    {
        String returnString = "For sale: ";
        
        for (int i = 0; i < list.size(); i++)
        {
            if(i == 0)
            {
                returnString += list.get(i).getName() + "(" + list.get(i).getPrice() + ")";
            } else {
                returnString += ", " + list.get(i).getName() + "(" + list.get(i).getPrice() + ")";
            }
        }
        
        return returnString;
    }
    
    /*
    public void buy(Command command, Player player)
    {
        if(!command.hasSecondWord()) { //Hvis vores kommando IKKE har 2 ord
            System.out.println("Buy what?");
            return; //stop metode
        }
        
        String equipment = command.getSecondWord();
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getName().equals(equipment))
            {
                //Check if the player has enough points
                if(player.getPoints() >= list.get(i).getPrice())
                {
                    //Print
                    System.out.println("You bought " + equipment + " for " + list.get(i).getPrice() + " points!");
                    //Subtrackt points from player
                    player.removePoints(list.get(i).getPrice());
                    //Add to players equipment list
                    player.addEquipment(list.get(i));
                    //Remove from this list
                    list.remove(i);
                    
                    System.out.println(player.getPoints());
                    return; //Stop metode
                } else{
                    System.out.println("You do not have enough points to buy this item");
                    return; //Stop metode
                }
            }
        }
        
        System.out.println("Sorry, we don't have that item in stock");
    }*/
    
    public void buy(String equipment, Player player)
    {
        for (int i = 0; i < database.equipment.size(); i++)
        {
            if(equipment.equals(database.equipment.get(i).getName()))
            {
                if(player.getPoints() >= database.equipment.get(i).getPrice() && !player.hasEquipment(database.equipment.get(i)))
                {
                    //Buy equipment
                    //Print
                    System.out.println("You bought " + equipment + " for " + list.get(i).getPrice() + " points!");
                    //Subtrackt points from player
                    player.removePoints(list.get(i).getPrice());
                    //Add to players equipment list
                    player.addEquipment(list.get(i));
                    return; //Stop metode
                    
                } else{
                    System.out.println("Sorry, you do not have enough points to buy this item");
                    return; //Stop metode
                }
            }
        }
    }
}
