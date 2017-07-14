package com.aceprogrammer.basics.HashFunction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyHashMapDemo {
	
	HashMapManager hashMapManager = new HashMapManager();
	Map<Integer, List<Integer>> map;

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		System.out.println("Get ready for some #Map #Fun");
		
		String choice = "y";
		int option;
		
		MyHashMapDemo demoApp = new MyHashMapDemo();
		
		try(Scanner sc = new Scanner(System.in))
		{
		// keep the program running until user wants to quit
		while(choice.equalsIgnoreCase("y"))
		{
		System.out.println("Please enter your choice");
		System.out.println("1.Search/Insert no");
		System.out.println("2.Display HashMap");
		
		option = sc.nextInt();
		
		switch (option) 
		{
		case 1:System.out.println("Enter the value to be inserted");
			   int i = sc.nextInt();
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			   demoApp.insert(i);			
			break;
			
		case 2:demoApp.display();
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			break;
		
		default: System.out.println("Incorrect input. Please enter a correct input.");
		
		}
		
		}
				
		
		}
	}
	
	private void insert(int i) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		hashMapManager.insert(i);
		
	}
	
	private void display() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		// retrieve the map
		map = hashMapManager.getMap();
		
		
		// format the output
		for (Entry<Integer, List<Integer>> entry: map.entrySet())
		{
			System.out.printf("Slot %d: ", entry.getKey());
			List<Integer> list = entry.getValue();
			for(Integer i: list)
			{
				System.out.printf("%d ",i);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}