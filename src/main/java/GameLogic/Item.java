package GameLogic;


public abstract class Item {
    //Variables
    private String name;
    //private Icon;
    private String iconPath;

    
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
