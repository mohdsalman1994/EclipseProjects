package com.aceprogrammer.basics.BankCounter;

import java.util.Queue;

public class Bank {

	// has some predefined customers
	// but to make this a simulation we will need the total cash of all these customers to be
	// greater than the initial bank balance
	Customer[] customers;
	
	
	int bankBalance;
	
	// has a queue of transactions
	Queue<Transaction> queue;
	
	public Bank(int noOfCustomers, int initialBalance)
	{
		customers = new Customer[noOfCustomers-1];
		bankBalance = initialBalance;
	
	}
	
}
