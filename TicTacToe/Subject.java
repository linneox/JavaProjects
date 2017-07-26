package TicTacToe;

import java.awt.event.ActionEvent;

public interface Subject 
{
    public void register(Observer obs);
    public void unregister(Observer obs);
    public void notifyObservers(ActionEvent event);
}
