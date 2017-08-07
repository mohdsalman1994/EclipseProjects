package com.aceprogrammer.basics.utilities;

import java.util.Scanner;


/**
 * @author Salman
 * This is a 2D Array library
 * Currenty it supports only Integers and Double
 *
 */
public class ArrayReaderLibrary {

	// variable to store the type of Array
	private ArrayType arrayType;
	
	// no of rows and columns
	private int rows;
	private int cols;
	
	// the 2d arrays
	private int[][] integerArray;
	private double[][] doubleArray;


	
	/**
	 * @author Salman Shaikh
	 * inner class of type enum to hold the array type
	 *
	 */
	public enum ArrayType
	{
		INTEGER, DOUBLE;
	}

	// read the array type and no of rows and columns
	/**
	 * @param scanner Stream to read the data from user
	 * This method asks user for the required type of array,
	 */
	public void readInfo(Scanner scanner)
	{
		System.out.println("This is a library to read 2d arrays");
		System.out.println("Currently it supports Integer and Double types");		

		// variable to keep checking whether the user has entered correct input or not
		boolean correctInput = false;


		while(!correctInput)
		{
			System.out.println("Select any one of the following options");
			System.out.println("1. INTEGER");
			System.out.println("2. DOUBLE");
			int type = scanner.nextInt();

			switch(type)
			{

			case 1:arrayType = ArrayType.INTEGER;
			correctInput = true;

			// read the no of rows and columns
			readRowAndColumnDetails(scanner);

			break;

			case 2:arrayType = ArrayType.DOUBLE;
			correctInput = true;

			// read m and n
			readRowAndColumnDetails(scanner);

			break;


			default:System.out.println("Incorrect input! Try again");

			}

		}
	}


	// generic array creater method
	/**
	 * This method creates the required type of array
	 */
	public void createArray()
	{
		if(arrayType == ArrayType.INTEGER)
		{
			integerArray = new int[rows][cols];
			System.out.println("Integer Array Created");
		}
		else
			if(arrayType == ArrayType.DOUBLE)
			{
				doubleArray = new double[rows][cols];
				System.out.println("Double Array Created");
			}
	}

	/**
	 * @param scanner the stream to read the data from
	 * This method reads the data of the given array from the user
	 */
	public void readArray(Scanner scanner)
	{
		if(arrayType == ArrayType.INTEGER)
		{
			for (int i = 0; i < rows; i++) {
				System.out.printf("Data for %dth row : \n", i+1);
				for (int j = 0; j < cols; j++) {
					integerArray[i][j] = scanner.nextInt();
				}
			}
		}
		else

			if(arrayType == ArrayType.DOUBLE)
			{
				for (int i = 0; i < rows; i++) {
					System.out.printf("Data for row no %d: \n", i+1);
					for (int j = 0; j < cols; j++) {
						doubleArray[i][j] = scanner.nextInt();
					}
				}

			}
	}

	
	/**
	 * displays the complete array
	 */
	public void displayArray()
	{
		if(arrayType == ArrayType.INTEGER)
		{
			for (int i = 0; i < rows; i++) {				
				for (int j = 0; j < cols; j++) {
					System.out.printf("\t %d",integerArray[i][j]); 
				}
				System.out.println("");
			}
		}

		else
			if(arrayType == ArrayType.DOUBLE)
			{
				for (int i = 0; i < rows; i++) {				
					for (int j = 0; j < cols; j++) {
						System.out.printf("\t %f", doubleArray[i][j]); 
					}
					System.out.println("\n");
				}
			}
	}


	// utility method to read no of rows and column
	/**
	 * @param scanner the stream to read the data from
	 * reads the no of rows and columns from the user
	 */
	private void readRowAndColumnDetails(Scanner scanner)
	{
		System.out.println("Enter the no of rows");

		rows = scanner.nextInt();

		System.out.println("Enter the no of columns");

		cols = scanner.nextInt();
	}

}
