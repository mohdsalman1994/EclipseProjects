package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class PowerOfTwo {

	/**
	 * @param args
	 * @throws IOException
	 * This app generates the power of two uptil 2^n
	 * where -31 < n < 31 and n is the input given by the user
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Let's play with the power of 2");
		System.out.println("Enter the powers upto which you want to play ( -31 < n < 31)");

		int n = Integer.parseInt(br.readLine());
		while (!(n < -31) && (n > 31))
		{
			System.out.println("Please enter a no between the specified range");
			n = Integer.parseInt(br.readLine());
		}
		MyUtilities.powerOfTwo(n);
	}
}

