import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {

		boolean keepPlaying = true;
		Scanner playAgain = new Scanner(System.in);
		System.out.println("Max Duhan");
		System.out.println("This program allows two human players to");
		System.out.println("play a game of Tic-Tac-Toe against each other.");
		System.out.println("X always goes first and you win by placing");
		System.out.println("three of your marks in a row, column or diagonal.");
		System.out.println("To make a move enter the index (0-2) of the row");
		System.out.println("you want to play in, then the index (0-2) of the");
		System.out.println("column you want to play in.");

		while (keepPlaying) {
			Game myGame = new Game();
			myGame.printBoard();
			while (!myGame.checkWinConditions() && !myGame.checkBoardFull()) {
				myGame.getPlayedSpot();
				myGame.play(myGame.rowPlayed, myGame.columnPlayed);
				myGame.printBoard();
			}

			if (myGame.checkWinConditions()) {
				myGame.nextPlayer();
				System.out.println(myGame.currentPlayerTurn + " wins!");
			} else {
				System.out.println("It's a draw!");
			}
			System.out.println("Would you like to play again? (Y/N)");
			if (playAgain.next().toUpperCase().charAt(0) == 'N') {
				keepPlaying = false;
				System.out.println("Bye!");
				System.exit(0);
			} else {
				System.out.println("New game starting!");
			}

		}
	}

}
