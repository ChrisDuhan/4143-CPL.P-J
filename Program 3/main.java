import java.io.IOException;

public class main {
    public main(String[] args) throws IOException
    {
	Game myGame = new Game();
	
	while(!myGame.checkBoardFull())
	{
		myGame.printBoard();
		while(!myGame.checkWinConditions())
		{
			myGame.getPlayedSpot();
			myGame.play(myGame.rowPlayed, myGame.columnPlayed);
			myGame.printBoard();
		}
	}

	
    }
}
