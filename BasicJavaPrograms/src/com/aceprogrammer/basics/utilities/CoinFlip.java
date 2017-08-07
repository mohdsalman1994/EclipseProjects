package com.aceprogrammer.basics.utilities;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Salman Shaikh
 *
 */
public class CoinFlip
{
	// random no used to toggle heads or tails in the toss
	private Random random = new Random();
		
	private int head = 0;
	private int tail = 0;
	private int coin = 0;
	private float noOfFlips = 0F;
	private float headfrequency = 0F;
	private float tailfrequency = 0F;

	/**
	 * This method asks the user the no of times
	 * to flip the coin,
	 * then uses random no to simulate whether
	 * the the toss resulted in heads or tails.
	 * Finally it display the head/tail frequency.
	 */
	public void play()
	{

		try(Scanner scanner = new Scanner(System.in);)	
		{
			System.out.println("Let's have some fun tossing coins");
			System.out.println("FYI H will denote heads and T will denote tails");
			System.out.println("Enter the no of times you want to flip the coin:");
			noOfFlips = scanner.nextInt();
			System.out.println("Let's flip the coin for "+noOfFlips+" times");
			for(int i = 1; i <= noOfFlips; i++)
			{
				coin = Math.round(random.nextFloat());
				if(coin == 0)
				{
					System.out.print("H ");
					head++;
				}
				else
				{
					System.out.print("T ");
					tail++;
				}

			}
			headfrequency = head/noOfFlips;
			tailfrequency = tail/noOfFlips;
			System.out.println("\n\nHead frequency(%): "+headfrequency+"%");
			System.out.println("Tail frequency(%): "+tailfrequency+"%");
		}
	}
}


