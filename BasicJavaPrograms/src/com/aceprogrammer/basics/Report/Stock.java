package com.aceprogrammer.basics.Report;

public class Stock {
	
	private String name;
	private int quantity;
	private float price;
	
	
	
	
	public Stock(String name, int quantity, float price) {		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public float calculateValue()
	{
		int quantity = getQuantity();
		float price = getPrice();
		
		float value = price * quantity;
		
		return value;
	}
	
	

}
