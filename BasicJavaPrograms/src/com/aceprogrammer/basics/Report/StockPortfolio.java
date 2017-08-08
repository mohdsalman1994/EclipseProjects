package com.aceprogrammer.basics.Report;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Shaikh
 *
 */
public class StockPortfolio {

	// collection of stocks
	private List<Stock> stockList;
	private String filePath = "src/resources/StockInfo.txt";
	 
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * Populates the collection of stock portfolio from the 
	 */
	public StockPortfolio() throws FileNotFoundException, IOException
	{
		stockList = new ArrayList<>();
		
		
		// check the system.getProperty(user.dir) in case of errors
		try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			
			// read each stock line by line and add them to the arraylist
			
			String line;
			while((line = br.readLine()) != null )
			{							
				Stock stock = readStock(line);
				stockList.add(stock);
			}
			
		}
	}
	
	/**
	 * @param line i.e. a line of text from the file
	 * @return Stock
	 * It formats the input string into a Stock type
	 * and returns it.
	 */
	public Stock readStock(String line)
	{
		String[] stock = line.split(", ");
		String name = stock[0];
		float price = Float.parseFloat(stock[1]);
		int quantity = Integer.parseInt(stock[2]);
		
		return new Stock(name, quantity, price);
	}
	
	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<Stock> getStockPortfolios()
	{		
			return stockList;
	}
	
	
}
