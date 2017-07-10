package com.aceprogrammer.basics;

import java.util.Scanner;

public class InsertionSort {

	
	int[] array;
	int n;
	
	public static void main(String[] args) {
		
		
		InsertionSort isort = new InsertionSort();
		isort.read();
		isort.sort();
		isort.display();

	}
	
	private void read()
	{
		System.out.println("Enter the total nos to be read");
		
		try(Scanner sc = new Scanner(System.in))
		{
			n = sc.nextInt();
			
			array = new int[n];
			
			System.out.println("Enter the elements");
			
			for (int i = 0; i < array.length; i++) {
				array[i] = sc.nextInt();
			}
									
			
		}
	}
	
	
	private void sort()
	{
		for(int i = 1; i < n; i++)
		{
			// one pivotal element to start comparision or also the upcoming element
			// which will need to be put in the appropiate position to keep the elements sorted
			int key = array[i];
			
			int j = i-1;
			
			// keep shifting elements until the right position is found
			while( j >= 0 && array[j] > key)
			{
				array[j+1] = array[j];
				j = j - 1;
			}
			// since j will be one less than the position at which
			// we need to insert the key element we insert at j+1
			array[j+1] = key;
			
		}
	}
	
	private void display()
	{
		System.out.println("The sorted array :");
		for (int i = 0; i < array.length; i++) {
			System.out.printf(" %d \t", array[i]);
		}
	}

}
