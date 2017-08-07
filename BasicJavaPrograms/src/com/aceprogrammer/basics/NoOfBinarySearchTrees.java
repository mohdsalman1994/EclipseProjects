package com.aceprogrammer.basics;

import java.util.Scanner;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class NoOfBinarySearchTrees {

	/**
	 * @param args
	 * This app calculates the total no of
	 * unique binary search trees for a given no of nodes.
	 * It takes the no of nodes as input from the user
	 */
	public static void main(String[] args) {
		
		System.out.println("This program tells you the no of \n"
				+"unique Binary Search Trees for given no of Nodes");
		
		System.out.println("Enter the no of nodes");
		
		double nodes;
		try(Scanner scanner = new Scanner(System.in))
		{
		nodes = scanner.nextDouble();
		}
		
		int result = (int)MyUtilities.noOfBinarySearchTrees(nodes);
		
		System.out.println("There can be "+result+" unique trees");
	}
}
