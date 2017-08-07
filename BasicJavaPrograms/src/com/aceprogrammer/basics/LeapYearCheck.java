package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class LeapYearCheck
{
	/**
	 * @param args
	 * This app takes the year to be checked from the user as input
	 * and displays whether the given year is leap year or not.
	 */
	public static void main(String args[])
	{

		try(Scanner sc = new Scanner(System.in);)	
		{
			System.out.println("Enter the year which you want to be checked.");	
			int year = sc.nextInt();	
			MyUtilities.leapYearChecker(year);
		}
	}
}	

