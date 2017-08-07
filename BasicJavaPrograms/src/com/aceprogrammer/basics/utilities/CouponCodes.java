package com.aceprogrammer.basics.utilities;

import java.util.HashSet;
import java.util.Random;

/**
 * @author Salman Shaikh
 *
 */
public class CouponCodes {


	// random no used to generate the coupon codes
	private Random random = new Random();

	// this is used to count to the random no's we will need
	private int randomCounter = 0;

	// this is a counter for generating n no of coupons
	private int couponCount = 0;

	// we will use this variable to add elements to our Set
	private int coupon = 0;

	// this will be used to store our unique coupons
	private HashSet<Integer> coupons = new HashSet<>();


	/**
	 * @param noOfCoupons i.e. total no of couponCodes to be generated
	 * This method generates unique coupon codes using random nos between 1 and 1001
	 */
	public void processCoupons(int noOfCoupons) {



		//start generating random no's and add them until we have the desired no of coupons
		while(couponCount <noOfCoupons)
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

	/**
	 * @param coupons the collection of unique coupon codes
	 * @param randomCounter i.e. attempts made to generate a random coupon code
	 * This method displays the collection of unique coupon codes generated by
	 * processCoupons method
	 */
	public void display(HashSet<Integer> coupons, int randomCounter) {

		for (Integer coupon : coupons) {
			System.out.print(coupon+ " ");
		}

		System.out.println("");

		System.out.println("Total no of random nos needed to generate the coupons were "+randomCounter);

	}

}