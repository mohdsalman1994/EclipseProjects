package com.aceprogrammer.basics.HashFunction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Salman Shaikh
 */
public class HashFilePopulator {


	// the path where our feeder file is present
	private String filePath = "src/resources/hashFeed.txt";
	private File file = new File(filePath);

	HashMapManager hashMapManager = new HashMapManager();

	// intermediate holder for our nos
	String[] noArray;

	// our main game
	Map<Integer, List<Integer>> myHashMap = new TreeMap<Integer, List<Integer>>();

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * This app is just to populate our hash file which will
	 * be used by our MyHashMapDemo app.
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		HashFilePopulator hashPop = new HashFilePopulator();

		// read the txt file and store the no's into an array
		hashPop.read();

		// populate our map
		hashPop.populate();

	}

	/**
	 * @throws IOException
	 * This method read the txt file and store the no's into an array
	 */
	private void read() throws IOException {

		// populate our array from the file
		try(BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(file))))
		{
			String str = br.readLine();
			noArray = str.split(" ");			
		}

	}

	/**
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * populates the hashmap from the noArray
	 */
	private void populate() throws FileNotFoundException, ClassNotFoundException, IOException {

		// traverse our noArray and keep populating our Map
		for (String string : noArray) {

			int no = Integer.parseInt(string);

			hashMapManager.insert(no);

		}


	}


}

