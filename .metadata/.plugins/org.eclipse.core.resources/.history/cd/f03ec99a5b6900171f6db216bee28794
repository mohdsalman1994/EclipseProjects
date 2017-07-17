package com.aceprogrammer.basics.HashFunction;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashMapManager {

	    // our main game
		Map<Integer, List<Integer>> map;
		HashMapSerializer serializer = new HashMapSerializer();
	
	public void insert(int no) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		
		// add null check maybe?
		
		// first retrieve the map from serialized file
		
		
		// this is to handle empty file 
		try
		{
		map = serializer.deSerialize();		
		}
		catch (EOFException e) {
			System.out.println("File is empty");
			map = new TreeMap<Integer, List<Integer>>();
		}
		
		// calculate key and check if it already exists
					int key = no % 11;
					
					// if yes then directly push the no to it's corresponding list
					if(map.containsKey(key))
					{
						List<Integer> list = map.get(key);
						
						// add more logic here to check if the value already exists in there
						// if yes then pop it else push it
						
						if(list.contains(no))
						{
							System.out.println("Given no is already present in the Map");
							System.out.println("Popping it from the list");
							Integer boxer = no;
							list.remove(boxer);
							map.put(key, list);
						}
						
						else
						{				
							list.add(no);
							map.put(key, list);
						}
						
					}
					
					// this means that key is not present and hence we need to initialize the list and put it inside map
					else
					{
						List<Integer> list = new ArrayList<>();
						list.add(no);
						map.put(key, list);
					}
					
		// now that you have the required changes save this map in our serialized file
		serializer.serialize(map);
						
		
		}
	
	public Map<Integer, List<Integer>> getMap() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		return serializer.deSerialize();
	
	
	}	
}