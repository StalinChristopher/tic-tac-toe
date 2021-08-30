package com.yml.tictactoe;

import java.lang.annotation.Repeatable;
import java.util.*;

/**
 * @class in which methods to create TICTACTOE game is written
 * @author stalincd
 *
 */
public class TicTacToeGame {

	Scanner in = new Scanner(System.in);

	// array to create a array of board of type char
	private char board[] = new char[10];

	// variables to choose X or O for player and computer
	char playerChoice, computerChoice;

	// Random class object
	private Random random = new Random();

	// variable to shift turns between player and computer
	private int winFlag;

	/**
	 * @method to create an empty board
	 */
	public void createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}

	/**
	 * @method to set player's letter choice
	 */
	public void choice() {
		System.out.println("Choose the letter(X/O) ");
		char ch = in.next().charAt(0);
		ch = Character.toUpperCase(ch);
		if (ch == 'X') {
			playerChoice = 'X';
			computerChoice = 'O';
			System.out.println("Player has chosen X\n");
		} else if (ch == 'O') {
			playerChoice = 'O';
			computerChoice = 'X';
			System.out.println("Player has chosen O\n");
		} else {
			System.out.println("Invalid choice!!!");
			choice();
		}
	}

	/**
	 * @method To display the board
	 */
	public void showBoard() {
		System.out.println("Displaying the board:\n");
		System.out.println("------------");
		System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " | ");
		System.out.println("------------");
		System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " | ");
		System.out.println("------------");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " | ");
		System.out.println("------------");
	}

	/**
	 * @method To select a location from the user
	 */
	public void selectLocation() {
		System.out.println("Enter the location where you want to enter " + playerChoice + " in the board");
		int location = in.nextInt();
		while (location < 1 || location > 9) {
			System.out.println("Enter a valid location between 1 and 9");
			location = in.nextInt();
		}
		if (board[location] == ' ') {
			System.out.println("Your location has been selected in the board\n");
			board[location] = playerChoice;
			showBoard();
			checkWinCondition();

		} else {
			System.out.println("Please enter another location as the previous location has already been occupied\n");
			selectLocation();
		}
	}

	/**
	 * @method Toss to decide who plays first
	 */
	public void toss() {
		System.out.println("Enter your choice 1.Heads  2.Tails");
		int choice = in.nextInt();
		while (choice < 1 || choice > 2) {
			System.out.println("Invalid choice!! Enter a valid choice between 1 and 2");
			choice = in.nextInt();
		}
		int tossChoice = random.nextInt(2) + 1;
		System.out.println("Random : " + tossChoice);
		if (choice == tossChoice) {
			System.out.println("You have won the toss. You will play first.\n");
			playerTurn();
		} else {
			System.out.println("Sorry! You have lost the toss. Computer will play first.\n");
			computerTurn();
		}
	}

	/**
	 * @method To check if all positions are occupied
	 */
	public int checkTie() {
		for (int i = 1; i <= 9; i++) {
			if (board[i] == ' ')
				return 0;
		}
		return 1;
	}

	/**
	 * @method to check if any one of the possibilities to win satisfy
	 */
	public char checkWinnerExist() {
		String[] possibilities = new String[8];
		char result = 'N';
		possibilities[0] = "" + board[1] + board[2] + board[3];
		possibilities[1] = "" + board[4] + board[5] + board[6];
		possibilities[2] = "" + board[7] + board[8] + board[9];
		possibilities[3] = "" + board[1] + board[4] + board[7];
		possibilities[4] = "" + board[2] + board[5] + board[8];
		possibilities[5] = "" + board[3] + board[6] + board[9];
		possibilities[6] = "" + board[1] + board[5] + board[9];
		possibilities[7] = "" + board[3] + board[5] + board[7];
		for (int i = 0; i < 8; i++) {
			if (possibilities[i].equals("XXX")) {
				result = 'X';
				break;
			} else if (possibilities[i].equals("OOO")) {
				result = 'O';
				break;
			}
		}
		return result;
	}

	/**
	 * @method to check if the player can win the game or if not select a new
	 *         location
	 */
	public void playerTurn() {
		checkWinCondition();
		if (winFlag == 0) {
			selectLocation();
			if (winFlag == 0) {
				computerTurn();
			}
		}
	}

	/**
	 * @method to set the winFlag variable to decide if the player or computer
	 *         should play next turn
	 */
	public void checkWinCondition() {
		char winVariable = checkWinnerExist();
		if (winVariable == playerChoice) {
			System.out.println("Congratulations!!! You have won the game");
			repeatGame();
			winFlag = 1;
		} else if (winVariable == computerChoice) {
			System.out.println("Sorry!!! Computer has won the game");
			repeatGame();
			winFlag = 1;
		} else if (checkTie() == 1) {
			System.out.println("Game has been tied");
			repeatGame();
			winFlag = 1;
		} else {
			winFlag = 0;
		}
	}

	/**
	 * @method to check if the computer can win the game or block the player's
	 *         winning move or choose random location in the board
	 */
	private void computerTurn() {
		System.out.println("Computer is playing right now ......\n");
		checkWinCondition();
		if (winFlag == 0) {
			if ((board[1] == ' ') && ((board[2] == board[3] && board[2] == computerChoice)
					|| (board[4] == board[7] && board[4] == computerChoice)
					|| (board[5] == board[9] && board[5] == computerChoice))) {
				board[1] = computerChoice;
			} else if ((board[2] == ' ') && ((board[1] == board[3] && board[3] == computerChoice)
					|| (board[5] == board[8] && board[8] == computerChoice))) {
				board[2] = computerChoice;
			} else if ((board[3] == ' ') && ((board[1] == board[2] && board[2] == computerChoice)
					|| (board[6] == board[9] && board[9] == computerChoice)
					|| (board[5] == board[7] && board[7] == computerChoice))) {
				board[3] = computerChoice;
			} else if ((board[4] == ' ') && ((board[1] == board[7] && board[1] == computerChoice)
					|| (board[5] == board[6] && board[6] == computerChoice))) {
				board[4] = computerChoice;
			} else if ((board[5] == ' ') && ((board[1] == board[9] && board[2] == computerChoice)
					|| (board[7] == board[3] && board[7] == computerChoice)
					|| (board[2] == board[8] && board[8] == computerChoice)
					|| (board[4] == board[6] && board[6] == computerChoice))) {
				board[5] = computerChoice;
			} else if ((board[6] == ' ') && ((board[9] == board[3] && board[3] == computerChoice)
					|| (board[5] == board[4] && board[4] == computerChoice))) {
				board[6] = computerChoice;
			} else if ((board[7] == ' ') && ((board[1] == board[4] && board[4] == computerChoice)
					|| (board[3] == board[5] && board[3] == computerChoice)
					|| (board[8] == board[9] && board[8] == computerChoice))) {
				board[3] = computerChoice;
			} else if ((board[8] == ' ') && ((board[9] == board[7] && board[7] == computerChoice)
					|| (board[2] == board[5] && board[2] == computerChoice))) {
				board[8] = computerChoice;
			} else if ((board[9] == ' ') && ((board[1] == board[5] && board[5] == computerChoice)
					|| (board[6] == board[3] && board[3] == computerChoice)
					|| (board[8] == board[7] && board[7] == computerChoice))) {
				board[9] = computerChoice;
			}

			// Rest of the if else conditions will block the player's move in case the
			// player is about to win
			else if ((board[1] == ' ') && ((board[2] == board[3] && board[2] == playerChoice)
					|| (board[4] == board[7] && board[4] == playerChoice)
					|| (board[5] == board[9] && board[5] == playerChoice))) {
				board[1] = computerChoice;
			} else if ((board[2] == ' ') && ((board[1] == board[3] && board[3] == playerChoice)
					|| (board[5] == board[8] && board[8] == playerChoice))) {
				board[2] = computerChoice;
			} else if ((board[3] == ' ') && ((board[1] == board[2] && board[2] == playerChoice)
					|| (board[6] == board[9] && board[9] == playerChoice)
					|| (board[5] == board[7] && board[7] == playerChoice))) {
				board[3] = computerChoice;
			} else if ((board[4] == ' ') && ((board[1] == board[7] && board[1] == playerChoice)
					|| (board[5] == board[6] && board[6] == playerChoice))) {
				board[4] = computerChoice;
			} else if ((board[5] == ' ') && ((board[1] == board[9] && board[1] == playerChoice)
					|| (board[7] == board[3] && board[7] == playerChoice)
					|| (board[2] == board[8] && board[8] == playerChoice)
					|| (board[4] == board[6] && board[6] == playerChoice))) {
				board[5] = computerChoice;
			} else if ((board[6] == ' ') && ((board[9] == board[3] && board[3] == playerChoice)
					|| (board[5] == board[4] && board[4] == playerChoice))) {
				board[6] = computerChoice;
			} else if ((board[7] == ' ') && ((board[1] == board[4] && board[4] == playerChoice)
					|| (board[6] == board[9] && board[9] == playerChoice)
					|| (board[5] == board[7] && board[7] == playerChoice))) {
				board[7] = computerChoice;
			} else if ((board[8] == ' ') && ((board[9] == board[7] && board[7] == playerChoice)
					|| (board[2] == board[5] && board[2] == playerChoice))) {
				board[8] = computerChoice;
			} else if ((board[9] == ' ') && ((board[1] == board[5] && board[5] == playerChoice)
					|| (board[6] == board[3] && board[3] == playerChoice)
					|| (board[8] == board[7] && board[7] == playerChoice))) {
				board[9] = computerChoice;
			}

			// Selecting random corners or centre of the board or if both are not available
			// then any random position
			else {
				cornerCentreRandom();
			}
		}
		showBoard();
		if (winFlag == 0) {
			playerTurn();
		}

	}

	/**
	 * @method to find a available corner, centre or if not both then a random
	 *         position on the board
	 */
	public void cornerCentreRandom() {
		int corners[] = { 1, 3, 7, 9 }; // These are the corner index of the board
		boolean flag = true;
		int emptyIndexFill = 0;
		int randIndex;
		for (int i : corners) {
			if (board[i] == ' ') {
				board[i] = computerChoice;
				flag = false;
				break;
			}
		}
		if (flag) {
			if (board[5] == ' ') {
				board[5] = computerChoice;
			} else {
				while (emptyIndexFill == 0) {
					randIndex = random.nextInt(9) + 1;
					if (board[randIndex] == ' ') {
						emptyIndexFill = 1;
						board[randIndex] = computerChoice;
					}
				}
			}
		}
	}

	// UC12 code is already present in the program as the game runs properly and
	// ends with the player or computer winning or results in the draw if all the
	// positions are occupied

	/**
	 * @method to ask the player if he/she wants to play again
	 */
	public void repeatGame() {
		System.out.println("\nDo you want to play again? Enter your choice(1/2) \n1.Yes\n2.No\n");
		int choice = in.nextInt();
		while(choice<1 || choice >2){
			System.out.println("Invalid choice!!! Please enter a valid choice between 1 and 2");
			choice = in.nextInt();
		}
		if (choice == 1) {
			createBoard();  //Creating a new board
			choice();		//Enter player's choice of letter (X/O)
			toss();			//Initialise the game by tossing a coin to decide who plays first
		}
	}

}
