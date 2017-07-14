package com.aceprogrammer.basics.LinkedList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UnorderedLinkedListDemo {
	
	String filePath = "src/resources/uLinkedListFeeder.txt";
	
	UnorderedLinkedList uList;

	public static void main(String[] args) throws IOException {
		
		UnorderedLinkedListDemo uDemo = new UnorderedLinkedListDemo();
				
		// populate the linkedList
		uDemo.populate();
		
		System.out.println("This is a demo of Unordered Linked List");
		
		String choice = "n";
		
		int option;
		
		// keep asking user what to do until he wants to exit
		try(Scanner sc = new Scanner(System.in))
		{
		// keep the program running until user wants to quit
		do
		{
		System.out.println("Please enter your choice");
		System.out.println("1.Search/Insert word");
		System.out.println("2.Display list of Words");
		
		option = sc.nextInt();
		
		switch (option) 
		{
		case 1:System.out.println("Enter the value to be inserted");
			   String word = sc.next();			   			   
			   uDemo.addToList(word);
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			break;
			
		case 2:uDemo.display();
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			break;
		
		default: System.out.println("Incorrect input. Please enter a correct input.");
		
		}
		
		}
		while(choice.equalsIgnoreCase("y"));		
		
		}
				 
				
		// save the list back
		uDemo.saveFileOnExit();

	}

	private void populate() throws IOException {
		
		uList = new UnorderedLinkedList();
		
		WordReaderWriter wReader = new WordReaderWriter();
		
		List<String> wordList = wReader.getWordList(filePath);
		
		// System.out.println(wordList);
		
		for(String word: wordList)
		{
			uList.append(word);
		}
		
		uList.display();
	}
	
	private void addToList(String word)
	{
		uList.insert(word);
	}
	
	private void display()
	{
		uList.display();
	}
	
	private void saveFileOnExit() throws IOException
	{
		WordReaderWriter writer = new WordReaderWriter();
		
		String[] words = uList.toWordArray();
		List<String> wordList = Arrays.asList(words);
		writer.writeWordList(wordList, filePath);
	}

}
