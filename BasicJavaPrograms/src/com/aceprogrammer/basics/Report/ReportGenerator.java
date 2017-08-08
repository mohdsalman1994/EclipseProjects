package com.aceprogrammer.basics.Report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Salman Shaikh
 *
 */
public class ReportGenerator {
	
	// variable to hold the collection of Stocks
	private StockPortfolio sp;
	
	public ReportGenerator() throws FileNotFoundException, IOException {
		
		sp = new StockPortfolio();
	}
	

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * This app is used to generate Stock Report.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		ReportGenerator rg = new ReportGenerator();
		rg.displayMenu();
				
		
		// read the user's choice
		rg.executeReport();
			

	}
	
	
	
	/**
	 * starts the report generation
	 */
	private void executeReport() {
		
		
		// variable to store user's choice
		int i;
		
		try(Scanner sc = new Scanner(System.in);)
		{
		 i = sc.nextInt();
		}
		if(i == sp.getStockList().size() + 1)
		{
			generateTotalReport();
		}
		else
			generateIndividualReport(i);
		
	}


	/**
	 * @param no i.e. the option/ type of report to be generated
	 * This method generates a report for a single company.
	 */
	public void generateIndividualReport(int no)
	{
		Stock stock = sp.getStockPortfolios().get(no - 1);
		
		String name = stock.getName();
		float value = stock.calculateValue();
		float price = stock.getPrice();
		int quantity = stock.getQuantity();
		
		System.out.printf("%s \t %-15s \t %-15s \t %-15s \t %s\n", "No", "Name","Stock Price", "No. of Stocks", "Value(Rs)");
		
		System.out.printf("%d  \t %-15s \t %-15f \t %-15d \t %f\n", 1 , name , price, quantity, value);
	}
	
	/**
	 * This method generates reports listing
	 */
	public void generateTotalReport()
	{
		List<Stock> stockList = sp.getStockPortfolios();		
		
		float total = 0;
		int index = 1;
		System.out.printf("%s \t %-15s \t %-15s \t %-15s \t %s\n", "No", "Name","Stock Price", "No. of Stocks", "Value(Rs)");
		
		// first generate each company's data one by one and keep adding each's value
		for (Stock stock : stockList) {
			
			String name = stock.getName();
			float value = stock.calculateValue();
			float price = stock.getPrice();
			int quantity = stock.getQuantity();
			System.out.printf("%d  \t %-15s \t %-15f \t %-15d \t %f\n", 1 , name , price, quantity, value);
			total = total + value;
			index++;
		}
		
		System.out.printf("%d  \t %-15s \t %f\n", index, "Total" , total);
	}
	
	/**
	 * Display different choices for the user to select the type of report to be generated.
	 */
	public void displayMenu()
	{
		System.out.println("Stock Report Generator");
		
		List<Stock> stockList = sp.getStockPortfolios();
		System.out.println("Choose the Company whose report you want to display");
		
		int index = 1;
		for (Stock stock : stockList) {
			System.out.printf("%d  %s \n", index, stock.getName());
			index++;
		}
		System.out.printf("%d  All Companies \n",index);
		
		
	}

}
