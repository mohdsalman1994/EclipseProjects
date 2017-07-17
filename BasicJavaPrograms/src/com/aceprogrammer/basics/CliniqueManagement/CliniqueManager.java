package com.aceprogrammer.basics.CliniqueManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.*;

public class CliniqueManager {
		
	String appointmentFile = "src/resources/appointments.json";
	String patientsFile = "src/resources/patients.json";
	String doctorsFile = "src/resources/doctors.json";
	List<Patient> patientList;
	List<Doctor> doctorList;
	Map<Integer, Map<Doctor, List<Patient>>> appointmentDetails;
	Gson gson;

	public CliniqueManager() throws IOException
	{
		try(FileReader patientFr = new FileReader(patientsFile);
		    FileReader doctorFr = new FileReader(doctorsFile);
			FileReader appointmentFr = new FileReader(appointmentFile);	)		
		{
		gson = new GsonBuilder().disableHtmlEscaping().create();
		
		// read patient data from JSON file
		Type patientType = new TypeToken<List<Patient>>(){}.getType();			
		patientList = gson.fromJson(patientFr, patientType);
		
		// read doctor data from JSON file
		Type doctorType = new TypeToken<List<Doctor>>(){}.getType();			
		doctorList = gson.fromJson(doctorFr, doctorType);
		
		// read appointment details from JSON file
		Type appointmentType = new TypeToken<Map<Integer, Map<Doctor, List<Patient>>>>(){}.getType();			
		appointmentDetails = gson.fromJson(appointmentFr, appointmentType);
		
		}
	}
	
	// display the list of patients
	public void displayPatients()
	{
		patientList.forEach(System.out::println);
						
	}
	
	// display list of doctors
	public void displayDoctors()
	{
		doctorList.forEach(System.out::println);
						
	}
	
    public void writeAppointments() throws IOException
    {
    	appointmentDetails = new TreeMap<Integer, Map<Doctor,List<Patient>>>();
    	
    	List<Patient> pList = new ArrayList<>();
    	pList.add(patientList.get(0));
    	for(int i=1; i < 6; i++)
    	{
    		Map<Doctor,List<Patient>> docPatMap = new HashMap<>();
    		for (Doctor doctor : doctorList) {    			
    			docPatMap.put(doctor, pList);				
			}
    		appointmentDetails.put(i, docPatMap);
    	}
    	    	        	
    	
    	try (FileWriter appointmentWriter = new FileWriter(appointmentFile)) {

            gson.toJson(appointmentDetails, appointmentWriter);

        }
    }
	
	// display doctor-patient report
    public void displayReport()
    {
    	for (Map.Entry<Integer, Map<Doctor, List<Patient>>> outerEntry : appointmentDetails.entrySet()) {
			Integer i = outerEntry.getKey();
			
			Map<Doctor, List<Patient>> docPatMap = outerEntry.getValue();
			for (Map.Entry<Doctor, List<Patient>> innerEntry : docPatMap.entrySet()) {
				Doctor doctor = innerEntry.getKey();
				String docName = doctor.getName();
				
				// display day and doctor details
				System.out.printf("%2d %15s ", i, docName);
				
				List<Patient> docPatients = innerEntry.getValue();
				for (Patient patient : docPatients) {
					System.out.printf("%2d, ", patient.getId());
				}
				System.out.println();
			}
		}
    }
	
	// make appointments
    public boolean makeAppointment(int day, int pId, int docId)
    {
    	// dig in the map to first find the doctor's 
    	Map<Doctor, List<Patient>> docPatMap = appointmentDetails.get(day);    	
    	
    	List<Patient> dailyPatients = null;
    	// add filters later to optimize this
    	for (Doctor doctor : doctorList) {
			if(doctor.getId() == pId)
			{
				dailyPatients = docPatMap.get(doctor);
				break;
			}
		}
    	
    	if(dailyPatients == null)
    	{
    		dailyPatients = new ArrayList<>();
    	}
    	
    	// check if the doctors appointments are full for that day
    	if(dailyPatients.size() >=3)
    	{
    		System.out.println("Sorry, the appointments are full for this doctor");
    		return false;
    	}    	    	
    	
    	// now check if the patient has already booked an appointment for that day
    	// add filter streams to optimize this
    	for (Patient patient : dailyPatients) {
			if(patient.getId() == pId)
			{
				System.out.println("You have already booked an appointment");
				return false;
			}
		}
    	    	    	
    	// if these conditions fail then add the patient to the doctors appointment for that day
    	for (Patient patient : patientList) {
			if(patient.getId() == pId)
			{
				patientList.add(patient);
				System.out.println("Appointment made successfully");
				return true;
			}
		}
    	
    	System.out.println("None of the above conditions match");
    	return false;
    	    	
    }
	
	public static void main(String[] args) throws IOException {
		CliniqueManager cMan = new CliniqueManager();
		cMan.displayPatients();
		cMan.displayDoctors();
	//	cMan.displayReport();
	}
	
}