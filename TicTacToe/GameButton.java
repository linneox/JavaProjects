package TicTacToe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class GameButton extends JButton implements GameGUI, Subject
{
    private static ArrayList<Observer> observers;
    private int intName; 
    private String strName;
    private String position;
    
    public GameButton()
    {
        super("");
        setFocusPainted(false);
        setFont(new Font("Arial", Font.PLAIN, 15));
        observers = new ArrayList();
    }
    
    public GameButton(String text, int intName, String strName, String position)
    {
        super(text);
        this.intName = intName; 
        this.strName = strName;
        this.position = position;
        observers = new ArrayList();
    }
    
    public void setPosition(String pos)
    {
        this.position = pos;
    }
    
    public void undoLastMove()
    {
        
    }

    @Override
    public void setIntName(int name) 
    {
        intName = name;
    }

    @Override
    public void setStrName(String name) 
    {
        strName = name;
    }

    @Override
    public int getIntName() 
    {
        return intName;
    }

    @Override
    public String getStrName() 
    {
        return strName;
    }

    @Override
    public void register(Observer obs) 
    {
        GameButton.observers.add(obs);
    }

    @Override
    public void unregister(Observer obs) 
    {
        // No need for method definition.
    }

    @Override
    public void notifyObservers(ActionEvent event) 
    {
        for(Observer temp:observers)
        {
            temp.update(event);
        }
    }
    
    
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            notifyObservers(event); // Update the GameManager
        }
    }
    
    public void addButtonListener()
    {
        this.addActionListener(new ButtonListener());
    }
    
}