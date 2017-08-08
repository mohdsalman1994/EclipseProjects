package com.aceprogrammer.basics.InventoryManagerDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManager {
	
	// collection of inventory items
	List<Item> inventoryList;
	
	// the path where the json file is stored
	String filePath = "src/resources/inventory.json";

	
	/**
	 * We read the inventory from the JSON file and
	 * populate our Inventory List.
	 */
	public InventoryManager()
	{
		
		// populate our inventory from JSON file
		try 
			(FileReader fr = new FileReader(new File("src/resources/inventory.json")))
			{
			
			inventoryList = new ArrayList<>();
			
			JSONParser jsonParser = new JSONParser();
			
			// read the whole file into a JSONObject
			JSONObject jsonObject = (JSONObject)jsonParser.parse(fr);
			
			JSONArray itemsList = (JSONArray)jsonObject.get("items");					
			
			
			// for each doesn't work strangely!
			for(int i = 0; i < itemsList.size(); i++)
			{
				JSONObject item = (JSONObject)itemsList.get(i);
				String name = (String)item.get("name");
				int weight = Integer.parseInt((String)item.get("weight"));
				int price = Integer.parseInt((String)item.get("price"));
				Item aItem = new Item(name, weight, price);
				inventoryList.add(aItem);				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	/**
	 * This method displays our inventory
	 */
	public void displayInventory()
	{
		System.out.printf("%-10s \t %-5s \t %-5s\n","Name", "weight", "price");
		for (Item item : inventoryList) {
			System.out.printf("%-10s \t %-10d \t %-5d\n",item.getName(), item.getWeight(), item.getPrice());			
		}
	}
	
}
