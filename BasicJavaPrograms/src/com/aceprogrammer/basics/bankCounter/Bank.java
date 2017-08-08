package com.aceprogrammer.basics.bankCounter;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author Salman Shaikh
 *
 */
/**
 * @author Salman Shaikh
 *
 */
/**
 * @author Salman Shaikh
 *
 */
/**
 * @author Salman Shaikh
 *
 */
public class Bank {

	// has some predefined customers
	// but to make this a simulation we will need the total cash of all these customers to be
	// greater than the initial bank balance

	// list of customers
	private Customer[] customers;

	// used to initialize a random balance for all the customers
	private Random random;

	// our Bank's balance
	private int bankBalance;

	// has a queue of transactions
	Queue<Transaction> queue;

	/**
	 * @param noOfCustomers i.e. total no of customers in the queue
	 * @param initialBalance i.e. initial bank balance 
	 */
	public Bank(int noOfCustomers, int initialBalance)
	{

		customers = new Customer[noOfCustomers];
		bankBalance = initialBalance;
		queue = new ArrayDeque<>();

		// initialize balance of customers randomly ranging between 1000 and 10000
		random = new Random();
		for (int i = 0; i < customers.length; i++) {
			int randomNo = random.nextInt(10 - 1) + 1;
			customers[i] = new Customer(i, randomNo * 1000);
		}


	}
	
	/**
	 * @param id i.e. Customer id of the customer who wants to deposit
	 * @param amount i.e. the amount to be deposited
	 * This methods adds the amount to the customer's account
	 * with the given id.
	 */
	public void deposit(int id, int amount)
	{
		System.out.println("Before: "+customers[id]);
		bankBalance += amount;
		int savings = customers[id].getSavings() + amount;
		customers[id].setSavings(savings);
		System.out.println(customers[id]);
		System.out.println("Current Bank Balance: "+bankBalance);

	}

	
	/**
	 * @param id i.e. Customer id of the customer who wants to withdraw
	 * @param amount i.e. the amount to be withdrawed
	 * @return whether the withdrawal was succesful or not
	 * This amount reduces the customers balance by the given amount.
	 */
	public boolean withdrawal(int id, int amount)
	{
		// first check whether the bank has sufficient balance
		if(bankBalance < amount)
		{
			System.out.println("Insufficient Cash in bank");
			return false;

		}


		// now check whether the customer has sufficient balance
		// this condition is just added for fun
		// but we will assume that the user will not enter such amount
		// since you are going to show the customer his current balance
		int savings = customers[id].getSavings();
		if(savings < amount)
		{
			System.out.println("Sorry you don't have sufficient balance");
			return false;
		}

		// update bankBalance and customerSaving

		System.out.println("Before: "+customers[id]);
		bankBalance -= amount;

		savings -= amount;
		customers[id].setSavings(savings);		
		System.out.println("After: "+customers[id]);
		System.out.println("Current Bank Balance: "+bankBalance);

		return true;
	}

	// add transaction to the queue
	/**
	 * @param customerId i.e. Customer id of the customer to be added to the queue
	 * @param transType i.e. Deposit or Withdraw
	 * @param transAmount i.e. transaction amount
	 * This method adds a given customer's transaction to the queue.
	 */
	public void enqueue(int customerId, TransactionType transType, int transAmount)
	{
		Transaction transaction = new Transaction(customerId, transType, transAmount);
		queue.add(transaction);
		System.out.println("Transaction added to the queue");
	}


	
	/**
	 * @return whether the last element in the queue was processed successfully or not
	 * This method removes an element from the queue and processes it.
	 */
	public boolean dequeue() {

		Transaction transaction = queue.remove();

		int id = transaction.getCustomerId();
		int transAmount = transaction.getTransAmount();

		// check the transaction type and perform the transaction Type
		if(transaction.getTransType() == TransactionType.DEPOSIT)
		{
			deposit(id, transAmount);
			return true;
		}
		else
		{
			return withdrawal(id, transAmount);
		}

	}

	
	/**
	 * @return the queue size
	 */
	public int queueSize()
	{
		return queue.size();
	}

	
	/**
	 * @param id i.e. a Customer's id
	 * @return the Customer's details for the given Customer Id.
	 */
	public String getCustomerDetails(int id)
	{
		return customers[id].toString();
	}
}
