package worldofzuul;
import java.util.ArrayList;

public class ItemDatabase {
    
    //Single Items
    public static Item plasticBottle = new Item("bottle", 1);
    public static Item plasticBag = new Item("bag", 1);
    public static Item plasticStraw = new Item("straw", 1);
    public static Item plasticJug = new Item("jug", 1);
    public static Item plastic = new Item("plastic", 1);
    public static Item fishingNet = new Item("net", 1);
    public static Item can = new Item("can", 1);
    
    //Piles
    public static Item bunch = new Item("bunch", 10);
    public static Item pile = new Item("pile", 20);
    public static Item island = new Item("island", 50);
    
    //List
    public static ArrayList<Item> database = new ArrayList<Item>();
    public static void createList()
    {
        database.add(plasticBottle);
        database.add(plasticBag);
        database.add(plasticStraw);
        database.add(plasticJug);
        database.add(plastic);
        database.add(fishingNet);
        database.add(can);
        
        database.add(bunch);
        database.add(pile);
        database.add(island);
    }
    
}
