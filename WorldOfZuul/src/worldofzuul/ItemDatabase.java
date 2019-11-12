package worldofzuul;
import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    
    //List
    public ArrayList<Garbage> list = new ArrayList<Garbage>();
    
    //Garbage
    public Garbage bottle = new Garbage("bottle", 1);
    public Garbage bag = new Garbage("bag", 1);
    public Garbage straw = new Garbage("straw", 1);
    public Garbage jug = new Garbage("jug", 1);
    public Garbage plastic = new Garbage("plastic", 1);
    public Garbage fishingNet = new Garbage("net", 1);
    public Garbage can = new Garbage("can", 1);
    
    //Equipment
    public Equipment Goggles = new Equipment("goggles", 1);
    public Equipment Suit = new Equipment("suit", 10);
    public Equipment OxygenTank = new Equipment("oxygenTank", 50);
    
    public ItemDatabase()
    {
        list.add(bottle);
        list.add(bag);
        list.add(straw);
        list.add(jug);
        list.add(plastic);
        list.add(fishingNet);
        list.add(can);
    }
    
    public Garbage randomItem()
    {
        Random random = new Random();
        
        return list.get(random.nextInt(list.size()));
    }
}
