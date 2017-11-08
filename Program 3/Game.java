import java.io.IOException;
import java.util.Scanner;

public class Game {

	private char[][] gameBoard;
	private char currentPlayerTurn;
	public int rowPlayed, columnPlayed;
	
	public Game()
	{
		gameBoard = new char[3][3];
		currentPlayerTurn = 'x'; // X's always go first
		boardSetUp();
		return;
	}

	private void boardSetUp()
	{
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				gameBoard[i][j] = '*';
		return;
	}
	
	public void printBoard()
	{
		System.out.println("-------------");
		for (int i = 0; i < 3; ++i)
		{
			System.out.print("| ");
			for (int j = 0; j < 3; ++j)
				System.out.print(gameBoard[i][j] + " | ");

			System.out.println();
			System.out.println("-------------");
		}
		return;
	}
	
	public boolean checkBoardFull()
	{
		boolean isFull = true;
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (gameBoard[i][j] == '*')
					{
						isFull = false;
					}
				}
			}
		return isFull;
	}
	
	public boolean checkWinConditions()
	{
		char checkValue;
		checkValue = gameBoard[0][0];
		if(gameBoard[0][1] == checkValue && gameBoard[0][2] == checkValue)
			return true;
		if(gameBoard[1][0] == checkValue && gameBoard[2][0] == checkValue)
			return true;
		if(gameBoard[1][1] == checkValue && gameBoard[2][2] == checkValue)
			return true;
		
		checkValue = gameBoard[0][2];
		if(gameBoard[1][2] == checkValue && gameBoard[2][2] == checkValue)
			return true;
		if(gameBoard[1][1] == checkValue && gameBoard[2][0] == checkValue)
			return true;
		
		checkValue = gameBoard[2][1];
		if(gameBoard[1][0] == checkValue && gameBoard[1][1] == checkValue)
			return true;
		if(gameBoard[2][0] == checkValue && gameBoard[2][2] == checkValue)
			return true;
		
		checkValue = gameBoard[0][1];
		if(gameBoard[1][1] == checkValue && gameBoard[1][2] == checkValue)
			return true;
		
		return false;
	}
	
	public void getPlayedSpot() throws IOException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the row you wish to play in: ");
		rowPlayed = scan.nextInt();
		System.out.println("Enter the column you wish to play in: ");
		columnPlayed = scan.nextInt();
		scan.close();
		return;
	}
	public void play(int row, int column)
	{
		if(row < 3 && row > -1 && column < 3 && column > -1)
		{
			if(gameBoard[row][column] == '*')
			{
				gameBoard[row][column] = currentPlayerTurn;
				nextPlayer();
			}
			else if (gameBoard[row][column] != currentPlayerTurn)
			{
				System.out.println("Your opponent has already played there,\nplease choose another spot.");
			}
			else if (gameBoard[row][column] == currentPlayerTurn)
			{
				System.out.println("You have already played there,\nplease choose another spot.");
			}
		}
		else
			System.out.println("You must play within the bounds of the board.");
		return;
	}
	
	public void nextPlayer()
	{
		if (currentPlayerTurn == 'x')
			currentPlayerTurn = 'o';
		else 
			currentPlayerTurn = 'o';
		
		return;
	}
}
