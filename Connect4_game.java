package lab9;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Task2 {
	
	//Fix lab Lab 6 for exceptions  
	//Lines 45-54 show exception handling

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean finished = false;
		boolean gameOver = false;
		char playAgain = 'y';
		char board[][] = new char[7][8];
		char currentPlayer = 'X';
		int numMoves = 0;
		
		do {//Finished loop
		
			numMoves = 0;
			finished = false;
			currentPlayer = 'X';
			
		//Initializes boards
		for (int r=1;r<=6;r++) {
			for (int c=1;c<=7;c++)
			{
				board[r][c] = ' ';
			}//End of for loop
			System.out.println();
		}
		
		
		//Displays game board
			displayBoard(board);
				
			do {//Gameover loop
				gameOver = false;
				int columnChosen = 0;
				do {//columnChosen loop
					
					try  //Exception handling for InputMismatchException
					{
					System.out.println("\nPlayer "+currentPlayer+", pick a column (1-7) to drop your piece: ");
					columnChosen = input.nextInt();
					}
					catch (InputMismatchException e)
					{
						System.out.println("Error. Please input an integer value: ");
					}
					input.nextLine();
					
				} while (columnChosen < 1 || columnChosen > 7 || board[1][columnChosen] != ' ');
				
				
				//Insert piece into 2-D array
				if (currentPlayer == 'X'){
					for (int r=6;r>=1;r--) {
						if (board[r][columnChosen]== ' ') {
							board[r][columnChosen] = currentPlayer;
							break;
					}
				}
				}//Player 'X'
				
				else if (currentPlayer == 'O'){
					for (int r=6;r>=1;r--) {
						if (board[r][columnChosen]== ' ') {
							board[r][columnChosen] = currentPlayer;
							break;
					}
				}
				}//Player 'O'
				
				numMoves++;
				
				displayBoard(board);
				
				//Checks for win
				if(CheckForWin(board)==true) {
					System.out.println("Congrats Player "+currentPlayer+"!  You won!");
					gameOver = true;
					}
				
				else if (numMoves == 42) {//If tie, display results, game over = true
					System.out.println("Tie!");
					gameOver = true;
				}
				
				else {//Switches player
					if (numMoves % 2 == 0) 
						currentPlayer = 'X';
					else
						currentPlayer = 'O';
				}
				
			} while (gameOver != true);//Outer loop
		
		
		//Ask if user wants to play again
		System.out.println("Type 'y' to play again, or type 'n' to quit.");
		playAgain = input.next().toLowerCase().charAt(0);
		if (playAgain == 'y')
			finished = false;
		else if (playAgain == 'n')
			finished = true;
		else
		{
			System.out.println("You did not enter a correct value, now exiting game...");
			finished = true;
		}
		
		} while (finished != true);
		
		System.out.println("\nThanks for playing!  Goodbye!");
		
	}//End of main method
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void displayBoard(char[][] board)
	{
		System.out.println("  1  2  3  4  5  6  7");
		
		for(int r=1;r<=6;r++) {
			System.out.print(r);
			for (int c=1;c<=7;c++) {
				System.out.print("  " + board[r][c] );
				}
			System.out.println();
			}
	}//End of displayBoard
	
	public static boolean CheckForWin(char[][] board) {
		//Horizontal
		for (int r = 1; r<=6; r++) {
			for (int c=1; c<=4;c++) {
				if (board[r][c] == board[r][c+1] &&
					    board[r][c] == board[r][c+2] &&
					    board[r][c] == board[r][c+3] &&
					    board[r][c] != ' ')
					    {
					return true;
					}
			}//Inner
		}//Outer
		
		
		//Vertical
		for (int r = 1; r<=3; r++) {
			for (int c=1; c<=7;c++) {
				if (board[r][c] == board[r+1][c] &&
					    board[r][c] == board[r+2][c] &&
					    board[r][c] == board[r+3][c] &&
					    board[r][c] != ' ')
				{
					return true;
				}
				
			}//Inner
		}//Outer
		
		
		//Diagonal needs rows and columns changed like Vertical
		
		//Diagonal up
		for (int r = 1; r<=6; r++) {
			for (int c=1; c<=4;c++) {
				if (board[r][c] == board[r-1][c+1] &&
					    board[r][c] == board[r-2][c+2] &&
					    board[r][c] == board[r-3][c+3] &&
					    board[r][c] != ' ')
				{
					return true;
				}
				
			}//Inner
		}//Outer
		
		
		//Diagonal down
				for (int r = 1; r<=6; r++) {
					for (int c=1; c<=4;c++) {
						if (board[r][c] == board[r-1][c-1] &&
							    board[r][c] == board[r-2][c-2] &&
							    board[r][c] == board[r-3][c-3] &&
							    board[r][c] != ' ')
						{
							return true;
						}
						
					}//Inner
				}//Outer
		
		return false;
	}//End of CheckForWin

}
