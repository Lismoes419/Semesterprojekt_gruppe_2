package Presentation;
import GameLogic.Command;
import GameLogic.Player;

public interface GameInterface {
    
    public void goRoom(String direction);
    //public void dumpster();
    //public void buy();
    public Player getPlayer();
    public void quit();
    public void pickup(String name);
    public void unlockRooms();
    
}
