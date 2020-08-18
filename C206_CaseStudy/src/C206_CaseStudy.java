import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT = 6;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> packageList = new ArrayList<Package>();
		ArrayList<userAccounts> userAccList = new ArrayList<userAccounts>();
	
		int option = 0;
		while (option != QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Choose option> ");
			if (option == 1) {
				
			} else if (option == 2) {
				// MANAGE CUSTOMERS
				C206_CaseStudy.setHeader("MANAGE CUSTOMERS");
				System.out.println("1. Add User Accounts");
				System.out.println("2. View all users");
				System.out.println("3. Delete users");
				
				int userOptions = Helper.readInt("Enter option> ");
				
				if (userOptions == 1) {
					userAccounts ua = inputUserAccounts();
					C206_CaseStudy.addUserAccounts(userAccList, ua);
				}
				else if (userOptions == 2) {
					C206_CaseStudy.viewUserAccounts(userAccList);
				}
				
			} else if (option == 3) {
				
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
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//Manage package (Done by Jacqueline)
	public static Package inputPackage() {
		String pcode = Helper.readString("Enter package code> ");
		String description = Helper.readString("Enter package description> ");
		String startDate = Helper.readString("Enter package start date");
		String endDate = Helper.readString("Enter package end date> ");
		double packageAmount = Helper.readDouble("Enter package amount> ");
		boolean availablePackage = Helper.readBoolean("Is the package available? > ");
		
		Package p  = new Package(pcode, description,packageAmount, startDate, endDate, availablePackage);
		return p;
	}
	
	//Manage users (Skye)
	//========== Option 1 Add User Accounts =============
	public static userAccounts inputUserAccounts() {
		String uName = Helper.readString("Enter name> ");
		String uRole = Helper.readString("Enter role> ");
		String uEmail = Helper.readString("Enter email> ");
		String uPassword = Helper.readString("Enter password> ");
		String uStatus = Helper.readString("Enter status> ");
		
		userAccounts uAcc = new userAccounts(uName, uRole, uEmail, uPassword, uStatus);
		return uAcc;
	}
	public static void addUserAccounts(ArrayList<userAccounts> userAccList, userAccounts uAcc) {
	
		userAccList.add(uAcc);
		System.out.println("User Account added!");
	}
	
	//======= Option 2 View all users ==============
	public static String retrieveAllUsers(ArrayList<userAccounts> userAccList) {
		String output = "";
		
		for (int i = 0; i < userAccList.size(); i++) {
			output += String.format("%-10s %-20s %-10s %-10s %-20s\n", 
					userAccList.get(i).getName(),
					userAccList.get(i).getRole(), 
					userAccList.get(i).getEmail(),
					userAccList.get(i).getPassword(),
					userAccList.get(i).getStatus());
		}
		return output;
	}
	public static void viewUserAccounts(ArrayList<userAccounts> userAccList) {
		C206_CaseStudy.setHeader("User Accounts");
		String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "NAME", "ROLE",
				"EMAIL", "PASSWORD","STATUS");
		output += retrieveAllUsers(userAccList);	
		System.out.println(output);
	}
}
