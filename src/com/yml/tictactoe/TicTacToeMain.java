package com.yml.tictactoe;

public class TicTacToeMain {

	public static void main(String[] args) {
		System.out.println("Welcome to tictactoe game");
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		game.choice();
		game.toss();
	}

}
