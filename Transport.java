package day19test;

import java.util.ArrayList;
import java.util.Scanner;

public class Transport {

	//Customer[] customers;
		ArrayList<Driver> drivers;
		ArrayList<BusModel> busmodels;
		ArrayList<Employee> employees;
		Scanner scanner;
		//int numberOfCustomers;
		
		Transport(){
			scanner = new Scanner(System.in);
			drivers = new ArrayList<Driver>();
			busmodels = new  ArrayList<BusModel>();
			employees = new ArrayList<Employee>();
		
		}
		public void addDriver() {
			Driver driver = new Driver();
			driver.GetDriverDetailsFromUser();
			drivers.add(driver);
			System.out.println("Driver added");
			}
		
		public void addBus() {
			BusModel busmodel = new BusModel();
			busmodel.GetBusDetailsFromUser(drivers);
			busmodels.add(busmodel);
			}
		
		public void addEmployee() {
			Employee employee = new Employee();
			employee.getemployeeDetails(busmodels);
			employees.add(employee);
			
			}
				
		public void populateDrivers() {
			String choice = "No";
			do {
				addDriver();
				System.out.println("Do you want to add another Driver?\n Enter Yes for next entry and No for quiting");
				choice = scanner.nextLine();
			} while (!choice.toLowerCase().equals("no"));
			
			System.out.println("--------------------");
		}
		public void populateBuses() {
			String choice = "No";
			do {
				addBus();
				System.out.println("Do you want to add another Bus? Enter Yes for next entry and No for quiting");
				choice = scanner.nextLine();
			} while (!choice.toLowerCase().equals("no"));
			
			System.out.println("--------------------");
		}
		public void populateEmployees() {
			String choice = "No";
			do {
				addEmployee();
				System.out.println("Do you want to add another Employee? Enter Yes for next entry and No for quiting");
				choice = scanner.nextLine();
			} while (!choice.toLowerCase().equals("no"));
			
			System.out.println("--------------------");
		}
		Driver findDriverIndex(int driverid)
		{
				for (Driver driver : drivers) {
				if (driver !=null)
					{
					if(driver.getdriverId()==driverid)
					{
					return driver;
					}
				
					}
				
					}
			return null;
		}
		
		public void compareDrivers() {
			int id1=0,id2=0;
			Driver d1,d2;
			System.out.println("Please enter the first driver id to be compared");
			id1 = scanner.nextInt();
			d1 = findDriverIndex(id1);
			if(d1==null)
			{
				System.out.println("No such driver please try again from start");
				compareDrivers();
			}
			System.out.println("Please enter the second driver id to be compared");
			id2 = scanner.nextInt();
			d2 = findDriverIndex(id2);
			if(d2==null)
			{
				System.out.println("No such driverid please try again from start");
				compareDrivers();
			}
			if(d1.equals(d2))
				System.out.println("The Drivers are just the same");
			else
				System.out.println("Not same");
			System.out.println("--------------------");
		}
		
		public void deleteDriver() {
			int id1=0;
			System.out.println("Please enter the driver id to be deleted");
			id1 = scanner.nextInt();
			Driver d1 = findDriverIndex(id1);
			if(d1==null)
			{
				System.out.println("No such driver");
				System.out.println("No driver deleted");
			}
			else	
			{
				System.out.println("The Driver to be deleted is ");
				System.out.println(d1);
				drivers.remove(d1);
				System.out.println("Driver deleted");
				System.out.println("--------------------");
			}
		}
		public void printDriver() {
			int id1=0;
			System.out.println("Please enter the driver id to be printed");
			id1 = scanner.nextInt();
			Driver d1 = findDriverIndex(id1);
			System.out.println("The selected driver details");
			if(d1==null)
			{
				System.out.println("No such driver");
			}
			else
				System.out.println(d1);
			System.out.println("--------------------");
		}
		
		public void printAllDriver() {
			for (Driver driver : drivers) {
				System.out.println(driver);
				System.out.println("--------------------");
			}
		}
		public void updateDriverDetails() {
			int id1=0;
		
			System.out.println("Please enter the driver id to be updated");
			id1 = scanner.nextInt();
			Driver d1 = findDriverIndex(id1);
			System.out.println("The driver details for updation");
			if(d1==null)
			{
				System.out.println("No such driver");
			}
			else
			{
				System.out.println(d1);
				System.out.println("--------------------");
				scanner.nextLine();
				System.out.println("Please enter the driver name for updation");
				String drivername = scanner.nextLine();
				d1.setdriverName(drivername);
				System.out.println("Update success");
				System.out.println("The updated details");
				System.out.println(d1);
				System.out.println("--------------------");
				
			}
		}
		void printDriverMenu() {
			int userChoice = 0;
			do {
				System.out.println("--------------------");
				System.out.println("1. Adding a new driver");
				System.out.println("2. Updating the driver details");
				System.out.println("3. Deleting a driver");
				System.out.println("4. Printing all the driver details");
				System.out.println("5. Printing the given driver detail");
				System.out.println("6. Compare drivers");
				System.out.println("7. Exit");
				System.out.println("--------------------");
				userChoice  = scanner.nextInt();
				switch (userChoice ) {
				case 1:
					
					populateDrivers();				
					break;
				case 2:
					updateDriverDetails();
					break;
				case 3:
					deleteDriver();
					break;
				case 4:
					printAllDriver();
					break;
				case 5:
					printDriver();
					break;
			
				case 6:
					compareDrivers();
					break;
				case 7:
					System.out.println("exit.....");
					break;
				default:
					System.out.println("Invalid Entry.. Try again");
					break;
				}
				
			} while (userChoice!=7);
			
		}
		
	public static void main(String[] args) {
		Transport tt = new Transport();
		try {
		tt.populateDrivers();
		tt.populateBuses();
		tt.populateEmployees();
		
		tt.printDriverMenu();	
		}catch(Exception e)
		{
			System.out.println("Error occured!!!");
		}

	}

}