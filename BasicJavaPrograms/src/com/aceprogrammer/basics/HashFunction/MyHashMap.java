package com.aceprogrammer.basics.HashFunction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// this class will help in serialization and deserialization
public class MyHashMap implements Serializable {
	
	// the Map to store our data
	private TreeMap<Integer, List<Integer>> myHashMap;
	
	public MyHashMap(Map<Integer, List<Integer>> map)
	{
		myHashMap = (TreeMap<Integer, List<Integer>>) map;
	}

	public TreeMap<Integer, List<Integer>> getMyHashMap() {
		return myHashMap;
	}
	
	

}
