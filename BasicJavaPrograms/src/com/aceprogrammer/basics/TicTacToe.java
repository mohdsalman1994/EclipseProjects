package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

enum WhoseTurn
{
	PLAYER, COMPUTER;
}

public class TicTacToe
{

	// this will be our board which is a 2d 3 * 3 matrix
	char[][] board;

	// this will keep track of the available moves
	// if the cell value is true then it is filled else empty
	boolean moves[];

	static int rows = 3;
	static int columns = 3;
	static int tmove = 9;

	WhoseTurn whoseTurn = WhoseTurn.PLAYER;

	Random random = new Random();

	public static void main(String args[]) {



		TicTacToe ticTacToe = new TicTacToe(rows, columns, tmove);		
		ticTacToe.play();
	}




	public TicTacToe(int rows, int columns, int nMoves) {
		board = new char[rows] [columns];

		moves = new boolean[nMoves];


		// initialize the board with empty character
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = ' ';
			}
		}

	}



	private void showBoard()
	{
		System.out.printf("\t %c \t | \t %c \t | \t %c \n\n ",board[0][0],
				board[0][1], board[0][2] );

		System.out.printf("\t %c \t | \t %c \t | \t %c  \n\n",board[1][0],
				board[1][1], board[1][2] );

		System.out.printf("\t %c \t | \t %c \t | \t %c  \n \n \n",board[2][0],
				board[2][1], board[2][2] );
	}

	private void showInstructions()
	{
		System.out.println("\t\t\t  Tic-Tac-Toe\n\n");
		System.out.println("Choose a cell numbered from 1 to 9 as below"+
				" and play\n\n");
		System.out.println("\t 1 \t | \t 2 \t | \t 3  \n");
		System.out.println("\n");
		System.out.println("\t 4 \t | \t 5 \t | \t 6  \n");
		System.out.println("\n");
		System.out.println("\t 7 \t | \t 8 \t | \t 9  \n");

	}

	// function to check who's the winner
	private void declareWinner()
	{

		// we use reverse logic since if we have winning condition true then the player who played the last turn has won
		if(whoseTurn == WhoseTurn.COMPUTER)
		{
			System.out.println("PLAYER HAS WON");
		}
		else
			System.out.println("COMPUTER HAS WON");

	}

	// function to check whether rows are crossed
	private boolean rowCrossed()
	{
		for (int i = 0; i < rows ; i++) {
			if (board[i][0] == board[i][1] &&
					board[i][1] == board[i][2] && 
					board[i][0] != ' ')
				return (true);
		}

		return(false);
	}

	private boolean columnCrossed()
	{
		for (int i = 0; i < columns ; i++) {
			if (board[0][i] == board[1][i] &&
					board[1][i] == board[2][i] && 
					board[0][i] != ' ')
				return (true);
		}

		return(false);
	}

	private boolean diagonalCrossed()
	{
		if (board[0][0] == board[1][1] &&
				board[1][1] == board[2][2] && 
				board[0][0] != ' ')
			return(true);

		if (board[0][2] == board[1][1] &&
				board[1][1] == board[2][0] &&
				board[0][2] != ' ')
			return(true);

		return(false);
	}


	private boolean gameOver()
	{
		return(rowCrossed() || columnCrossed() || diagonalCrossed());
	}

	private void play() {

		int movesPlayed = 0;

		// move index from 1 to 9
		int moveIndex = 0;    	

		// for computing row and col no
		int x = 0;
		int y = 0;

		// showBoard first
		showBoard();


		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			// keep playing till game is over or it's a draw
			while (gameOver() == false && movesPlayed != tmove)
			{

				// check who's turn it is and play accordngly
				if(whoseTurn == WhoseTurn.COMPUTER)
				{
					boolean correctCell = false;
					// keep trying using random no to fill a cell with O simulating a computer

					while(correctCell == false)
					{
						moveIndex = random.nextInt(9);

						if(moves[moveIndex] == false)
						{

							// compute the cells row and column no
							x = (moveIndex ) / rows; // can use column also
							y = (moveIndex )% rows;

							board[x][y] = 'O';
							System.out.println("Computer has placed O in cell "+moveIndex);

							correctCell = true;

							// increase the moves played
							movesPlayed++;

							// change the turn to Computer
							whoseTurn = WhoseTurn.PLAYER;

							// change the cell value to filled
							moves[moveIndex] = true;

							// showBoard
							showBoard();
						}
					}

				}

				else
					if(whoseTurn == WhoseTurn.PLAYER)
					{

						//showInstructions
						showInstructions();

						boolean correctCell = false;

						// keep asking the user to enter correct cell if already filled
						while(correctCell == false)    				
						{

							// ask the player for placing his move as X
							moveIndex = Integer.parseInt(br.readLine()); // - 1 since output cells start with 1

							// add validation if given cell no is not within the specified range


							// add check whether the cell is already filled
							if(moves[moveIndex - 1] == true)
							{
								System.out.println("This cell is already filled please enter another cell no");
							}

							else
							{
								// compute the cells row and column no
								x = (moveIndex - 1) / rows; // can use column also
								y = (moveIndex - 1 )% rows;

								board[x][y] = 'X';
								System.out.println("Human has placed X in cell "+moveIndex);

								correctCell = true;

								// increase the moves played
								movesPlayed++;

								// change the cell value to filled
								moves[moveIndex - 1] = true;

								// change the turn to Computer
								whoseTurn = WhoseTurn.COMPUTER;

								// showBoard
								showBoard();
							}

						}
					}

				// after each move check if the game is tied or anyone has won the game
				if(gameOver() == false && movesPlayed == 9)
				{
					System.out.println("It's a draw!");
				}
				else
					if(gameOver() == true)
					{
						declareWinner();
					}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}