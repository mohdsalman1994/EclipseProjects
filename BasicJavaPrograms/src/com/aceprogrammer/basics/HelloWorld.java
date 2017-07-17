package com.aceprogrammer.basics;

import java.util.Scanner;

public class HelloWorld
{
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

