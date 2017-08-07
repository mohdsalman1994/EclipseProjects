package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.BalancedParan;

/**
 * @author Salman Shaikh
 * This class is used to check an expression for balanced paranthesis
 *
 */
public class BalancedPranthesisDemo {

	/**
	 * @param args
	 * @throws IOException
	 * This method reads the expression to be checked for balanced paranthesis
	 */
	public static void main(String[] args)throws IOException {
		
		
		System.out.println("Enter the expression to be checked");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
	    String s = br.readLine();
	    System.out.println(BalancedParan.isBalanced(s));
		}
	}

}
