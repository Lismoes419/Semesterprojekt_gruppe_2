/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

package worldofzuul;

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

