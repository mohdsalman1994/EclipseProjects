package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class AnagramTestApp {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the first string");		
		String s1 = br.readLine();
		System.out.println("Enter the second string");
		String s2 = br.readLine();

		MyUtilities.anagram(s1, s2);


	}

}
