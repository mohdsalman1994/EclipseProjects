package com.aceprogrammer.basics;

import java.util.Arrays;

public class UtilityClassDemo {

	public static void main(String[] args) {
		
		
		System.out.println("This is a demonstration of my Utility Class");
		
		// our arrays used for demonstration
		int[] unsortedIntArray = { 54, 31, 21, 45, 11, 13, 18, 38, 48};				
		int[] sortedIntArray = { 11, 12, 18, 21, 31, 38, 45, 48, 54}; 
		
		String[] unsortedStringArray = {"gamma", "alpha", "beta", "delta", "hexa", "amma"};
		String[] sortedStringArray = {"alpha", "amma", "beta", "delta", "gamma", "hexa"};
		
		UtilityClassDemo utility = new UtilityClassDemo();
		StopWatch stopWatch = new StopWatch();
		
		// call each method and store the time required to perform each function
		
		stopWatch.start();
		int pos1 =utility.binarySearch(sortedIntArray, 45);
		stopWatch.stop();
		long elapsedTime1 = stopWatch.getElapsedTime();
		System.out.println(pos1);
		System.out.println("Elapsed Time: "+ elapsedTime1);
		
		// end time
		
		stopWatch.start();
		int pos2 = utility.binarySearch(sortedStringArray, "amma");
		stopWatch.stop();
		long elapsedTime2 = stopWatch.getElapsedTime();
		System.out.println(pos2);
		System.out.println("Elapsed Time: "+ elapsedTime2);
			
		
		stopWatch.start();
		utility.bubbleSort(unsortedIntArray);
		stopWatch.stop();
		long elapsedTime3 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime3);
		
		stopWatch.start();
		utility.bubbleSort(unsortedStringArray);
		stopWatch.stop();
		long elapsedTime4 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime4);
		
		stopWatch.start();
		utility.insertionSort(unsortedIntArray);
		stopWatch.stop();
		long elapsedTime5 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime5);
		
		stopWatch.start();
		utility.insertionSort(unsortedStringArray);
		stopWatch.stop();
		long elapsedTime6 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime6);

	}
	
	
	private int binarySearch(int[] array, int key)
	{
		int result = Arrays.binarySearch(array, key);
		return result;
	}
	
	
	private int binarySearch(String[] array, String key)
	{
		int result = Arrays.binarySearch(array, key);
		return result;
	}
	
	private void insertionSort(int[] array)
	{
		// sort the array first
		for(int i = 1; i < array.length; i++)
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
		
		// display the sorted array
		displaySortedArray(array);
	}
	
	private void insertionSort(String[] array)
	{
		// sort the array first
		for(int i = 1; i < array.length; i++)
		{
			// one pivotal element to start comparision or also the upcoming element
			// which will need to be put in the appropiate position to keep the elements sorted
			String key = array[i];
			
			int j = i-1;
			
			// keep shifting elements until the right position is found
			while( j >= 0 && array[j].compareTo(key)>0)
			{
				array[j+1] = array[j];
				j = j - 1;
			}
			// since j will be one less than the position at which
			// we need to insert the key element we insert at j+1
			array[j+1] = key;
		}
		
		// display the sorted array
		displaySortedArray(array);
		
		
	}
	
	private void bubbleSort(int[] array)
	{
		// sort the array first
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i -1; j++) {
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					
				}
			}
		}
		
		// display the sorted array
		displaySortedArray(array);
		
		
	}
	
	private void bubbleSort(String[] array)
	{
		// sort the array first
		for (int i = 0; i < array.length - 1; i++) {
            for (int j= 0; j < array.length - i -1; j++) {
                if(array[j+1].compareTo(array[j])<0) {
                   String tempStr = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempStr;
                }
            }
        }
		
		// display the sorted array
		displaySortedArray(array);
		
	}
	
	private void displaySortedArray(int[] array)
	{
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	private void displaySortedArray(String[] array)
	{
		for (String i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}


}
