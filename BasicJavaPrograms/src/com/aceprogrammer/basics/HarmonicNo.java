package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class HarmonicNo
{

	/**
	 * @param args
	 * This method takes input from the user n
	 * and displays the nth Harmonic no.
	 */
	public static void main(String args[])
	{

		try(Scanner sc = new Scanner(System.in);)	
		{			
			System.out.println("Enter N upto which the Harmonic no is to be calculated.");				
			int n = sc.nextInt();
			MyUtilities.harmonicGenerator(n);

		} 
	}
}
