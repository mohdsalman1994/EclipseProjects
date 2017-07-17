package com.aceprogrammer.basics.BankCounter;

public class Customer {
	
	private int id;	
	private int savings;
	
	
	public Customer(int id, int savings) {
		super();
		this.id = id;
		this.savings = savings;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSavings() {
		return savings;
	}


	public void setSavings(int savings) {
		this.savings = savings;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", balance=" + savings + "]";
	}
	
	

}
