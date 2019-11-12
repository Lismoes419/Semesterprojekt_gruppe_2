package worldofzuul;
import java.util.ArrayList;


public class Equipment extends Item {

    //variables
    private int price;
    
    public Equipment(String name, int price)
    {
        setName(name);
        this.price = price;
    }
    
    public int getPrice()
    {
        return price;
    }
}