import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT = 6;
	private static final int MANAGE_PACKAGE = 1;
	private static final int MANAGE_CUSTOMER = 2;
	private static final int MANAGE_QUOTATION = 3;
	private static final int MANAGE_REQUEST = 4;
	private static final int MANAGE_APPOINTMENT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> packageList = new ArrayList<Package>();
	
		int option = 0;
		while (option != QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Choose option> ");
			if (option == MANAGE_PACKAGE) {
				inputType();
				if (option == 1) {
					C206_CaseStudy.inputPackage();
					
				} else if (option == 2) {
					C206_CaseStudy.viewAllPackages(packageList);
				} 
				
				
				
			} else if (option == MANAGE_CUSTOMER) {
				
			} else if (option == MANAGE_QUOTATION) {
				
			} else if (option == MANAGE_REQUEST) {
				
			} else if (option == MANAGE_APPOINTMENT) {
				
			}
			
			
		}
		
		
		
		
		
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("WELCOME TO RENOVATION ACE");
		System.out.println("1. Manage Package");
		System.out.println("2. Manage Customer");
		System.out.println("3. Manage Quotation");
		System.out.println("4. Manage Request for Quotation");
		System.out.println("5. Manage Appointment");
		
	}
	
	private static void inputType() {
		System.out.println("INPUT TYPES");
		System.out.println("1. Add items");
		System.out.println("2. View items");
		System.out.println("3. Delete items");
	}
	
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//Manage package (Done by Jacqueline)
	public static Package inputPackage() {
		String pcode = Helper.readString("Enter package code> ");
		String description = Helper.readString("Enter package description> ");
		String startDate = Helper.readString("Enter package start date> ");
		String endDate = Helper.readString("Enter package end date> ");
		double packageAmount = Helper.readDouble("Enter package amount> ");
		boolean availablePackage = Helper.readBoolean("Is the package available? > ");
		
		Package p  = new Package(pcode, description,packageAmount, startDate, endDate, availablePackage);
		return p;
	}
	
	public static void addPackage(ArrayList<Package> packageList, Package p) {
		inputPackage();
		packageList.add(p);
		System.out.println("Package added!");
	}
	
	public static String retrieveAllPackages(ArrayList<Package> packageList) {
		String output = "";
		// write your code here
		for (int i = 0; i < packageList.size(); i++) {
			output += String.format("%-20s\n", packageList.get(i).toString());
		}
		return output;
	}
	
	
	public static void viewAllPackages(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("VIEW ALL PACKAGES");
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s", 
				"PACKAGE CODE", "DESCRIPTION", "PACKAGE AMOUNT", "PACKAGE START DATE", "PACKAGE END DATE", "AVAILABILITY");
		output += retrieveAllPackages(packageList);
		System.out.println(output);
	}
	
	
	
	
	
	
	
	
	
	

}
