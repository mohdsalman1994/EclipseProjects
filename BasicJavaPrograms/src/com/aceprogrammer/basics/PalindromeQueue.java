package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class PalindromeQueue {
	
	
	// using inbuilt ArrayDeque of Characters
	private ArrayDeque<Character> deque;

	public static void main(String[] args)throws IOException {
		
		System.out.println("Enter the string to be checked");
		
		String s;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			
			// wait for the user to enter a string
			do
			{
			s = br.readLine();		
			}
			while(s == null);
		}
		
		PalindromeQueue pqueue = new PalindromeQueue(s);
		
		pqueue.check();
		
		}
	

	// convert input String to array of characters
	public PalindromeQueue(String s) {
		
		deque = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			
			// directly adding the characters assuming the user will enter only characters but no other characters
			deque.add(s.charAt(i));
		}
		
	}
	
	
	// the function who does all the magic
	private void check() 
	{
		
		boolean found = true;
		char first;
		char last;
		
		int i = 0;
		
		// for both even and odd size this will run at the most half the length of the string
		while(i < deque.size()/2 && found == true)
		{
			first = deque.removeFirst();
			last = deque.removeLast();
			
			// remove first and last and check if both are same or not
			// end the loop if they are not the same
			if(first != last)
			{
				found = false;
			}
		}
		
		if(found == true)
			System.out.println("The given string is palindrome");
		
		else
			System.out.println("The given string is not palindrome");
		
	}
	

	}
