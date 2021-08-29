package com.yml.tictactoe;
import java.util.*;

/**@class in which methods to create TICTACTOE game is written
 * @author stalincd
 *
 */
public class TicTacToeGame {
	
	Scanner in = new Scanner(System.in);
	
	// array to create a array of board of type char
	private char board[] = new char[10] ;
	
	//variables to choose X or O for player and computer
	char playerChoice, computerChoice;
	
	private Random random = new Random();
	
	/**
	 * @method to create an empty board
	 */
	public void createBoard() {
		for(int i=1;i<10;i++) {
			board[i] = ' ';
		}
	}
	
	/**
	 * @method to set player's letter choice
	 */
	public void choice() {
		System.out.println("Choose the letter(X/O) ");
		char ch = in.next().charAt(0);
		if(ch == 'X') {
			playerChoice = 'X';
			computerChoice = 'O';
			System.out.println("Player has chosen X\n");
			selectLocation();
		}else if(ch == 'O') {
			playerChoice = 'O';
			computerChoice = 'X';
			System.out.println("Player has chosen O\n");
			selectLocation();
		}else {
			System.out.println("Invalid choice!!!");
			choice();
		}
	}
	
	public void showBoard() {
		System.out.println("Displaying the board:\n");
		System.out.println("------------");
		System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]+" | ");
		System.out.println("------------");
		System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]+" | ");
		System.out.println("------------");
		System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]+" | ");
		System.out.println("------------");
	}
	
	public void selectLocation() {
		System.out.println("Enter the location where you want to enter "+playerChoice+" in the board");
		int location  = in.nextInt();
		while(location < 1 || location > 9) {
			System.out.println("Enter a valid location between 1 and 9");
			location = in.nextInt();
		}
		if(board[location] == ' ') {
			System.out.println("Your location has been selected in the board\n");
			board[location] = playerChoice;
			showBoard();
		}else {
			System.out.println("Please enter another location as the previous location has already been occupied\n");
			selectLocation();
		}
	}
	
	public void toss() {
		System.out.println("Enter your choice 1.Heads  2.Tails");
		int choice = in.nextInt();
		int tossChoice = random.nextInt(2)+1;
		System.out.println("Random : "+tossChoice);
		if(choice == tossChoice) {
			System.out.println("You have won the toss. You will play first.\n");
			choice();
		}else {
			System.out.println("Sorry! You have lost the toss. Computer will play first.\n");
		}
	}
	

}
