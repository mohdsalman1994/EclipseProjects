package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorizeMe {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Let's do some factorization magic");
		System.out.println("Enter a number");
		int n = Integer.parseInt(br.readLine());
		factorize(n);

	}
	
	// a function to print all prime factors
	public static void factorize(int n)
	{
		// first divide by 2 and print 2 until it is not divisible further by 2
		while(n%2 == 0)
		{
			System.out.print(2 + " ");
			n = n/2;
		}
		
		// now we know that n will be odd. Hence we can increment
		// by 2 for odd no's and keep going till i <= sqrt(n)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
				
			// print i until undivisible further 		
			while(n%i == 0)
			{
				System.out.print(i+" ");
				n = n/i;
			}
						
		}
		
		// This condition is to handle the case when n is
					// a prime no.
					// Take example of 88 and try solving to get this case
					if(n > 2)
					{
						System.out.println(n);
					}
		
	}

}