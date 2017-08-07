package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.utilities.ArrayReaderLibrary;

/**
 * @author bridgeit
 * This app is used to demonstrate a 2D array Library
 *
 */
public class ArrayReaderLibraryApp {

	/**
	 * @param args
	 * This reads the type of array user wants to create,
	 * takes the data from the user
	 * and displays the 2D array as output
	 */
	public static void main(String[] args) {
	
		ArrayReaderLibrary library = new ArrayReaderLibrary();
	
	
		try(Scanner s = new Scanner(System.in);)
		{
			library.readInfo(s);
	
			library.createArray();
	
			library.readArray(s);
	
			library.displayArray();
		}
	
	
	
	}

	

}
