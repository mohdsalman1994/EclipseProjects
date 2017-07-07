package com.aceprogrammer.basics;

import java.io.Console;

public class LeapYearCheck
{
	public static void main(String args[])
	{

	Console console = System.console();
	if(console == null)
	{
	System.exit(0);
	}
	else
	{
	System.out.println("Enter the year which you want to be checked.");
	String yearString = console.readLine();
	int year = Integer.parseInt(yearString);
	leapYearChecker(year);
	}
	}
	static void leapYearChecker(int year)
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
}	

