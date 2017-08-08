package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.MyUtilities;

public class TripletSumDemo {

	/**
	 * @param args
	 * @throws IOException
	 * This app reads a list of numbers (minimum 3 nos)
	 * from the user and returns the triplets which
	 * sum upto the given sum.
	 */
	public static void main(String[] args)throws IOException {

		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
		{
		System.out.println("Enter the no of elements (must be at least 3)");		
		int n = Integer.parseInt(bufferedReader.readLine());

		// some basic validatiaon :)
		while(n <3)
		{
			System.out.println("Please enter a no greater than 3");
			n = Integer.parseInt(bufferedReader.readLine());
		}

		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter the element");
			array[i] = Integer.parseInt(bufferedReader.readLine());
		}
		
		System.out.println("Enter the sum to be checked");
		int sum = Integer.parseInt(bufferedReader.readLine());
		
		MyUtilities.calculateTriplets(array, sum);
		}

	}

}
