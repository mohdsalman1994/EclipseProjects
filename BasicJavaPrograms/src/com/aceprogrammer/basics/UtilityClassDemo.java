package com.aceprogrammer.basics;


import com.aceprogrammer.basics.utilities.MyUtilities;
import com.aceprogrammer.basics.utilities.StopWatch;

public class UtilityClassDemo {

	/**
	 * @param args
	 * This app demonstrates some functions from the MyUtilities class
	 */
	public static void main(String[] args) {
		
		
		System.out.println("This is a demonstration of a few functions from my Utility Class");
		
		// our arrays used for demonstration
		int[] unsortedIntArray = { 54, 31, 21, 45, 11, 13, 18, 38, 48};				
		int[] sortedIntArray = { 11, 12, 18, 21, 31, 38, 45, 48, 54}; 
		
		String[] unsortedStringArray = {"gamma", "alpha", "beta", "delta", "hexa", "amma"};
		String[] sortedStringArray = {"alpha", "amma", "beta", "delta", "gamma", "hexa"};
				
		StopWatch stopWatch = new StopWatch();
		
		// call each method and store the time required to perform each function
		
		stopWatch.start();
		int pos1 =MyUtilities.binarySearch(sortedIntArray, 45);
		stopWatch.stop();
		long elapsedTime1 = stopWatch.getElapsedTime();
		System.out.println(pos1);
		System.out.println("Elapsed Time: "+ elapsedTime1);
		
		// end time
		
		stopWatch.start();
		int pos2 = MyUtilities.binarySearch(sortedStringArray, "amma");
		stopWatch.stop();
		long elapsedTime2 = stopWatch.getElapsedTime();
		System.out.println(pos2);
		System.out.println("Elapsed Time: "+ elapsedTime2);
			
		
		stopWatch.start();
		MyUtilities.bubbleSort(unsortedIntArray);
		stopWatch.stop();
		long elapsedTime3 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime3);
		
		stopWatch.start();
		MyUtilities.bubbleSort(unsortedStringArray);
		stopWatch.stop();
		long elapsedTime4 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime4);
		
		stopWatch.start();
		MyUtilities.insertionSort(unsortedIntArray);
		stopWatch.stop();
		long elapsedTime5 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime5);
		
		stopWatch.start();
		MyUtilities.insertionSort(unsortedStringArray);
		stopWatch.stop();
		long elapsedTime6 = stopWatch.getElapsedTime();
		System.out.println("Elapsed Time: "+ elapsedTime6);

	}
	
	
		
	

}
