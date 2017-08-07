package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.NumberGuesser;

/**
 * @author Salman Shaikh
 *
 */
public class NumberGuessDemo {

	
	/**
	 * @param args
	 * @throws IOException
	 * This app simulates a number guessing game
	 * which uses binary search to search the given element
	 */
	public static void main(String[] args) throws IOException {
		
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
		System.out.println("Let's play a game of number guessing");
		System.out.println("Enter the maximum no");
		int maxNo = Integer.parseInt(br.readLine());
		NumberGuesser numberGuesser = new NumberGuesser(maxNo);
		numberGuesser.guess();
		numberGuesser.display();
		}

	}

}






