// Import everything in java.util
import java.util.*;

public class Connect4{
// Set up class and methods
// Set up board
	private char [][] board;
	private int turn;
	

	
	public Connect4(){
		turn  = 0;
	}


	public void playGame(){
		Scanner in = new Scanner(System.in);
		createBoard();
		displayBoard();
		
		return;
		
	}

	private void createBoard(){
		this.board = new char[][]{
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
		};
		}

	private void displayBoard(){
		// Displays the ASCII art for the board and displays the charachters at that specific section of the board.
		System.out.println("    |    |    |    |    |    |    |");
		System.out.println(" "+ board[0][0]+ " | "+ board[0][1]+ " | "+ board[0][2]+ " | "+ board[0][3]+ " | "+ board[0][4]+ " | " + board[0][5] + " | "+ board[0][6]);
		System.out.println("    |    |    |    |    |    |    |");
	}
	}
}