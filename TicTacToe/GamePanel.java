package TicTacToe;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements GameGUI
{
    private int intName; 
    private String strName;
    
    public GamePanel()
    {
        super();
    }
    
    public GamePanel(int intName, String strName)
    {
        this.intName = intName;
        this.strName = strName;
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

    public String getStrName() 
    {
        return strName;
    }
    
}
