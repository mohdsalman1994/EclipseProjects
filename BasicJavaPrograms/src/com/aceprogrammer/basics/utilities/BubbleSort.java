package com.aceprogrammer.basics.utilities;

import java.util.Scanner;

/**
 * @author Salman Shaikh
 *
 */
public class BubbleSort {
	
	// collection of numbers with given length
	private int[] numbers;
	private int length;

	/**
	 * reads the nos to be sorted from the user
	 */
	public void read()
	{
		System.out.println("Enter the total nos to be read");
		
		try(Scanner sc = new Scanner(System.in))
		{
			length = sc.nextInt();
			
			numbers = new int[length];
			
			System.out.println("Enter the elements");
			
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = sc.nextInt();
			}
									
			
		}
	}
	
	/**
	 * sorts the input from user in ascending order
	 * using bubblesort algorithm
	 */
	public void sort()
	{
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i -1; j++) {
				if(numbers[j] > numbers[j+1])
				{
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					
				}
			}
		}
	}
	
	/**
	 * displays the sorted array
	 */
	public void display()
	{
		System.out.println("The sorted array :");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf(" %d \t", numbers[i]);
		}
	}

}
