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
	
	public void choice() {
		System.out.println("Choose the letter(X/O) ");
		char ch = in.next().charAt(0);
		if(ch == 'X') {
			playerChoice = 'X';
			computerChoice = 'O';
		}else {
			playerChoice = 'O';
			computerChoice = 'X';
		}
			
		
	}

}
