package day19test;
import java.util.Scanner;



public class Driver {

	private int driverId;
	private String driverName;
	String driverPhone;
	boolean busAllocated=false;
	Scanner scanner;


 Driver() {
	 scanner = new Scanner(System.in);
	 }
 
 Driver(int driverId,String driverName,String driverPhone){
		scanner = new Scanner(System.in);
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverPhone = driverName;
		}
 
 public int getdriverId() {
		return driverId;
	}

	public void setdriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getdriverName() {
		return driverName;
	}

	public void setdriverName(String driverName) {
		this.driverName = driverName;
	}
	
	
	
 public boolean isBusAllocated() {
		return busAllocated;
	}

	public void setBusAllocated(boolean busAllocated) {
		this.busAllocated = busAllocated;
	}

void GetDriverDetailsFromUser() {
		System.out.println("Please enter the driver id");
		driverId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter the driver name");
		driverName = scanner.nextLine();
		System.out.println("Please enter the driver Phonenumber");
		driverPhone = scanner.nextLine(); 
			
	}
	
	  @Override public String toString() {
		  String option = "Driver is not allocated to any bus";
		  if(busAllocated == true)
			  option ="Driver is allocated to a bus";
		  return "Driver ID "+driverId+"\nDriver Name "+driverName+"\nPhone"+driverPhone+"\n"+option; 
		  }
	 

	@Override
    public boolean equals(Object obj) {
	Driver d2 = (Driver)obj;
	Driver d1 = this;
	if(d1.getdriverId()==d2.getdriverId())
	return true;
	else
	return false;
	}

}

