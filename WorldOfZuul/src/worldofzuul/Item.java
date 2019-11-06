package worldofzuul;


public class Item {
    
    //Variables
    private String name;
    private int amount;
    
    //Constructors
    public Item(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return this.name;
    }
    public int getAmount()
    {
        return this.amount;
    }
    
    public void addAmount(int amt)
    {
        this.amount += amt;
    }
}
