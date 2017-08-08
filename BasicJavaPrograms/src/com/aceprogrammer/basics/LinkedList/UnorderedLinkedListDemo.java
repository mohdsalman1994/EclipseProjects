package com.aceprogrammer.basics.LinkedList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.aceprogrammer.basics.utilities.UnorderedLinkedList;

public class UnorderedLinkedListDemo {

	// the filepath which will be used to fill our Linked List initially with some nos 
	private String filePath = "src/resources/uLinkedListFeeder.txt";
	
	UnorderedLinkedList unOrderedLinkedList;

	/**
	 * @param args
	 * @throws IOException
	 * This app is used to simulate an UnOrderedList
	 */
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
	
	// made these methods inside the app since our main method which is static cannot
	// access non static reference of our UnOrderedLinkedList.

	/**
	 * @throws IOException
	 * This method is used to populate our Unordered Linked List
	 * from the filepath
	 */
	private void populate() throws IOException {
		
		unOrderedLinkedList = new UnorderedLinkedList();
		
		WordReaderWriter wReader = new WordReaderWriter();
		
		List<String> wordList = wReader.getWordList(filePath);
		
		// System.out.println(wordList);
		
		for(String word: wordList)
		{
			unOrderedLinkedList.append(word);
		}
		
		unOrderedLinkedList.display();
	}
	
	/**
	 
	 * @param word
	 * This method tries to add a word to our linked list
	 */
	private void addToList(String word)
	{
		unOrderedLinkedList.insert(word);
	}
	
	/**
	 * This method displays our linked list
	 */
	private void display()
	{
		unOrderedLinkedList.display();
	}
	
	/**
	 * @throws IOException
	 * This method saves our list in the file located by filepath
	 */
	private void saveFileOnExit() throws IOException
	{
		WordReaderWriter writer = new WordReaderWriter();
		
		String[] words = unOrderedLinkedList.toWordArray();
		List<String> wordList = Arrays.asList(words);
		writer.writeWordList(wordList, filePath);
	}

}
