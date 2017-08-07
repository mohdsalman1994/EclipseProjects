package com.aceprogrammer.basics;

import com.aceprogrammer.basics.utilities.InsertionSort;

/**
 * @author Salman Shaikh
 *
 */
public class InsertionSortDemo {

	/**
	 * @param args
	 * This app reads data from user,
	 * sorts it using insertion sort
	 * and displays the sorted collection
	 */
	public static void main(String[] args) {
		
		
		InsertionSort isort = new InsertionSort();
		isort.read();
		isort.sort();
		isort.display();
	
	}

}
