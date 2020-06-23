package day19test;

import java.util.ArrayList;
import java.util.Scanner;

public class BusModel extends Transport{

	String busNumber;
	int capacity;
	int filledStatus;
	String source;
	Driver obj =new Driver();
	Scanner scanner;
	BusModel(){
		 scanner = new Scanner(System.in);
	}
	
	
	 public int getFilledStatus() {
		return filledStatus;
	}


	public void setFilledStatus(int filledStatus) {
		this.filledStatus = filledStatus;
	}


	public int getCapacity() {
		return capacity;
	}


	public String getBusNumber() {
		return busNumber;
	}
void assignDriver(ArrayList<Driver> driversList) {
	  System.out.println("The available drivers are"); 
	  for (Driver dObj:driversList) {
		  if(dObj.isBusAllocated() == false) {
			  System.out.println(dObj.getdriverId()+" - "+dObj.getdriverName());
		  } 
	 }
	 System.out.println("Please choose your preferred driver id");
	 int driverId = scanner.nextInt(); 
	 scanner.nextLine();
	 for (Driver dObj:driversList) {
		 if(dObj.getdriverId()==driverId && dObj.isBusAllocated() == false) {
			 dObj.setBusAllocated(true);
			 System.out.println(dObj.getdriverName()+" is assigned to this bus");
		 }
	 }
}

	void GetBusDetailsFromUser(ArrayList<Driver> driversList)  {
			System.out.println("Please enter the bus number");
			busNumber = scanner.nextLine();
			System.out.println("Please enter the seating capacity");
			capacity = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please give the number of seats filled already");
			filledStatus = scanner.nextInt();
			scanner.nextLine();
		if(filledStatus < capacity) {
			System.out.println("Seats are Available");
		}
		else {
			System.out.println("Seats are not Available");
		}
		
		assignDriver(driversList);
		
	}
}
	 
