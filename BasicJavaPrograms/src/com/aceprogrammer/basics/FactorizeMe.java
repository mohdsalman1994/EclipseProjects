package com.aceprogrammer.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class FactorizeMe {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Let's do some factorization magic");
		System.out.println("Enter a number");
		int n = Integer.parseInt(br.readLine());
		MyUtilities.factorize(n);

	}

}
