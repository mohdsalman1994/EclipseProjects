package com.aceprogrammer.basics.BankCounter;

import java.util.Scanner;

public class BankCounterDemo {

	public static void main(String[] args) {
		
		int noOfCustomers = 3;
		int bankBalance = 10000;
		
		// initalize the bank with some balance and a predefined no of customers
		Bank bank = new Bank(noOfCustomers, bankBalance);
						
		// using common sense show each customer their balance first and then ask further details
		
		try(Scanner sc = new Scanner(System.in))
		{
		for(int i = 0; i < noOfCustomers; i++)
		{
			System.out.println("Your details");
			System.out.println(bank.getCustomerDetails(i));
			
			
			// we are assuming the user will select correct input for sake of simplicity of this app
			System.out.println("Enter the type of transaction");
			System.out.println("1.Deposit");
			System.out.println("2.Withdrawal");
			
			
				
				int type = sc.nextInt();
				TransactionType transType;
				
				// again assume that user enters only any 1 of these two options
				// you can add more stringent validation here
				if(type == 1)
				{
					transType = TransactionType.DEPOSIT;
				}
				else {
					transType = TransactionType.WITHDRAWAL;
				}
				
				
				System.out.println("Enter the amount");
				int amount = sc.nextInt();
				
				// add the transaction to the queue								
				bank.enqueue(i, transType, amount);
						
			}
																
		}
		
				
		// now take out the transactions from banks transaction queue
		// and keep performing transaction's until
		// the bank has 0 balance and it gets a withdrawal request
		// let the transactions return a boolean value
		// hence break out if unbalanced expression and say likewise
		// else check if loop is finished and say it is balanced
		boolean balanced = true;
		
		// this is needed to stop the for loop inside while loop if the expression is balanced
		// without this you will get noSuch elementException for balanced expression
		boolean incomplete = true;
		
		
		System.out.println("\n\n");
		
		int queueSize = bank.queueSize();		
		while(balanced && incomplete)
		{
			for(int i = 0; i < queueSize; i++)
			{
				balanced = bank.dequeue();
			}
			incomplete = false;
		}
		
		if(balanced)
		{
			System.out.println("The given expression is balanced");
		}
		else
		{
			System.out.println("The given expression is unbalanced");
		}

	}

}
