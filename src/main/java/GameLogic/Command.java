package GameLogic;

public class Command
{
    //Nyt (tomt) commandWord og String
    private CommandWord commandWord;
    private String secondWord;

    //Constructor
    public Command(CommandWord commandWord, String secondWord)
    {
        //Sætter objektets attributter = parametrene
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    //getCommandWord med returtypen CommandWord
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    //getSecondWord med returtypen String
    public String getSecondWord()
    {
        return secondWord;
    }

    //Boolean metode (Checker om kommandoen er unknown)
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN); //returner true eller false ved at checke om vores commandWord = unknown
    }

    //hasSecondWord metode
    public boolean hasSecondWord()
    {
        return (secondWord != null); //returnerer true eller false ved at checke om vi har et ord nr. 2
    }
}

