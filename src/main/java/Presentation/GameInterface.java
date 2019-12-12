package Presentation;
import GameLogic.Player;

public interface GameInterface {
    
    public void goRoom(String direction);
    public Player getPlayer();
    public void quit();
    public void pickup(String name);
    public void unlockRooms();
    
}
