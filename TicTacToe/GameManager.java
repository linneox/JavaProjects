package TicTacToe; 

import java.awt.event.ActionEvent;

public class GameManager implements GameGUI, Observer
{
    private volatile static GameManager instance = null;
    private static GameButton lastGameButtonPressed;
    
    private Player playerX; 
    private Player playerO;
    
    private boolean winStatus;    
    private int intName; 
    private String strName;
    private Player currentTurn;
    private GameLabel playerTurn;
    private GameButton[][] gameArea;
    
    
    private GameManager()
    {
        // Player X denoted by ASCII 88 for int
        playerX = new Player(58, "X");
        
        // Player O denoted by ASCII 79
        playerO = new Player(79, "O");
        
        winStatus = false; 
    }
    
    public static GameManager getInstance()
    {
        if (null == GameManager.instance)
        {
            GameManager.instance = new GameManager();
        }
        
        return instance;
    }
    
    public void setGameArea(GameButton[][] area)
    {
        this.gameArea = area;
    }
    
    public void setLabel(GameLabel label)
    {
        playerTurn = label;
        String turn = playerX.getStrName();
        label.setText("Player Turn: " + turn);
        currentTurn = playerX;
    }
    
    private void undoLastMove()
    {
        if (GameManager.lastGameButtonPressed != null)
        {
            // Set currentTurn back to previous turn
            if(currentTurn.equals(playerX))
            {
                currentTurn = playerO;
                playerTurn.setText("Player Turn: O");
            }
            else
            {
                currentTurn = playerX;
                playerTurn.setText("Player Turn: X");
            }

            if (GameManager.lastGameButtonPressed != null)
            {
                GameManager.lastGameButtonPressed.setEnabled(true);
                GameManager.lastGameButtonPressed.setText("");
                GameManager.lastGameButtonPressed = null;
            }
        }
    }
    
    private void resetGameView()
    {
        // Method will Reset the currentTurn to playerX
        // Method will Reset the PlayerTurn label to X
        // Method will Reset the 9 GameButtons to "__"
        // Method will Reset lastButtonPressed to null
        playerX = new Player(58, "X");
        playerO = new Player(79, "O");
        currentTurn = playerX;
        playerTurn.setText("Player Turn: X");
        GameManager.lastGameButtonPressed = null;
        winStatus = false;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                gameArea[i][j].setEnabled(true);
                gameArea[i][j].setText("");
            }
        }
    }

    @Override
    public void setIntName(int name) 
    {
        this.intName = name;
    }

    @Override
    public void setStrName(String name) 
    {
        this.strName = strName;
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
    public void update(ActionEvent event) 
    {
        int i, j;
        
        GameButton temp = (GameButton)event.getSource();
        
        
        if(temp.getStrName().charAt(0) == 'B' 
                && temp.getStrName().charAt(1)== 'T')
        {
            
            temp.setEnabled(false); // Disable the button. Cannot be clicked. 
            
            GameManager.lastGameButtonPressed = temp;
            
            i = Integer.parseInt(String.valueOf(temp.getStrName().charAt(2)));
            j = Integer.parseInt(String.valueOf(temp.getStrName().charAt(3)));
            
            
            // If It Was X's Turn
            if (currentTurn.equals(playerX))
            {
                playerX.setPosition(i,j);
                temp.setText("X");
                winStatus = playerX.checkWinStatus();
                if (winStatus)
                {
                    
                    GameManager.lastGameButtonPressed = null;
                    for (i = 0; i < 3; i++)
                    {
                        for (j = 0; j < 3; j++)
                        {
                            gameArea[i][j].setEnabled(false);
                        }
                    }
                    playerTurn.setText("Winner: X");
                    //JOptionPane.showMessageDialog(null, "Player X wins!");
                }
                else
                {
                playerTurn.setText("Player Turn: O");
                currentTurn = playerO;
                }
            }
            // If It Was O's Turn
            else if (currentTurn.equals(playerO))
            {
                playerO.setPosition(i,j);
                temp.setText("O");
                
                winStatus = playerO.checkWinStatus();
                if (winStatus)
                {
                    GameManager.lastGameButtonPressed = null;
                    for (i = 0; i < 3; i++)
                    {
                        for (j = 0; j < 3; j++)
                        {
                            gameArea[i][j].setEnabled(false);
                        }
                    }
                    playerTurn.setText("Winner: O");
                    //JOptionPane.showMessageDialog(null, "Player O wins!");
                }
                else 
                {
                winStatus = playerO.checkWinStatus();
                playerTurn.setText("Player Turn: X");
                currentTurn = playerX;
                }
            }
        }
        else if (temp.getStrName().equalsIgnoreCase("RB")) // Reset Button Clicked
        {
            resetGameView();
        }
        else if (temp.getStrName().equalsIgnoreCase("UB")) // Undo Button Clicked
        {
            // Direct call w/o Command Pattern
            undoLastMove();
            // Indirect call w/ Command Pattern
            new UndoMove(temp).execute(); 
        }
    }
}