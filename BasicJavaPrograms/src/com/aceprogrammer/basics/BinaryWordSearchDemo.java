package com.aceprogrammer.basics;

import java.io.IOException;
import java.util.Scanner;

import com.aceprogrammer.basics.utilities.BinaryWordSearch;

/**
 * @author Salman Shaikh
 * This app is used to demonstrate word searching using BinarySearch Algorithm
 *
 */
public class BinaryWordSearchDemo {

	/**
	 * @param args
	 * @throws IOException
	 * This method reads the word to be searched from the user
	 * and displays whether the word was found or not
	 */
	public static void main(String[] args) throws IOException {
		
		
		String word;
		try(Scanner sc = new Scanner(System.in);)
		{
		// get user's input
		System.out.println("Enter the word to search");
		word = sc.next();		
		}
		
		BinaryWordSearch bs = new BinaryWordSearch();
		
		bs.readFile();
		bs.sort();
		bs.searchAndDisplay(word);		
	
	}

}
