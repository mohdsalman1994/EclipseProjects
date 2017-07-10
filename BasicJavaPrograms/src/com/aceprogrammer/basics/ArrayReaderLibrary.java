package com.aceprogrammer.basics;

import java.util.Scanner;

public class ArrayReaderLibrary {
	
	ArrayType arrayType;
	int rows;
	int cols;
	int[][] integerArray;
	double[][] doubleArray;
	
	
	public enum ArrayType
	{
		INTEGER, DOUBLE;
	}

	public static void main(String[] args) {
		
		ArrayReaderLibrary library = new ArrayReaderLibrary();
		
		
		try(Scanner s = new Scanner(System.in);)
		{
		library.readInfo(s);
		
		library.createArray();
		
		library.readArray(s);
		
		library.displayArray();
		}
		
		

	}
	
	// read the array type and no of rows and columns
	private void readInfo(Scanner sc)
	{
		System.out.println("This is a library to read 2d arrays");
		System.out.println("Currently it supports Integer and Double types");		
	    
	    	boolean correctInput = false;
	    	
	    	
	    	while(!correctInput)
	    	{
	    		System.out.println("Select any one of the following options");
	    	    System.out.println("1. INTEGER");
	    	    System.out.println("2. DOUBLE");
	    	    int type = sc.nextInt();
	    	    
	    	    switch(type)
	    	    {
	    	    	
	    	    case 1:arrayType = ArrayType.INTEGER;
	    	    	correctInput = true;
	    	    	
	    	    	// read m and n
	    	    	readRowAndColumnDetails(sc);
	    	    	
	    	    	break;
	    	    	
	    	    case 2:arrayType = ArrayType.DOUBLE;
	    	        correctInput = true;
	    	        
	    	        // read m and n
	    	        readRowAndColumnDetails(sc);
	    	        
	    	        break;
	    	    
	    	        
	    	     default:System.out.println("Incorrect input! Try again");
	    	     
	    	    }
	    	
	    }
	}
	
	
	// generic array creater method
	private void createArray()
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
	
	private void readArray(Scanner sc)
	{
		if(arrayType == ArrayType.INTEGER)
		{
			for (int i = 0; i < rows; i++) {
				System.out.printf("Data for %dth row : \n", i+1);
				for (int j = 0; j < cols; j++) {
					integerArray[i][j] = sc.nextInt();
				}
			}
		}
		else
		
		if(arrayType == ArrayType.DOUBLE)
		{
			for (int i = 0; i < rows; i++) {
				System.out.printf("Data for row no %d: \n", i+1);
				for (int j = 0; j < cols; j++) {
					doubleArray[i][j] = sc.nextInt();
				}
			}
			
		}
	}
	
	
	// display the contents of array
	private void displayArray()
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
	private void readRowAndColumnDetails(Scanner sc)
	{
		System.out.println("Enter the no of rows");
    	
    	rows = sc.nextInt();
    	
    	System.out.println("Enter the no of columns");
    	
    	cols = sc.nextInt();
	}

}