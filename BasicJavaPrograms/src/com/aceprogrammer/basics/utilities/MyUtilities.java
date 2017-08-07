package com.aceprogrammer.basics.utilities;

import java.util.Arrays;
import java.util.Random;

public class MyUtilities {


	public static double factorial(double num)
	{

		double fact = 1;
		for (double i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;		
	}

	/**
	 * @param numNode i.e. the total no of
	 * @return
	 */
	public static double noOfBinarySearchTrees(double numNode) {
		double f1 = factorial(2 * numNode);
		double f2 = factorial(numNode + 1);
		double f3 = factorial(numNode);
		double numTree = f1 / (f2 * f3);
		return numTree;
	}

	/**
	 * @param year i.e. the year to be checked for leap year
	 * This method displays whether the given year is leap year or not.
	 */
	public static void leapYearChecker(int year)
	{
		if(year%400 == 0)
		{
			System.out.println(year+" is a leap year");
		}
		else
			if(year%100 == 0)
			{
				System.out.println(year+" is not a leap year");
			}
			else
				if(year%4 == 0)
				{
					System.out.println(year+" is a leap year");
				}
				else
				{
					System.out.println(year+" is not a leap year");
				}
	}

	public static void powerOfTwo(int n)
	{		
		int i = 0;
		int power = 1;
		System.out.println("Powers of 2 that are less than 2^"+n);
		if(n>0)
		{
			while (i <= n)
			{
				System.out.println("2^"+i+" = " + power);
				power = power * 2;
				i++;
			}
		}
		else
		{
			while (i >= n)
			{
				System.out.println("2^"+i+" = " + power);
				power = power * 2;
				i--;
			}
		}
	}

	/**
	 * @param n i.e. upto which the harmonic is to be generated
	 */
	public static void harmonicGenerator(int n)
	{
		double sum = 0.0;
		for(int i = 1 ; i<=n ; i++)
		{
			sum = sum + 1.0 / i;	
		}

		System.out.println("The "+n+"th Harmonic number is "+sum);
	} 

	/**
	 * @param number i.e. the no to be factorized
	 * This method factorizes given no into non-prime factors
	 */
	public static void factorize(int number)
	{
		// first divide by 2 and print 2 until it is not divisible further by 2
		while(number%2 == 0)
		{
			System.out.print(2 + " ");
			number = number/2;
		}

		// now we know that n will be odd. Hence we can increment
		// by 2 for odd no's and keep going till i <= sqrt(n)
		for (int i = 3; i <= Math.sqrt(number); i += 2) {

			// print i until undivisible further 		
			while(number%i == 0)
			{
				System.out.print(i+" ");
				number = number/i;
			}

		}

		// This condition is to handle the case when n is
		// a prime no.
		// Take example of 88 and try solving to get this case
		if(number > 2)
		{
			System.out.println(number);
		}

	}

	/**
	 * @param stake i.e. the money with which the user will start the game
	 * @param goal i.e. user's target to be reached
	 * this method simulates a gambling game
	 * where the user keeps betting 1$ and 
	 * keeps playing until he has reached goal or
	 * he loses all money
	 * 
	 */
	public static void gamble(int stake, int goal){
		int win = 0;
		int loss = 0;
		float totalGambles = 0;
		int gamble = 0;
		Random random = new Random();
		do
		{
			gamble = random.nextInt(2);
			System.out.println(gamble);
			totalGambles++;
			if(gamble == 0)
			{
				stake++;
				System.out.println("Yay you won! You now have "+stake+". Your goal:"+goal);
				win++;
			}
			else
			{
				stake--;
				System.out.println("Bad luck!You lost! You now have "+stake+". Your goal:"+goal);
				loss++;
			}			
		}
		while(!(stake == 0 || stake == goal));

		System.out.println("You won "+win+" times");
		float winp = (win/totalGambles)*100;
		System.out.println("Win percent%"+winp);
		float lossp = (loss/totalGambles)*100;
		System.out.println("Loss percent%"+lossp);

	}

	/**
	 * @param firstString
	 * @param secondString
	 * This method displays whether two given strings are
	 * anagrams of each other or not.
	 */
	public static void anagram(String firstString, String secondString)
	{
		// first we convert both strings to a character array
		// you can even read directly into a character array if you wish
		char[] first = firstString.toCharArray();
		char[] second = secondString.toCharArray();

		// we will first sort both arrays
		Arrays.sort(first);
		Arrays.sort(second);


		// convert them back to string
		firstString = new String(first);
		secondString = new String(second);

		// after sorting if both are anagrams then both will contain same characters in same order now!
		if(firstString.equals(secondString))
		{
			System.out.println("Yes. They are anagrams of each other");
		}
		else
		{
			System.out.println("No. They are not anagrams of each other");
		}
	}

}
