package com.aceprogrammer.basics.CliniqueManagement;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Salman Shaikh
 *
 */
public class CliniqueDemoApp {
	
	/**
	 * @param args
	 * @throws IOException
	 * This app simulates a Clinique Management System
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("This is a an app to demonstrate Clinique Management");
		
		CliniqueManager cManager = new CliniqueManager();
		
		String choice = "n";
		
		int option;
		
		// keep asking user what to do until he wants to exit
		try(Scanner sc = new Scanner(System.in))
		{
		// keep the program running until user wants to quit
		do
		{
		System.out.println("Enter your User Type");
		System.out.println("1.Clinique Manager");
		System.out.println("2.Patient");
		
		option = sc.nextInt();
		
		outer:
		switch (option) 
		{
		case 1:System.out.println("What do you want to see");
			   System.out.println("1.Doctor List");
			   System.out.println("2.Patient List");
			   System.out.println("3.Appointments for the week");
			   int no = sc.nextInt();
			   
			   inner:
			switch (no) {
			case 1:System.out.println("How do you want to filter the list?");
			System.out.println("1.By Specialization");
			System.out.println("2.No filter");
			int dFilter = sc.nextInt();
			
			deeper:
			switch (dFilter) {
			case 1:System.out.println("Enter the specialization");
			String specialization = sc.next();
			cManager.filterDoctorBySpecialization(specialization);
				
				break deeper;
			case 2:cManager.displayDoctors();
				break deeper;

			default:System.out.println("Incorrect input.");
				break deeper;
			}							
			break inner;
				
			case 2:System.out.println("How do you want to filter the Patients?");
			System.out.println("1.By name");
			System.out.println("2.By age");
			System.out.println("3.No filter");
			int pFilter = sc.nextInt();
			
			deeper:
			switch (pFilter) {
			case 1:System.out.println("Enter name");
			String pName = sc.next();
			cManager.filterPatientByName(pName);				
				break deeper;
			
			case 2:System.out.println("Enter age");
			int pAge = sc.nextInt();
			cManager.filterPatientByAge(pAge);
				
				break deeper;
				
			case 3:cManager.displayPatients();
				
				break deeper;

			default:System.out.println("Incorrect Input");
				break deeper;
			}
			break inner;
			 
			case 3:cManager.displayReport();
			break inner;

			default: System.out.println("Incorrect option");
				break inner;
			}
			   
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			break outer;
			
			
		case 2:boolean booked = false;
		    while(!booked)
		    {
		    System.out.println("Enter your patientId");
			int pId = sc.nextInt();
			System.out.println("Enter the day to book appointment");
			int day = sc.nextInt();
			cManager.showDailyDoctors(day);
			System.out.println("Enter the doctor id");
			int docId = sc.nextInt();
			booked = cManager.makeAppointment(day, pId, docId);
		    }
			   System.out.println("Enter 'y' to continue or 'n' no exit");
			   choice = sc.next();
			break outer;
		
		default: System.out.println("Incorrect input. Please enter a correct input.");
		break outer;
		}
		
		}
		while(choice.equalsIgnoreCase("y"));		
		
		}
		
		//save the appointments in the file
		cManager.saveAppointments();
		
	}

}
