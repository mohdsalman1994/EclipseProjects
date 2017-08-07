package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.utilities.CouponCodes;

/**
 * @author Salman Shaikh
 *
 */
public class CouponCodeDemo {

	/**
	 * @param args
	 * @throws NumberFormatException in case the user enters anything other than a number
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
	    System.out.println("Let's play with coupons");
		System.out.println("Enter the no of coupons you want to generate");
		int noOfCoupons = Integer.parseInt(br.readLine());
		CouponCodes couponCodes = new CouponCodes();
		couponCodes.processCoupons(noOfCoupons);
		}
		
	}

}
