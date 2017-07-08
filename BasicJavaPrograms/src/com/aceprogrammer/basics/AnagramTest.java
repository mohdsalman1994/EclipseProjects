	package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnagramTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter the first string");		
		String s1 = br.readLine();
		System.out.println("Enter the second string");
		String s2 = br.readLine();
		
		
		// first we convert both strings to a character arra
		// you can even read directly into a character array if you wish
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		
		// we will first sort both arrays
		Arrays.sort(first);
		Arrays.sort(second);
		
		
		// convert them back to string
		s1 = new String(first);
		s2 = new String(second);
		
		// after sorting if both are anagrams then both will contain same characters in same order now!
		if(s1.equals(s2))
		{
			System.out.println("Yes. They are anagrams of each other");
		}
		else
		{
			System.out.println("Yes. They are not anagrams of each other");
		}
		

	}

}