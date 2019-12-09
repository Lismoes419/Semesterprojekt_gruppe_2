package GameLogic;
import java.util.ArrayList;
import java.util.Random;

public class ItemDatabase {
    
    //List
    public ArrayList<Garbage> garbage = new ArrayList<Garbage>();
    public ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    
    //Garbage
    public Garbage bottle = new Garbage("bottle", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/bottle.png");
    public Garbage bag = new Garbage("bag", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/bag.png");
    public Garbage straw = new Garbage("straw", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/straw.png");
    public Garbage jug = new Garbage("jug", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/jug.png");
    public Garbage plastic = new Garbage("plastic", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/plastic.png");
    public Garbage fishingNet = new Garbage("net", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/fishingNet.png");
    public Garbage can = new Garbage("can", 1, "/Users/jakobrasmussen/NetBeansProjects/SeaSweeper/resources/can.png");
    
    //Equipment
    public Equipment Goggles = new Equipment("goggles", 30, "");
    public Equipment Suit = new Equipment("suit", 100, "");
    public Equipment OxygenTank = new Equipment("oxygenTank", 80, "");
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
}
