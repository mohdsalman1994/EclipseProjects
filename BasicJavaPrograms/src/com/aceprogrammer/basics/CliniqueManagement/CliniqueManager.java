package com.aceprogrammer.basics.CliniqueManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.*;



/**
 * @author Salman
 * This class manages a list of Patients, Doctors
 * and the appointments made by Patients
 *
 */
public class CliniqueManager {
		
	String appointmentFile = "src/resources/appointments.json";
	String patientsFile = "src/resources/patients.json";
	String doctorsFile = "src/resources/doctors.json";
	List<Patient> patientList;
	List<Doctor> doctorList;
	Map<Integer, Map<Integer, List<Integer>>> appointmentDetails;
	Gson gson;
	Predicate<Patient> pName;
	Predicate<Patient> pAge;
	Predicate<Doctor> dSpecialization;
	Predicate<Doctor> dId;

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
		Type appointmentType = new TypeToken<Map<Integer, Map<Integer, List<Integer>>>>(){}.getType();			
		appointmentDetails = gson.fromJson(appointmentFr, appointmentType);		
		}
			
	}
	
	
	/**
	 * displays all the patients present in the clinique
	 */
	public void displayPatients()
	{
		patientList.forEach(System.out::println);
						
	}
	
	
	/**
	 * displays all the doctors present in the clinique
	 */
	public void displayDoctors()
	{
		doctorList.forEach(System.out::println);
						
	}
	
	
    /**
     * 
     * saves the appointments to a file 
     * @throws IOException
     */
    public void saveAppointments() throws IOException
    {
    	    	        	    	
    	try (FileWriter appointmentWriter = new FileWriter(appointmentFile)) {

            gson.toJson(appointmentDetails, appointmentWriter);

        }
    }
	
	
    /**
     * displays the weeks report of doctor's appointments with patients
     * on each day
     */
    public void displayReport()
    {
    	System.out.printf("%2s %-15s PatientList \n","No", "Doctor");
    	for (Map.Entry<Integer, Map<Integer, List<Integer>>> outerEntry : appointmentDetails.entrySet()) {
			Integer i = outerEntry.getKey();
			
			Map<Integer, List<Integer>> docPatMap = outerEntry.getValue();
			for (Entry<Integer, List<Integer>> innerEntry : docPatMap.entrySet()) {
				Integer docId = innerEntry.getKey();
				String docName = null;
				
				
				// add stream concept here				
				for (Doctor doctor : doctorList) {
					if(doctor.getId() == docId)
					{
						docName = doctor.getName();
					}
				}
						
				// display day and doctor details
				System.out.printf("%2d %-15s ", i, docName);
				
				List<Integer> docPatients = innerEntry.getValue();
				for (Integer patientId : docPatients) {
					System.out.printf("%2d, ", patientId);
				}
				System.out.println();
			}
		}
    }
	
	
    /**
     * @param day i.e. day on which the appointment is to be made
     * @param pId i.e. patient id who is making the appointment
     * @param docId i.e. doctor id with whom the appointment is being booked
     * @return true if appointment is booked successfully false otherwise
     */
    public boolean makeAppointment(int day, int pId, int docId)
    {
    	// dig in the map to first find the doctor's 
    	Map<Integer, List<Integer>> docPatMap = appointmentDetails.get(day);    	
    	    	    	
    	List<Integer> dailyPatients = docPatMap.get(docId);

    	
    	if(dailyPatients == null)
    	{
    		dailyPatients = new ArrayList<>();
    	}
    	
    	// check if the doctors appointments are full for that day
    	if(dailyPatients.size() == 3)
    	{
    		System.out.println("Sorry, the appointments are full for this doctor");
    		return false;
    	}    	    	
    	
    	// now check if the patient has already booked an appointment for that day
    	// add filter streams to optimize this
    	for (Integer patientId : dailyPatients) {
			if(patientId == pId)
			{
				System.out.println("You have already booked an appointment");
				return false;
			}
		}
    	    	    	
    	// if these conditions fail then add the patient to the doctors appointment for that day
    	dailyPatients.add(pId);
		System.out.println("Appointment made successfully");
		System.out.println(dailyPatients);
		return true;					    	
    	    	
    }
		
	/**
	 * @param name i.e. Patient name
	 * displays all Patients whose name matches given String
	 */
	public void filterPatientByName(String name)
	{
		pName = (Patient p) -> p.getName().equals(name);
		patientList.stream().filter(pName).forEach(p -> System.out.println(p));
	}
	
	/**
	 * @param age i.e. Patient age
	 * displays all Patients whose age matches given integer
	 */
	public void filterPatientByAge(int age)
	{
		pName = (Patient p) -> p.getAge()== age;
		patientList.stream().filter(pName).forEach(p -> System.out.println(p));
	}
	
	/**
	 * @param specialization i.e. doctor's specialization
	 * filters Doctors by given specialization
	 */
	public void filterDoctorBySpecialization(String specialization)
	{
		dSpecialization = (Doctor d) -> d.getSpecialization().equals(specialization);
		doctorList.stream().filter(dSpecialization).forEach(d -> System.out.println(d));
	}
	
	
	/**
	 * @param dId i.e. doctor's id by which to be filtered
	 * filters the Doctor list by given doctor's id
	 */
	public void filterDoctorById(int dId)
	{
		doctorList.stream().filter(d -> d.getId() == dId).forEach(d -> System.out.println(d));
	}
	
	
	/**
	 * @param day i.e. any day within the working days
	 * displays the Doctors info for that given day
	 */
	public void showDailyDoctors(int day)
	{
		Map<Integer, List<Integer>> docPatMap = appointmentDetails.get(day);
		for(Map.Entry<Integer, List<Integer>> entry: docPatMap.entrySet())
		{
			int dId = entry.getKey();
			filterDoctorById(dId);
		}
	}
		
	
	public static void main(String[] args) throws IOException {
		CliniqueManager cManager = new CliniqueManager();
		//cManager.filterPatientByName("Satyendra");
		cManager.filterPatientByAge(25);
	}
}
