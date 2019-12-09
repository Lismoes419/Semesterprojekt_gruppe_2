package GameLogic;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser 
{
    //Ny scanner (text input) og ny variabel af typen CommandWords
    private CommandWords commands;
    private Scanner reader;

    //Constructor der opretter ny parser
    public Parser() 
    {
        commands = new CommandWords(); //ny CommandWords objekt
        reader = new Scanner(System.in); //Ny scanner objekt
    }

    //GetCommand metode
    public Command getCommand() 
    {
        String inputLine; //inputLine er det man skriver ind
        String word1 = null;
        String word2 = null; 

        System.out.print("> "); //Printer 'pil' der viser hvor man skal skrive

        inputLine = reader.nextLine(); //Sætter vores inputLine = vores scanners metode: nextLine

        Scanner tokenizer = new Scanner(inputLine); //Laver ny scanner der tager en string som parameter
        if(tokenizer.hasNext()) { //Check om vores input har mindst 1 ord
            word1 = tokenizer.next(); //Gem 1. ord i Word1
            if(tokenizer.hasNext()) { //Check om vores input har mindst 2 ord
                word2 = tokenizer.next(); //Gem 2. ord i Word2
            }
        }

        return new Command(commands.getCommandWord(word1), word2); //Returner nyt command objekt, word1 er vores commandword, så vi checker om det findes i vores commandWords script
    }

    //Viser alle kommandoer man kan bruge
    public void showCommands()
    {
        //showAll er en metode i commandWords
        commands.showAll();
    }
}
