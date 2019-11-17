package worldofzuul;

public class Garbage extends Item{
    
    //Variables
    private int amount;
    
    public Garbage(String name, int amount)
    {
        setName(name);
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
}
