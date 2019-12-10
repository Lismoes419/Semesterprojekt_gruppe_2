package GameLogic;


public class Garbage extends Item{
    
    //Variables
    private int amount;
    private int sortingID = 1;
    
    public Garbage(String name, int amount, String path, int id)
    {
        super(name, path);
        this.amount = amount;
        this.sortingID = id;
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
    
    public int getSortingID()
    {
        return sortingID;
    }
    
    
    public String getIcon()
    {
        return super.getIcon();
    }
}
