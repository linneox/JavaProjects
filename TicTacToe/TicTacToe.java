package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class TicTacToe 
{
    public static void main(String[] args)
    {
        GameManager manager = GameManager.getInstance();
        GameButton registerObs = new GameButton();
                
        GameGUIFactory factory = new GameGUIFactory();
        
        GameFrame frame = (GameFrame)factory.getGUI("FRAME");
        frame.setTitle("Tic Tac Toe");
        frame.setIntName(23423);
        frame.setStrName("GF");
        frame.setDefaultCloseOperation(3); // 3 is JFrame.EXIT_ON_CLOSE
        frame.setSize(350, 350);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        
        GameButton[][] gameArea = new GameButton[3][3];
        gameArea[0][0] = (GameButton)factory.getGUI("BUTTON");
        gameArea[0][0].addButtonListener();
        gameArea[0][0].setIntName(0);
        gameArea[0][0].setStrName("BT00");
        gameArea[0][0].setPosition("00");
        
        gameArea[0][1] = (GameButton)factory.getGUI("BUTTON");
        gameArea[0][1].addButtonListener();
        gameArea[0][1].setIntName(1);
        gameArea[0][1].setStrName("BT01");
        gameArea[0][1].setPosition("01");        
        
        gameArea[0][2] = (GameButton)factory.getGUI("BUTTON");
        gameArea[0][2].addButtonListener();
        gameArea[0][2].setIntName(2);
        gameArea[0][2].setStrName("BT02");
        gameArea[0][2].setPosition("02");
        
        gameArea[1][0] = (GameButton)factory.getGUI("BUTTON");
        gameArea[1][0].addButtonListener();
        gameArea[1][0].setIntName(10);
        gameArea[1][0].setStrName("BT10");
        gameArea[1][0].setPosition("10");

        gameArea[1][1] = (GameButton)factory.getGUI("BUTTON");
        gameArea[1][1].addButtonListener();
        gameArea[1][1].setIntName(11);
        gameArea[1][1].setStrName("BT11");
        gameArea[1][1].setPosition("11");

        gameArea[1][2] = (GameButton)factory.getGUI("BUTTON");
        gameArea[1][2].addButtonListener();
        gameArea[1][2].setIntName(12);
        gameArea[1][2].setStrName("BT12");
        gameArea[1][2].setPosition("12");

        gameArea[2][0] = (GameButton)factory.getGUI("BUTTON");
        gameArea[2][0].addButtonListener();
        gameArea[2][0].setIntName(20);
        gameArea[2][0].setStrName("BT20");
        gameArea[2][0].setPosition("20");

        gameArea[2][1] = (GameButton)factory.getGUI("BUTTON");
        gameArea[2][1].addButtonListener();
        gameArea[2][1].setIntName(21);
        gameArea[2][1].setStrName("BT21");
        gameArea[2][1].setPosition("21");

        gameArea[2][2] = (GameButton)factory.getGUI("BUTTON");
        gameArea[2][2].addButtonListener();
        gameArea[2][2].setIntName(22);
        gameArea[2][2].setStrName("BT22");
        gameArea[2][2].setPosition("22");        
        
        GameButton resetButton = (GameButton)factory.getGUI("BUTTON");
        resetButton.addButtonListener();
        resetButton.setText("Reset");
        resetButton.setIntName(8989);
        resetButton.setStrName("RB");
        
        GameButton undoButton = (GameButton)factory.getGUI("BUTTON");
        undoButton.addButtonListener();
        undoButton.setText("Undo Move");
        undoButton.setIntName(3242);
        undoButton.setStrName("UB");
        
        GameLabel playerTurn = (GameLabel)factory.getGUI("LABEL");
        playerTurn.setForeground(Color.red);
        playerTurn.setFont(new Font("Arial", Font.BOLD, 15));
        playerTurn.setIntName(4259);
        playerTurn.setStrName("PT");
        playerTurn.setText("Player Turn: ");
        manager.setLabel(playerTurn);
        
        GamePanel centerPanel = (GamePanel)factory.getGUI("PANEL");
        centerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        centerPanel.setIntName(5489);
        centerPanel.setStrName("CP");
        centerPanel.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                gameArea[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                centerPanel.add(gameArea[i][j]);
            }
        }
        manager.setGameArea(gameArea);
        frame.add(centerPanel, BorderLayout.CENTER);
        
        GamePanel southPanel = (GamePanel)factory.getGUI("PANEL");
        southPanel.setIntName(4326);
        southPanel.setStrName("SP");
        southPanel.add(resetButton);
        southPanel.add(undoButton);
        southPanel.add(playerTurn);
        southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.add(southPanel, BorderLayout.SOUTH);
        registerObs.register(manager);
        registerObs = null;
        frame.setVisible(true);
    }
}