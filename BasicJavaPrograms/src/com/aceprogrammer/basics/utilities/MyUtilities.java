package com.aceprogrammer.basics.utilities;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtilities {


	/**
	 * @param number i.e. the number whose factorial is to be calculated
	 * @return the factorial for the given input
	 */
	public static double factorial(double number)
	{

		double fact = 1;
		for (double i = 1; i <= number; i++) {
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

	/**
	 * @param n
	 * This method calculates the power of two
	 * and displays the result for each power.
	 */
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

	/**
	 * @param sourceString i.e. the original string which is to be modified
	 * @param searchString i.e. the pattern or string to be found
	 * @param replaceString i.e. the string to replace the searchString if found
	 * @return modified sourceString if search string is replaced else
	 * return the sourceString untouched. 
	 */
	public static String searchAndReplace(String sourceString, String searchString,String replaceString)
	{
		Pattern pattern = Pattern.compile(searchString);
		Matcher matcher = pattern.matcher(sourceString);

		if(matcher.find())
		{
			return sourceString.replace(sourceString.substring(matcher.start(), matcher.end()), replaceString);
		}
		else
			return sourceString;
	}

	/**
	 * @param array i.e. the list of nos to be searched for triplets
	 * @param tripletSum i.e. the sum to be satisfied by triplets from the given array.
	 */
	public static void calculateTriplets(int[] array, int tripletSum) {

		int sum = 0;

		for (int i = 0; i < array.length - 2; i++) {

			for (int j = i+1; j < array.length - 1; j++) {

				for (int k = j+ 1; k < array.length; k++) {
					sum = array[i] + array[j] + array[k];
					if(sum == tripletSum)
					{
						System.out.println(array[i] + " " + array[j] + " "+ array[k]);
					}
				}
			}
		}
	}
	
	/**
	 * @param array i.e. the array from which to be searched
	 * @param key i.e. the value which is to be search
	 * @return
	 */
	public static int binarySearch(int[] array, int key)
	{
		int result = Arrays.binarySearch(array, key);
		return result;
	}
	
	
	public static int binarySearch(String[] array, String key)
	{
		int result = Arrays.binarySearch(array, key);
		return result;
	}

	public static void bubbleSort(int[] array)
	{
		// sort the array first
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i -1; j++) {
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					
				}
			}
		}
		
		// display the sorted array
		displaySortedArray(array);
		
		
	}
	
	public static void bubbleSort(String[] array)
	{
		// sort the array first
		for (int i = 0; i < array.length - 1; i++) {
            for (int j= 0; j < array.length - i -1; j++) {
                if(array[j+1].compareTo(array[j])<0) {
                   String tempStr = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempStr;
                }
            }
        }
		
		// display the sorted array
		displaySortedArray(array);
		
	}
	
	public static void displaySortedArray(int[] array)
	{
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void displaySortedArray(String[] array)
	{
		for (String i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
	
	public static void insertionSort(int[] array)
	{
		// sort the array first
		for(int i = 1; i < array.length; i++)
		{
			// one pivotal element to start comparision or also the upcoming element
			// which will need to be put in the appropiate position to keep the elements sorted
			int key = array[i];
			
			int j = i-1;
			
			// keep shifting elements until the right position is found
			while( j >= 0 && array[j] > key)
			{
				array[j+1] = array[j];
				j = j - 1;
			}
			// since j will be one less than the position at which
			// we need to insert the key element we insert at j+1
			array[j+1] = key;
		}
		
		// display the sorted array
		displaySortedArray(array);
	}
	
	public static void insertionSort(String[] array)
	{
		// sort the array first
		for(int i = 1; i < array.length; i++)
		{
			// one pivotal element to start comparision or also the upcoming element
			// which will need to be put in the appropiate position to keep the elements sorted
			String key = array[i];
			
			int j = i-1;
			
			// keep shifting elements until the right position is found
			while( j >= 0 && array[j].compareTo(key)>0)
			{
				array[j+1] = array[j];
				j = j - 1;
			}
			// since j will be one less than the position at which
			// we need to insert the key element we insert at j+1
			array[j+1] = key;
		}
		
		// display the sorted array
		displaySortedArray(array);
		
		
	}

}
