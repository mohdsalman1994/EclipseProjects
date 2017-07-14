package com.aceprogrammer.basics.LinkedList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordReaderWriter {
	
	private List<String> listOfWords;
	
	// maybe implement factory pattern

	
	public List<String> getWordList(String filePath) throws IOException
	{
		listOfWords = new ArrayList<>();
		Path path = Paths.get(filePath);
		
		// new magical api from java 7
		List<String> lines = Files.readAllLines(path);
		
		// process each line and add it to our listOfWords
		for(String line: lines)
		{
			String[] words = line.split(" ");
			listOfWords.addAll(Arrays.asList(words));
		}
		
		return listOfWords;
		
	}
	
	public void writeWordList(List<String> wordList, String filePath) throws IOException
	{
		// magic of Java 7 Files
		
		Path path = Paths.get(filePath);
		Files.write(path, wordList);
	}
	
	public List<Integer> getIntegerList(String filePath)throws IOException 
	{
		List<Integer> intList = new ArrayList<>();
		try(Scanner sc = new Scanner(new File(filePath)))
		{
			while(sc.hasNext())
			{
				intList.add(sc.nextInt());
			}
		}
		
		return intList;
	}
	
	public void writeIntegerList(List<Integer> intList, String filePath)throws IOException
	{
	
		// for efficiency we wrap bufferedWriter
		try(PrintWriter out
				   = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));)
		{
			for(int i: intList)
			{
				out.print(i+" ");
			}
		}
	}
	
}
