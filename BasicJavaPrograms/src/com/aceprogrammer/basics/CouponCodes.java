package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;

public class CouponCodes {
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Let's play with coupons");
		System.out.println("Enter the no of coupons you want to generate");
		int n = Integer.parseInt(br.readLine());
		processCoupons(n);	
	}

	private static void processCoupons(int n) {
		
		// create the necessary stuff
		Random random = new Random();
		
		// this is used to count to the random no's we will need
		int randomCounter = 0;
		
		// this is a counter for generating n no of coupons
		int couponCount = 0;
		
		// we will use this variable to add elements to our Set
		int coupon = 0;
				
		// this will be used to store our unique coupons
		HashSet<Integer> coupons = new HashSet<>();
		
		//start generating random no's and add them until we have the desired no of coupons
		while(couponCount <=n)
		{
			coupon = random.nextInt(1001);
			
			// check if our newly generated coupon no is not present in the set			
			if(!(coupons.contains(coupon)))
					{
					 coupons.add(coupon);
					 couponCount++;
					}
					
			randomCounter++;
			
		}
		
		display(coupons, randomCounter);
	}

	// method to display our final output
	private static void display(HashSet<Integer> coupons, int randomCounter) {
		
		for (Integer coupon : coupons) {
			System.out.print(coupon+ " ");
		}
		
		System.out.println("");
		
		System.out.println("Total no of random nos needed to generate the coupons were "+randomCounter);
		
	}

}
