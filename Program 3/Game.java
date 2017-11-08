//********************************************************************
//      Project #3: Tic-Tac-Toe
//      Name: Chris Duhan
//      Class: Contemporary programming languages: Python and Java
//      Instructor: Dr. Johnson
//      Due Date: 11/07/2017
//********************************************************************
//      This program allows two people to play a game of Tic-Tac-Toe
//	against each other.
//	I will acknowledge which functions I took the most inspiration
//	from in their respective comments. Overall, I got inspiration
//	from two main scourses: 
//	Martyr2, http://www.coderslexicon.com/a-beginner-tic-tac-toe-class-for-java/
// 	and
//	Ojus Milind Save, https://medium.com/@ojusmilindsave/tutorial-to-implement-tic-tac-toe-in-java-ad639661a9b.
//	This file is the Game class and all it's methods. The main
//	class is self contained.
//********************************************************************

import java.io.IOException;
import java.util.Scanner;

public class Game {

	private char[][] gameBoard;
	public char currentPlayerTurn;
	public int rowPlayed, columnPlayed;

	//********************************************************************
	//	public Game()
	//	Parameters: None
	//	Complexity: O(1)
	//	The default constructor, creates the 2D array to be used as 
	//	the gameboard. Initializes the currentPlayerTurn and calls
	//	boardSetUp().
	//	Martyr2 inspired.
	//********************************************************************
	public Game() {
		gameBoard = new char[3][3];
		currentPlayerTurn = 'X'; // X's always go first
		boardSetUp();
		return;
	}

	//********************************************************************
	//	private boardSetUp()
	//	Parameters: None
	//	Complexity: O(1)
	//	Initializes the gameBoard with '*' for each empty playable
	//	spot.
	//	Martyr2 inspired.
	//********************************************************************
	private void boardSetUp() {
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				gameBoard[i][j] = '*';
		return;
	}

	//********************************************************************
	//	public printBoard()
	//	Parameters: None
	//	Complexity: O(1)
	//	Prints out the current gameBoard, including style elements 
	//	like pipes and hyphens.
	//	Martyr2 inspired.
	//********************************************************************
	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; ++i) {
			System.out.print("| ");
			for (int j = 0; j < 3; ++j)
				System.out.print(gameBoard[i][j] + " | ");

			System.out.println();
			System.out.println("-------------");
		}
		return;
	}

	//********************************************************************
	//	public checkBoardFull()
	//	Parameters: None
	//	Complexity: O(1)
	//	Checks each position of the 2D array for an '*'. if found in 
	//	any position, the gameboard is not full. 
	//	Returns a boolean for the 'fullness' of the board.
	//	Martyr2 inspired.
	//********************************************************************
	public boolean checkBoardFull() {
		boolean isFull = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == '*') {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	//********************************************************************
	//	public checkWinConditions()
	//	Parameters: None
	//	Complexity: O(1)
	//	Checks every row, column and diagonal based on the value of
	//	certain cells in the 2D array.
	//	Returns a boolean for the existance of a win.
	//********************************************************************
	public boolean checkWinConditions() {
		char checkValue;

		checkValue = gameBoard[0][0]; // Top left
		if (checkValue != '*') {
			if (gameBoard[0][1] == checkValue && gameBoard[0][2] == checkValue) // Top left to top right
				return true;
			if (gameBoard[1][0] == checkValue && gameBoard[2][0] == checkValue) // Top left to bottom left
				return true;
			if (gameBoard[1][1] == checkValue && gameBoard[2][2] == checkValue) // Top left to bottom right diagonally
				return true;
		}

		checkValue = gameBoard[0][2]; // Top right
		if (checkValue != '*') {
			if (gameBoard[1][2] == checkValue && gameBoard[2][2] == checkValue) // Top right to bottom right
				return true;
			if (gameBoard[1][1] == checkValue && gameBoard[2][0] == checkValue) // Top right to bottom left diagonally
				return true;
		}

		checkValue = gameBoard[2][1]; // Bottom center
		if (checkValue != '*') {
			if (gameBoard[0][1] == checkValue && gameBoard[1][1] == checkValue) // Bottom center across
				return true;
			if (gameBoard[2][0] == checkValue && gameBoard[2][2] == checkValue) // Bottom center to top center
				return true;
		}

		checkValue = gameBoard[1][0]; // Middle left
		if (checkValue != '*') {
			if (gameBoard[1][1] == checkValue && gameBoard[1][2] == checkValue) // Middle left to middle right
				return true;
		}

		return false;
	}

	//********************************************************************
	//	public getPlayedSpot()
	//	Parameters: None
	//	Complexity: O(1)
	//	Gets the row and column that the currnt player want to play in.
	//********************************************************************
	public void getPlayedSpot() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("It is " + currentPlayerTurn + "'s turn.");
		System.out.println("Enter the row you wish to play in: ");
		rowPlayed = scan.nextInt();
		System.out.println("Enter the column you wish to play in: ");
		columnPlayed = scan.nextInt();
		// scan.close(); 
		// Learned we should close scanners but it was throwing exceptions
		// It works fine when I don't close it.
		return;
	}

	//********************************************************************
	//	public play()
	//	Parameters: Two integers representing the row and column
	//	Complexity: O(1)
	//	Makes sure the position that the current player wants to play
	//	in is still playable and within the board. If it is then
	//	places the current player's mark in that position then
	//	switches players by calling nextPlayer().
	//********************************************************************
	public void play(int row, int column) {
		if (row < 3 && row > -1 && column < 3 && column > -1) {
			if (gameBoard[row][column] == '*') {
				gameBoard[row][column] = currentPlayerTurn;
				nextPlayer();
			} else if (gameBoard[row][column] != currentPlayerTurn) {
				System.out.println("Your opponent has already played there,\nplease choose another spot.");
			} else if (gameBoard[row][column] == currentPlayerTurn) {
				System.out.println("You have already played there,\nplease choose another spot.");
			}
		} else
			System.out.println("You must play within the bounds of the board.");
		return;
	}

	//********************************************************************
	//	public nextPlayer()
	//	Parameters: None
	//	Complexity: O(1)
	//	Switches between the two players based on the current player.
	//********************************************************************
	public void nextPlayer() {
		if (currentPlayerTurn == 'X')
			currentPlayerTurn = 'O';
		else
			currentPlayerTurn = 'X';

		return;
	}
}
