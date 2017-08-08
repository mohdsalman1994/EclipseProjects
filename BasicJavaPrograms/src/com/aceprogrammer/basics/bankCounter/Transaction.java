package com.aceprogrammer.basics.bankCounter;

/**
 * @author Salman Shaikh
 *
 */
public class Transaction {
	
	private int customerId;
	
	private TransactionType transType;
	
	private int transAmount;

	/**
	 * @param customerId
	 * @param transType i.e. Deposit or Withdraw
	 * @param transAmount i.e. the amount to be deposited or withdrawed
	 */
	public Transaction(int customerId, TransactionType transType, int transAmount) {
		
		this.customerId = customerId;
		this.transType = transType;
		this.transAmount = transAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}

	public int getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}
	
	

}
