package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.Utilities.MyUtilities;

public class NoOfBinarySearchTrees {

	public static void main(String[] args) {
		
		System.out.println("This program tells you the no of \n"
				+"unique Binary Search Trees for given no of Nodes");
		
		System.out.println("Enter the no of nodes");
		
		double n;
		try(Scanner sc = new Scanner(System.in))
		{
		n = sc.nextDouble();
		}
		
		int result = (int)MyUtilities.noOfBinarySearchTrees(n);
		
		System.out.println("There can be "+result+" unique trees");
	}
}
