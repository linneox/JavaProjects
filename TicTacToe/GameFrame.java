package TicTacToe;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameGUI 
{
    private int intName;
    private String strName;
    
    public GameFrame()
    {
        super();
    }
    
    public GameFrame(String title, int height, int width)
    {
        super(title);
        setSize(height, width);
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
