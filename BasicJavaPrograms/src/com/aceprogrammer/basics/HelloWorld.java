package com.aceprogrammer.basics;

import java.util.Scanner;

/**
 * @author Salman Shaikh
 *
 */
public class HelloWorld
{
	/**
	 * @param args
	 * My first java program in this project.
	 * This method takes user's name as input
	 * and displays a welcome message with the user's name
	 */
	public static void main(String args[])
	{

		try(Scanner sc = new Scanner(System.in))
		{		
			System.out.println("Enter your name.");
			String name = sc.next();
			while(name.length() < 3)
			{
				System.out.println("Your name should have at least 3 characters(My lucky no!)"
						+"\nPlease enter your name again.");
				name = sc.next();
			}	
			System.out.println("Hello "+name+", how are you today? Welcome to the world of Java.");
		}
	}
}

