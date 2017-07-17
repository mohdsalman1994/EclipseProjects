package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StopWatchTimer
{
	public static void main(String args[])throws IOException
	{
		System.out.println("This is a simple timer app");
		System.out.println("Press 1 to start the timer");
		System.out.println("Press 2 to stop the timer");
		startProgram();		
	}

	private static void startProgram() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		// until the user enters 1 keep asking him
		while(!(input.equalsIgnoreCase("1")))
		{
			System.out.println("Please enter 1 to start the watch!");
			input = br.readLine();
		}
		
		// get the starting time
		Long startTime = System.currentTimeMillis();
		
		// read the next input
		input = br.readLine();
		
		// until the user enters 2 keep asking him
		while(!(input.equalsIgnoreCase("2")))
		{
			System.out.println("Please enter 2 to stop the watch!");
			input = br.readLine();
		}
		
		// get the ending time
		Long endTime = System.currentTimeMillis();
		
		// calculate elapsed time in seconds (divide the result by 1000)
		Long elapsedTime = (endTime - startTime) / 1000;
		
		System.out.println("Elapsed Time is "+ elapsedTime+ " seconds");
	}
}