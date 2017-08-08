package com.aceprogrammer.basics;

import com.aceprogrammer.basics.utilities.MyUtilities;

/**
 * @author Salman Shaikh
 *
 */
public class RegexDemo {

	/**
	 * @param args
	 * This app demonstrates the power of regex
	 * by searching and replacing strings in a given Message String.
	 */
	public static void main(String[] args) {
		
		// the message to be edited
		String message = "Hello <<name>>. We have your fullName is <<full name>> in "
				+ "our system. Your contact no is 91-xxxxxxxxxx. Please let us know"
				+ "in case of any clarification. Thank you. Bridgelabs dd/mm/yyyy";
		
		
		// the data that will replace appropiate matches in the message
		String name = "Mohammed Salman";
		String fullName = "Mohammed Salman Shaikh";
		String mobile = "91-9818784512";
		String date = "12/07/2017";
				
		message = MyUtilities.searchAndReplace(message, "<<name>>", name);
		message = MyUtilities.searchAndReplace(message, "<<full name>>", fullName);
		message = MyUtilities.searchAndReplace(message, "91-xxxxxxxxx", mobile);
		message = MyUtilities.searchAndReplace(message, "dd/mm/yyyy", date);
		System.out.println(message);
						
		
	
	
	}

}
