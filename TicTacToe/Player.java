 package TicTacToe;

public class Player 
{
    private final int intName; 
    private final String strName;
    private int[][] currentPositions;
    
    public Player()
    {
        intName = -1; 
        strName = "*";
        currentPositions = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
    }
    
    public Player(int intName, String strName)
    {
        this.intName = intName; 
        this.strName = strName;
        currentPositions = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
    }
    
    public int getIntName()
    {
        return intName;
    }
    
    public String getStrName()
    {
        return strName;
    }
    
    public void setPosition(int i, int j)
    {
        currentPositions[i][j] = 1;
    }
    
    public boolean checkWinStatus()
    {
        boolean win = false; 
        
       // CHECK DIAGONALS
       if (currentPositions[0][0] == 1 
              && currentPositions[1][1] == 1 
              && currentPositions[2][2] == 1)
        {
            win = true; 
        }
        else if (currentPositions[0][2] == 1 
              && currentPositions[1][1] == 1 
              && currentPositions[2][0] == 1)
        {
            win = true;
        }
        // CHECK HORIZONTALS
        else if (currentPositions[0][0] == 1
              && currentPositions[0][1] == 1
               &&currentPositions[0][2] == 1)
        {
            win = true;
        }
        else if (currentPositions[1][0] == 1
              && currentPositions[1][1] == 1
               &&currentPositions[1][2] == 1)
        {
            win = true;
        }
        else if (currentPositions[2][0] == 1
              && currentPositions[2][1] == 1
               &&currentPositions[2][2] == 1)
        {
            win = true;
        }
        // CHECK VERTICALS
        else if (currentPositions[0][0] == 1
              && currentPositions[1][0] == 1
               &&currentPositions[2][0] == 1)
        {
            win = true;
        }
        else if (currentPositions[0][1] == 1
              && currentPositions[1][1] == 1
               &&currentPositions[2][1] == 1)
        {
            win = true;
        }
        else if (currentPositions[0][2] == 1
              && currentPositions[1][2] == 1
               &&currentPositions[2][2] == 1)
        {
            win = true;
        }
        
        return win;
    }    
}