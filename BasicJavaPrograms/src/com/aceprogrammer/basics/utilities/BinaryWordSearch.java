package com.aceprogrammer.basics.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Salman Shaikh
 *
 */
public class BinaryWordSearch {
	
	// the collection of words to be searched from
	private String[] words;
	
	// the path where the words file is located
	private String filePath = "src/resources/words.txt";

	
	/**
	 * This method sorts the collection of words
	 */
	public void sort() {
		
		Arrays.sort(words);		
		
	}


	/**
	 * @throws IOException in case there are errors while reading from the file
	 * This method reads the data from the given path
	 */
	public void readFile() throws IOException {
		
		//read the file and store it in a String array
				Path p = Paths.get(filePath);
				
				String content	= new	String(Files.readAllBytes(p));
				
				words = content.split("[ \\t\\n\\x0B\\f\\r]");							
		
	}

	
	/**
	 * @param word i.e. the word to be searched
	 * This method uses binary search to search the given
	 * word from our words collections
	 */
	public void searchAndDisplay(String word) {
		int i = Arrays.binarySearch(words, word);
		if(i >=0)
			System.out.println("Match found");
		else
			System.out.println("No Match Found");
		
	}


}
