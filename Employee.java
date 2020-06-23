package day19test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Transport {

	int age,empid;
	String busid;
	String name,phone,dob;
	Scanner scanner;		
	Employee(){
		 scanner = new Scanner(System.in);
	}
	void assignBus(ArrayList<BusModel> busList) {
		System.out.println("Select the bus id from the list available");
		for(BusModel bObj:busList) {
			if(bObj.getFilledStatus()<bObj.getCapacity())
			System.out.println("Bus Number"+bObj.getBusNumber());
		}
		busid = scanner.nextLine();
		for(BusModel bObj:busList) {
			if(bObj.getBusNumber().equalsIgnoreCase(busid)) {
				bObj.setFilledStatus(bObj.getFilledStatus()+1);
			}
		}
		System.out.println("Bus "+busid+ " assigned");
	}
	private int ageCalculation(String dob) {
		// TODO Auto-generated method stub
		int age = 0;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate localDate = LocalDate.parse(dob, formatter);
	LocalDate now = LocalDate.now();
	Period diff = Period.between(localDate, now); 
	age = diff.getYears();
	return age;
		
	}
	
	void getemployeeDetails(ArrayList<BusModel> busList) {
		System.out.println("Please enter the employee id");
		empid = scanner.nextInt();
		scanner.nextLine();
		//System.out.println("Please enter the Bus id");
		//busid = scanner.nextInt();
		//scanner.nextLine();
		System.out.println("Please enter the employee name");
		name = scanner.nextLine();
		System.out.println("Please enter the employee phone");
		//System.out.println(maskString(phone, 0, 4, '*') );
		phone = scanner.nextLine();
		System.out.println("Please enter Date of Birth DD/MM/YYYY");
		dob= scanner.nextLine();
		age=ageCalculation(dob);

		
	assignBus(busList);
}
	
	
	
}
