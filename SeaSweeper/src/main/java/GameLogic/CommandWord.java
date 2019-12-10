package GameLogic;

public enum CommandWord
{
    //Liste af alle vores kommandoer (navnet + hvad vi skal skrive i textfeltet)
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    EXITS("exits"),
    UNKNOWN("?"),
    PICKUP("pickup"),
    INVENTORY("inventory"),
    ROOMITEMS("items"),
    SORT("sort"),
    BUY("buy");
    
    private String commandString;
    
    //Constructor
    CommandWord(String commandString)
    {
        this.commandString = commandString; //Sætter dette objekts commandString = vores parameter
    }
    
    //toString metode
    public String toString()
    {
        return commandString; //returnerer vores commandString
    }
}
