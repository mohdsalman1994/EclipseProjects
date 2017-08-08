package com.aceprogrammer.basics.InventoryManagerDemo;

/**
 * @author Salman Shaikh
 *
 */
public class InventoryManagerApp {

	/**
	 * @param args
	 * This app simulates an Inventory Management System.
	 */
	public static void main(String[] args) {
		System.out.println("This is a demo of inventory manager app");
		InventoryManager iManager = new InventoryManager();
		iManager.displayInventory();

	}

}
