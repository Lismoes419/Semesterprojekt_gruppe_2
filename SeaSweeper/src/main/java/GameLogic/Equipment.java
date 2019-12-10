package GameLogic;
import java.util.ArrayList;


public class Equipment extends Item {

    //variables
    private int price;
    
    public Equipment(String name, int price, String path)
    {
        super(name, path);
        this.price = price;
    }
    
    public int getPrice()
    {
        return price;
    }
}