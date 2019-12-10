package GameLogic;


public abstract class Item {
    //Variables
    private String name;
    private String iconPath; //private Icon;
    
    public Item(String name, String path) {
        this.name = name;
        this.iconPath = path;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getIcon()
    {
        return iconPath;
    }
}
