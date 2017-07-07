package com.aceprogrammer.basics;

import java.io.Console;
public class HelloWorld
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
	System.out.println("Enter your name.");
	String name = console.readLine();
	while(name.length() < 3)
	{
	 System.out.println("Your name should have at least 3 characters(My lucky no!)"
				+"\nPlease enter your name again.");
	name = console.readLine();
	}
	System.out.println("Hello "+name+", how are you today? Welcome to the world of Java.");
	}
	}
}

