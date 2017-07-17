package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class LeapYearCheck
{
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

