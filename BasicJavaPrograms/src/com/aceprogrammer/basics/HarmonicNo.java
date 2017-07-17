package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class HarmonicNo
{

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
