package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.StopWatch;

/**
 * @author Salman Shaikh
 *
 */
public class StopWatchTimer
{
	/**
	 * @param args
	 * @throws IOException
	 * This app demonstrates a simulation of
	 * a simple stop watch.
	 */
	public static void main(String args[])throws IOException
	{
		System.out.println("This is a simple timer app");
		System.out.println("Press 1 to start the timer");
		System.out.println("Press 2 to stop the timer");		

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			String input = br.readLine();

			// until the user enters 1 keep asking him
			while(!(input.equalsIgnoreCase("1")))
			{
				System.out.println("Please enter 1 to start the watch!");
				input = br.readLine();
			}

			StopWatch stopWatch = new StopWatch();

			// start the stopWatch
			stopWatch.start();

			// read the next input
			input = br.readLine();

			// until the user enters 2 keep asking him
			while(!(input.equalsIgnoreCase("2")))
			{
				System.out.println("Please enter 2 to stop the watch!");
				input = br.readLine();
			}

			// stop the stopWatch
			stopWatch.stop();

			// calculate elapsed time in seconds (divide the result by 1000)
			Long elapsedTime = stopWatch.getElapsedTime();

			System.out.println("Elapsed Time is "+ elapsedTime+ " seconds");
		}
	}
}

