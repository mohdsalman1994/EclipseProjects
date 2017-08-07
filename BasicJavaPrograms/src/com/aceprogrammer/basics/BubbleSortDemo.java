package com.aceprogrammer.basics;

import com.aceprogrammer.basics.utilities.BubbleSort;

/**
 * @author Salman Shaikh
 *
 */
public class BubbleSortDemo {

	/**
	 * @param args
	 * Reads the nos from the user
	 * sorts them and displays the sorted nos
	 * 
	 */
	public static void main(String[] args) {
		
		
		BubbleSort bs = new BubbleSort();
		
		
		// read the input from the user
		bs.read();
		
		// sort the array
		bs.sort();
		
		// display the sorted output
		bs.display();
	
	}

}
