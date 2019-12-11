package GameLogic;
import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    
    //List
    public ArrayList<Garbage> garbage = new ArrayList<Garbage>();
    public ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    
    //Garbage
    public Garbage bottle = new Garbage("bottle", 1, "./resources/bottle.png", 1);
    public Garbage bag = new Garbage("bag", 1, "./resources/bag.png", 1);
    public Garbage straw = new Garbage("straw", 1, "./resources/straw.png", 1);
    public Garbage jug = new Garbage("jug", 1, "./resources/jug.png", 1);
    public Garbage plastic = new Garbage("plastic", 1, "./resources/plastic.png", 1);
    public Garbage fishingNet = new Garbage("net", 1, "./resources/fishingNet.png", 3);
    public Garbage can = new Garbage("can", 1, "./resources/can.png", 2);
    
    //Equipment
    public Equipment Goggles = new Equipment("goggles", 15, "");
    public Equipment Suit = new Equipment("suit", 100, "");
    public Equipment OxygenTank = new Equipment("oxygenTank", 40, "");
    public Equipment Fins = new Equipment("fins", 50, "");
    
    public ItemDatabase()
    {
        //Add Garbage to list
        garbage.add(bottle);
        garbage.add(bag);
        garbage.add(straw);
        garbage.add(jug);
        garbage.add(plastic);
        garbage.add(fishingNet);
        garbage.add(can);
        
        //Add equipment to list
        equipment.add(Goggles);
        equipment.add(Suit);
        equipment.add(OxygenTank);
        equipment.add(Fins);
        
    }
    
    public Garbage randomItem()
    {
        Random random = new Random();
        
        return garbage.get(random.nextInt(garbage.size()));
    }
    
    public Garbage getItem(String name)
    {
        for (int i = 0; i < garbage.size(); i++)
        {
            if(garbage.get(i).getName().equals(name))
            {
                return garbage.get(i);
            }
        }
        return null;
    }
}
