package com.aceprogrammer.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

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
		
		Regex regex = new Regex();
		message = regex.searchAndReplace(message, "<<name>>", name);
		message = regex.searchAndReplace(message, "<<full name>>", fullName);
		message = regex.searchAndReplace(message, "91-xxxxxxxxx", mobile);
		message = regex.searchAndReplace(message, "dd/mm/yyyy", date);
		System.out.println(message);
						
		


	}
	
	public String searchAndReplace(String sourceString, String searchString,String replaceString)
	{
		Pattern pattern = Pattern.compile(searchString);
		Matcher matcher = pattern.matcher(sourceString);
		
		if(matcher.find())
		{
			return sourceString.replace(sourceString.substring(matcher.start(), matcher.end()), replaceString);
		}
		else
			return null;
	}

}
