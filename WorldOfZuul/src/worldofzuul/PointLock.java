package worldofzuul;


public class PointLock extends Lock{
    
    private int amt;
    
    public PointLock(int amt)
    {
        this.amt = amt;
    }
    
    @Override
    public void unlock(Player player)
    {
        //Check om vi har point nok
        if(player.getPoints() >= amt)
        {
            setLocked(false);
        }
    }
    @Override
    public String getCondition()
    {
        return String.valueOf(amt);
    }
    
    public int getAmt()
    {
        return amt;
    }
}
