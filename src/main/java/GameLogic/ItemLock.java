package GameLogic;


public class ItemLock extends Lock{
    
    private Equipment equipment;
    
    //Constructor
    public ItemLock(Equipment equipment)
    {
        this.equipment = equipment;
    }
    
    @Override
    public void unlock(Player player)
    {
        //Check om vi har det rigtige item
        if(player.hasEquipment(equipment))
        {
            setLocked(false);
        }
    }
    public Equipment getConditionObject()
    {
        return equipment;
    }
}
