package TicTacToe;

public class GameGUIFactory 
{
    public GameGUI getGUI(String type)
    {
        if (type.equalsIgnoreCase("FRAME"))
        {
            return new GameFrame();
        }
        else if (type.equalsIgnoreCase("BUTTON"))
        {
            return new GameButton();
        }
        else if (type.equalsIgnoreCase("PANEL"))
        {
            return new GamePanel();
        }
        else if (type.equalsIgnoreCase("LABEL"))
        {
            return new GameLabel();
        }
        else
        {
            return null;
        }
    }
}