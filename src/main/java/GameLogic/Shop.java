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
    
    public void buy(String equipment, Player player)
    {
        for (int i = 0; i < database.equipment.size(); i++)
        {
            if(equipment.equals(database.equipment.get(i).getName()))
            {
                if(!player.hasEquipment(database.equipment.get(i)) && player.getPoints() >= database.equipment.get(i).getPrice())
                {
                    player.removePoints(database.equipment.get(i).getPrice());
                    player.addEquipment(database.equipment.get(i));
                } else{
                    System.out.println("Not enough points");
                }
            }
        }
    }
}
