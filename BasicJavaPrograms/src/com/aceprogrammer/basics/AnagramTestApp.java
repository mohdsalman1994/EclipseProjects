package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 * 
 * This app is used to test Strings for Anagram
 *
 */
public class AnagramTestApp {

	/**
	 * @param args
	 * @throws NumberFormatException in case the user enters Strings
	 * @throws IOException
	 * This method reads two strings from the user and
	 * displays whether given two strings are anagrams of each other or not
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		// the two words that need to be checked for anagram
		String firstWord = null;
		String secondWord = null;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.println("Enter the first string");		
			firstWord = br.readLine();
			System.out.println("Enter the second string");
			secondWord = br.readLine();
		} 

		MyUtilities.anagram(firstWord, secondWord);


	}

}
