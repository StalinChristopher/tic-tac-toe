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
			System.out.println("Player has chosen X");
		}else if(ch == 'O') {
			playerChoice = 'O';
			computerChoice = 'X';
			System.out.println("Player has chose O");
		}else {
			System.out.println("Invalid choice!!!");
			choice();
		}
	}
	
	public void showBoard() {
		System.out.println("Displaying the board:\n");
		System.out.println("--------------");
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]+" | ");
		System.out.println("--------------");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]+" | ");
		System.out.println("--------------");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]+" | ");
		System.out.println("--------------");
	}

}
