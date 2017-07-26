package TicTacToe;

public class UndoMove implements Command
{
    private GameButton last;
    
    public UndoMove(GameButton last)
    {
        this.last = last;
    }

    @Override
    public void execute() 
    {
        last.undoLastMove();
    }   
}