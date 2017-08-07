package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.PalindromeQueue;

public class PalindromeQueueDemo {

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

}
