package worldofzuul;
import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    
    //List
    public ArrayList<Item> list = new ArrayList<Item>();
    
    //Single Items
    public Item bottle = new Item("bottle", 1);
    public Item bag = new Item("bag", 1);
    public Item straw = new Item("straw", 1);
    public Item jug = new Item("jug", 1);
    public Item plastic = new Item("plastic", 1);
    public Item fishingNet = new Item("net", 1);
    public Item can = new Item("can", 1);
    
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
    
    public Item randomItem()
    {
        Random random = new Random();
        
        return list.get(random.nextInt(list.size()));
    }
}
