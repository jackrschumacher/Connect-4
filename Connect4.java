
// Import everything in java.util
import java.util.*;

public class Connect4 {
	// Set up class and methods
	// Set up board
	private char[][] board;
	private int turn;

	public Connect4() {
		turn = 1;
	}

	public void playGame(){
		// As long as the user has not won the game, the loop will continue
		createBoard();
		displayBoard();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Please enter a column that you wish to place your piece in.");
			
			System.out.println("Column:");
			int col = in.nextInt();
			int row = dropPiece(col);
			if(row != -1){
				displayBoard();
				System.out.println("Check for winner:" + checkForWinner(row, col));
				char winner = checkForWinner(row,col);
				if(winner != ' '){
					
					
					if(winner == 't'){
						System.out.println("You tied!");
					}
					else if(winner == '1'){
						System.out.println("1 Won!");
					}
					else if(winner == '2'){
						System.out.println("2 Won!");
					}
					return;
				}
			}
			else{
				System.out.println("This column is full. Select another column.");
			}
			
		}	
			
	}
		
	
		


	private void createBoard() {
		this.board = new char[][] {
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
		};
	}

	private int dropPiece(int col) {
		int row = 0;

		while(row < 6 && board[row][col] != ' ' ){
			row++;
		}
		if(row == 6){
			return -1;
		}
		else{
			if (turn == 1){
				board[row][col] = '1';
				turn = 2;
			}
			else {
				board[row][col] = '2';
				turn = 1;
			}
      return row;
		}
		

	}

	private char checkForWinner(int row, int col) {
		// Checks if the user has won and then returns it to the playGame() function in
		// order to end the game
		// Calls the different check functions -> Columns, rows, Diagonal to the right,
		// diagonal to the left

		char checkWinner = checkRowLeft(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		checkWinner = checkRowRight(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		checkWinner = checkDiagonalUpRight(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		checkWinner = checkDiagonalUpLeft(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		checkWinner = checkDiagonalDownRight(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		checkWinner = checkDiagonalDownLeft(row,col);
		if (checkWinner != ' ') {
			return checkWinner;
		}
		
		// Check to see if spaces on the board are filled
		// If all the spaces are filled and the user has not won the game, they players have tied. 
		// If not, the game continues until someone wins
		boolean spaceFilled = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == ' ') {
					spaceFilled = false;
				}
			}
		}
		if(spaceFilled){
			return 't';
		}
		return ' ';

	}




	private char checkRowLeft(int row, int col) {
		char charMatch = board[row][col];
		
		int i = col;
		int count = 0;
		while(i > 0 && board[row][i] != charMatch){
			System.out.println(i);
			System.out.println(board[row][i]);
			i--;
			count++;
		}
		if(count >= 4){
			return charMatch; 
		}
		else{
			return ' ';
		}
	}
	
	private char checkRowRight(int row, int col) {
		char charMatch = board[row][col];
		
		int i = col;
		int count = 0;
		while(i < board.length && board[row][i] != charMatch){
			System.out.println(i);
			System.out.println(board[row][i]);
			i++;
			count++;
		}
		if(count >= 4){
			return charMatch; 
		}
		else{
			return ' ';
		}
	}
	
	private char checkDiagonalUpRight(int row, int col){

		return ' ';
	}
	private char checkDiagonalUpLeft(int row, int col){

		return ' ';
	}

	private char checkDiagonalDownRight(int row, int col){
		// Initialize count variable in order to setup while loop

		return ' ';
  }	

	private char checkDiagonalDownLeft(int row, int col){
		char charMatch = board[row][col];
		int count = 1;

		int currentCol = col;
		int currentRow = row;

		return ' ';
  }


	private void displayBoard() {
		// Displays the ASCII art for the board and displays the characters at that
		// specific section of the board.
		// Board is 6*7
		// Use two spaces for the board println before the "|"
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[5][0] + "  | " + board[5][1] + "  | " + board[5][2] + "  | " + board[5][3] + "  | "
				+ board[5][4] + "  | " + board[5][5] + "  | " + board[5][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[4][0] + "  | " + board[4][1] + "  | " + board[4][2] + "  | " + board[4][3] + "  | "
				+ board[4][4] + "  | " + board[4][5] + "  | " + board[4][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[3][0] + "  | " + board[3][1] + "  | " + board[3][2] + "  | " + board[3][3] + "  | "
				+ board[3][4] + "  | " + board[3][5] + "  | " + board[3][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[2][0] + "  | " + board[2][1] + "  | " + board[2][2] + "  | " + board[2][3] + "  | "
				+ board[2][4] + "  | " + board[2][5] + "  | " + board[2][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[1][0] + "  | " + board[1][1] + "  | " + board[1][2] + "  | " + board[1][3] + "  | "
				+ board[1][4] + "  | " + board[1][5] + "  | " + board[1][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
		System.out.println("|    |    |    |    |    |    |    |");
		System.out.println("| " + board[0][0] + "  | " + board[0][1] + "  | " + board[0][2] + "  | " + board[0][3] + "  | "
				+ board[0][4] + "  | " + board[0][5] + "  | " + board[0][6] + "  | ");
		System.out.println("|____|____|____|____|____|____|____|");
	}
}
