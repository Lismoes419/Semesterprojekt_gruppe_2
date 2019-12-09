package GameLogic;


public class Garbage extends Item{
    
    //Variables
    private int amount;
    
    public Garbage(String name, int amount, String path)
    {
        super(name, path);
        this.amount = amount;
    }
    
    //Accessor
    public int getAmount()
    {
        return this.amount;
    }
    //Mutator
    public void addAmount(int amt)
    {
        this.amount += amt;
    }
    
    
    public String getIcon()
    {
        return super.getIcon();
    }
}
