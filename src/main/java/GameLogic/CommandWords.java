package GameLogic;
import java.util.HashMap;


public class CommandWords
{
    //nyt PRIVAT hashmap
    private HashMap<String, CommandWord> validCommands;

    //CommandWord constructor
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>(); //nyt hashmap objekt
        for(CommandWord command : CommandWord.values()) { //foreach loop 
            if(command != CommandWord.UNKNOWN) { //hvis vi kender kommandoen vi har skrevet
                validCommands.put(command.toString(), command); //Hashmap funktion
            }
        }
    }

    //getCommandWord metode (med returtypen CommandWord)
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord); //nyt CommandWord = hashmap.get(kommandoen vi har skrevet ind)
        if(command != null) { //hvis vi kender kommandoen
            return command;
        }
        else { //Hvis ikke vi kender kommandoen
            return CommandWord.UNKNOWN;
        }
    }
    
    //Boolean metode (check om det er en kommando
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString); //hashmap funktion
    }

    //showAll metode
    public void showAll() 
    {
        for(String command : validCommands.keySet()) { //foreach loop
            System.out.print(command + "  "); //printer vores nuværende (i loopet) kommando + et mellemrum
        }
        System.out.println(); //printer ny linje EFTER vi har printet alle vores kommandoer i loopet
    }
}
