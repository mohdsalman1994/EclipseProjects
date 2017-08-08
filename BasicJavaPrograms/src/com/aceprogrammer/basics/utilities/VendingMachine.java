package com.aceprogrammer.basics.utilities;

public class VendingMachine {

	// the set of coins
	private int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	// array used to store the total no of notes required corresponding to each coin type
	private int[] noteQuantiy = new int[coins.length];

	// input money to the vending machine
	private int sum = 854;


	/**
	 * starts the vending machine
	 */
	public void start()
	{

		System.out.println("Total no of notes required:"+findMinCoins(coins, sum));
		for (int i = 0; i < coins.length; i++) {
			if(noteQuantiy[i] > 0)
				System.out.printf("%d notes of %d Rs. \n", noteQuantiy[i], coins[i]);
		}
	}

	// Assume coin array is sorted. if not sort the array first.
	/**
	 * @param coins i.e. the set of coins
	 * @param sum i.e. the amount of money input to the vending machine
	 * @return
	 */
	private int findMinCoins(int[] coins, int sum) {
		// base case
		if (sum <= 0 || coins.length == 0) {
			return 0;
		}


		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] <= sum) {
				noteQuantiy[i]= sum/coins[i] ; 
				return sum/coins[i] + findMinCoins(coins, sum%coins[i]);
			}
		}
		return 0;
	}


}
