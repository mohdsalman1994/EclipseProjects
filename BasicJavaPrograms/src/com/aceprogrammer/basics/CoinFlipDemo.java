package com.aceprogrammer.basics;

import com.aceprogrammer.basics.utilities.CoinFlip;

/**
 * @author Salman Shaikh
 *
 */
public class CoinFlipDemo {

	/**
	 * @param args
	 * this app simulates a coin flipping game
	 * where you can flip the coin n no of times
	 * and check how many times you were lucky enough
	 * to win the toss
	 */
	public static void main(String[] args) {
		
		CoinFlip coinFlip = new CoinFlip();
		
		coinFlip.play();
	}

}
