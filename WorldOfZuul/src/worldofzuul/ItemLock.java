package worldofzuul;


public class ItemLock extends Lock{
    
    public Item item;
    
    @Override
    public void unlock(Player player)
    {
        //Check om vi har det rigtige item
        //Hvis vi har, unlock
    }
    @Override
    public String getCondition()
    {
        return item.getName();
    }
}
