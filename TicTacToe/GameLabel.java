package TicTacToe;

import javax.swing.JLabel;

public class GameLabel extends JLabel implements GameGUI
{
    private int intName; 
    private String strName;
    
    public GameLabel()
    {
        super();
    }
    
    
    @Override
    public void setIntName(int name) 
    {
        this.intName = name;
    }

    @Override
    public void setStrName(String name) 
    {
        this.strName = name;
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
}
