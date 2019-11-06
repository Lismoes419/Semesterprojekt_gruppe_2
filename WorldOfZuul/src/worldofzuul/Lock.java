package worldofzuul;


public abstract class Lock {
    
    private boolean locked = true;
    
    //accessor metode
    public boolean isLocked()
    {
        return locked;
    }
    
    //Mutator metode
    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }
    
    //Unlock metode
    public abstract void unlock(Player player);
    public abstract String getCondition();
}
