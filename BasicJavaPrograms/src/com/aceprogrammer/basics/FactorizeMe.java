package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class FactorizeMe {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Let's do some factorization magic");
		System.out.println("Enter a number");
		int number = Integer.parseInt(br.readLine());
		MyUtilities.factorize(number);

	}

}
