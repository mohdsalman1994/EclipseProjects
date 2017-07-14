package com.aceprogrammer.basics.HashFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class HashMapSerializer{
	
	public String filePath = "src/resources/myHashMap.dat";
	
	// this mehtod serializes given map and stores it in a file
	public void serialize(Map<Integer, List<Integer>> map) throws FileNotFoundException, IOException
	{
		MyHashMap myHashMap = new MyHashMap(map);
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath)))
		{
			out.writeObject(myHashMap);
		}
	}
	
	
	public Map<Integer, List<Integer>> deSerialize() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath)))
		{
//			@SuppressWarnings("unchecked")
//			Map<Integer, List<Integer>> myHashMap = (Map<Integer, List<Integer>>)in.readObject();
			MyHashMap myHashMap = (MyHashMap)in.readObject();
			Map<Integer, List<Integer>> map = myHashMap.getMyHashMap();
			return map;
		}
	}

}