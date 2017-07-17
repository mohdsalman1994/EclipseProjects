package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TripletSum {

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of elements (must be at least 3)");		
		int n = Integer.parseInt(br.readLine());

		// some basic validatiaon :)
		while(n <3)
		{
			System.out.println("Please enter a no greater than 3");
			n = Integer.parseInt(br.readLine());
		}

		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter the element");
			array[i] = Integer.parseInt(br.readLine());
		}

		calculateTriplets(array);

	}

	private static void calculateTriplets(int[] array) {

		int sum = 0;
		for (int i = 0; i < array.length - 2; i++) {

			for (int j = i+1; j < array.length - 1; j++) {

				for (int k = j+ 1; k < array.length; k++) {
					sum = array[i] + array[j] + array[k];
					if(sum == 0)
					{
						System.out.println(array[i] + " " + array[j] + " "+ array[k]);
					}
				}
			}
		}
	}

}
