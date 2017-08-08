package com.aceprogrammer.basics;

import com.aceprogrammer.basics.utilities.TicTacToe;


/**
 * @author Salman Shaikh
 *
 */
public class TicTacToeDemo
{

	/**
	 * @param args
	 * This app simulates a tic tac toe game
	 * where the two users are the player
	 * and computer.
	 */
	public static void main(String args[]) {

		TicTacToe ticTacToe = new TicTacToe();		
		ticTacToe.play();
	}

}
