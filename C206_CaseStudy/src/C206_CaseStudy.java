import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> packageList = new ArrayList<Package>();
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		ArrayList<userAccounts> userAccList = new ArrayList<userAccounts>();

		int option = 0;
		while (option != QUIT) {
			menu();
			option = Helper.readInt("Choose option> ");
			if (option == 1) {

				inputType();

				if (option == 1) {

					// MANAGE PACKAGE MENU (Done by Jacqueline)
					int packageOption = Helper.readInt("Enter option> ");
					if (packageOption == 1) {

						Package p = inputPackage();

						C206_CaseStudy.addPackage(packageList, p);

					} else if (option == 2) {
						// C206_CaseStudy.viewAllPackages(packageList);
					}

					addPackage(packageList, p);

				} else if (packageOption == 2) {
					viewAllPackages(packageList);
				}

			} else if (option == 2) {

				// MANAGE CUSTOMERS MENU (Done by Skye)
				C206_CaseStudy.setHeader("MANAGE CUSTOMERS");
				System.out.println("1. Add User Accounts");
				System.out.println("2. View all users");
				System.out.println("3. Delete users");

				int userOptions = Helper.readInt("Enter option> ");

				if (userOptions == 1) {
					userAccounts ua = inputUserAccounts();
					C206_CaseStudy.addUserAccounts(userAccList, ua);
				} else if (userOptions == 2) {
					C206_CaseStudy.viewUserAccounts(userAccList);
				} else if (userOptions == 3) {
					C206_CaseStudy.deleteUserAccounts(userAccList);
				}

			} else if (option == 3) {
				
				// MANAGE QUOTATION MENU (Done by Eu Kuang)
				C206_CaseStudy.setHeader("MANAGE QUOTATION");
				System.out.println("1. View All Quotation");
				System.out.println("2. Add Quotation");
				System.out.println("3. Delete Quotation");
				System.out.println("4. Search Quotation");
				System.out.println("5. Update Quotation");

				int quotationOption = Helper.readInt("Enter an option > ");

				if (quotationOption == 1) {
					C206_CaseStudy.viewAllQuotation(quotationList);
				} else if (quotationOption == 2) {
					Quotation q = inputQuotation();
					C206_CaseStudy.addQuotation(quotationList, q);
				} else if (quotationOption == 3) {
					C206_CaseStudy.deleteQuotation(quotationList);
				} else if (quotationOption == 4) {
					C206_CaseStudy.searchQuotation(quotationList);
				} else if (quotationOption == 5) {
					C206_CaseStudy.updateQuotation(quotationList);
				} else {
					System.out.println("Invalid Option!");
				}

			} else if (option == 4) {
				//request for quotation (Jun Lim)
				editRequest(quotationList);
				//deleteRequest == deleteQuotation as when deleting the quotation it removes the entire block so the request ends up removed as well
			} else if (option == 5) {
				// MANAGE APPOINTMENT (Done by Vi Ron)
				public static void appointmentMenu() {
					System.out.println();
					System.out.println("1. View all Appointments");
					System.out.println("2. Book an appointment");
					System.out.println("3. Update an appointment");
					System.out.println("4. Quit");
				}

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
		System.out.println("1. Add package");
		System.out.println("2. View all packages");
		System.out.println("3. Delete package");
		System.out.println("4. Search for package");
		System.out.println("5. Update package");
		System.out.println("6. Delete package based on start date");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Manage package (Done by Jacqueline)
	// Add packages
	public static Package inputPackage() {
		String pcode = Helper.readString("Enter package code> ");
		String description = Helper.readString("Enter package description> ");
		String startDate = Helper.readString("Enter package start date> ");
		String endDate = Helper.readString("Enter package end date> ");
		double packageAmount = Helper.readDouble("Enter package amount> ");
		boolean availablePackage = Helper.readBoolean("Is the package available? > ");

		Package p = new Package(pcode, description, packageAmount, startDate, endDate, availablePackage);
		return p;
	}

	public static void addPackage(ArrayList<Package> packageList, Package p) {
		packageList.add(p);
		System.out.println("Package added!");
	}

	// View packages
	public static String retrieveAllPackages(ArrayList<Package> packageList) {
		String output = "";
		// write your code here
		for (int i = 0; i < packageList.size(); i++) {
			output += String.format("%-10s %-10s %-10s %-10s %-10s\n", packageList.get(i).getpCode(),
					packageList.get(i).getDescription(), packageList.get(i).getStartDate(),
					packageList.get(i).getEndDate(), packageList.get(i).isAvailable() == true);

		}
		return output;
	}

	public static void viewAllPackages(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("VIEW ALL PACKAGES");
		String output = String.format("%-10s %-15s %-10s %-10s %-10s %-10s\n", "CODE", "DESCRIPTION", "AMOUNT",
				"START DATE", "END DATE", "AVAILABILITY");
		output += retrieveAllPackages(packageList);
		System.out.println(output);
	}

	// View packages
	/*
	 * public static String retrieveAllPackages(ArrayList<Package> packageList) {
	 * String output = ""; // write your code here for (int i = 0; i <
	 * packageList.size(); i++) { output +=
	 * String.format("%-20s %-10s %-10s %-10s %-10s\n",
	 * packageList.get(i).getpCode(), packageList.get(i).getDescription(),
	 * packageList.get(i).getStartDate(), packageList.get(i).getEndDate(),
	 * packageList.get(i).isAvailable() == true);
	 * 
	 * } return output; }
	 * 
	 * 
	 * public static void viewAllPackages(ArrayList<Package> packageList) {
	 * C206_CaseStudy.setHeader("VIEW ALL PACKAGES"); String output =
	 * String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "PACKAGE CODE",
	 * "DESCRIPTION", "PACKAGE AMOUNT", "PACKAGE START DATE", "PACKAGE END DATE",
	 * "AVAILABILITY"); output += retrieveAllPackages(packageList);
	 * System.out.println(output); }
	 */

	public static void deletePackage() {

	}

	// Manage users (Skye)
	// ========== Option 1 Add User Accounts =============
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

	// ======= Option 2 View all users ==============
	public static String retrieveAllUsers(ArrayList<userAccounts> userAccList) {
		String output = "";

		for (int i = 0; i < userAccList.size(); i++) {
			output += String.format("%-10s %-20s %-10s %-10s %-20s\n", userAccList.get(i).getName(),
					userAccList.get(i).getRole(), userAccList.get(i).getEmail(), userAccList.get(i).getPassword(),
					userAccList.get(i).getStatus());
		}
		return output;
	}

	public static void viewUserAccounts(ArrayList<userAccounts> userAccList) {
		C206_CaseStudy.setHeader("User Accounts");
		String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "NAME", "ROLE", "EMAIL", "PASSWORD", "STATUS");
		output += retrieveAllUsers(userAccList);
		System.out.println(output);
	}
	//======= Option 3 Delete User Accounts =======
	public static void deleteUserAccounts(ArrayList<userAccounts> userAccList) {

		String delete = Helper.readString("Please enter username to delete> ");

		for (int i = 0; i < userAccList.size(); i++) {
			if (userAccList.get(i).getName() == delete) {
				userAccList.remove(i);
				System.out.println("User Account deleted");
			}
		}
	}

	// Manage quotation (Done by Eu Kuang)
	public static String retrieveAllQuotation(ArrayList<Quotation> quotationList) {

		String output = "";

		for (int i = 0; i < quotationList.size(); i++) {
			// add while loop done by Jun Lim
			// while (quotationList.get(i).getQuotationID() != 0) {
			output += String.format("%-5d %-10d %-30d %-10s %-10s %-20s %-20s %-20.2f \n", quotationList.get(i),
					quotationList.get(i).getReqID(), quotationList.get(i).getQuotationID(),
					quotationList.get(i).getCategory(), quotationList.get(i).getDescription(),
					quotationList.get(i).getName(), quotationList.get(i).getDate(), quotationList.get(i).getAmount());
			// }
		}

		return output;
	}
	
	//View quotation (Done by Eu Kuang) 
	public static void viewAllQuotation(ArrayList<Quotation> quotationList) {

		C206_CaseStudy.setHeader("Manage Quotation");

		String output = String.format("%-5s %-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "INDEX", "REQUEST ID",
				"QUOTATION ID", "CATEGORY", "DESCRIPTION", "NAME", "DATE", "AMOUNT");

		output += retrieveAllQuotation(quotationList);
		System.out.println(output);
	}

	//Add quotation (Done by Eu Kuang)
	public static Quotation inputQuotation() {

		int reqID = Helper.readInt("Request ID: ");
		int quotationID = Helper.readInt("Quotation ID: ");
		String category = Helper.readString("Category: ");
		String description = Helper.readString("Description: ");
		String name = Helper.readString("Name of Designer: ");
		String date = Helper.readString("Start Date (dd-mm-yyy): ");
		double amount = Helper.readDouble("Quotation Amount: ");

		Quotation quote = new Quotation(reqID, quotationID, category, description, name, date, amount);
		return quote;
	}

	public static void addQuotation(ArrayList<Quotation> quotationList, Quotation quote) {
		quotationList.add(quote);
		System.out.println("Quotation added!");
	}

	//Delete quotation (Done by Eu Kuang)
	public static void deleteQuotation(ArrayList<Quotation> quotationList) {

		int delete = Helper.readInt("Please enter Quotation ID to delete: ");

		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationList.get(i).getQuotationID() == delete) {
				quotationList.remove(i);
				System.out.println("Quotation deleted!");
			} else {
				System.out.println("Invalid Quotation ID!");
			}
		}
	}
	
	//Search quotation (Done by Eu Kuang)
	public static void searchQuotation(ArrayList<Quotation> quotationList) {

		int search = Helper.readInt("Please enter Quotation ID to search: ");

		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationList.get(i).getQuotationID() == search) {
				System.out.println("Designer name: " + quotationList.get(i).getName());
				System.out.println("Total cost range: " + quotationList.get(i).getAmount());
				System.out.println("Start renovation date (MM-dd-yyy): " + quotationList.get(i).getDate());
				System.out.println("Renovation type: " + quotationList.get(i).getCategory());
			} else {
				System.out.println("Invalid Quotation ID!");
			}
		}
	}
	
	//Update quotation (Done by Eu Kuang)
	public static void updateQuotation(ArrayList<Quotation> quotationList) {

		int update = Helper.readInt("Please enter Quotation ID to update: ");

		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationList.get(i).getQuotationID() == update) {
				String updateCategory = Helper.readString("Enter the new renovation category: ");
				String updateDate = Helper.readString("Enter the new earliest start date (dd-mm-yyy): ");
				quotationList.get(i).setCategory(updateCategory);
				quotationList.get(i).setDate(updateDate);
				System.out.println("Quotation updated!");
			} else {
				System.out.println("Invalid Quotation ID!");
			}
		}
	}
	

	// Done by Jun Lim
	public static void editRequest(ArrayList<Quotation> quotationList) {
		C206_CaseStudy.viewAllQuotation(quotationList);
		int index = Helper.readInt("Which request index do you wish to edit? > ");
		int editElement = Helper.readInt("Which element do you wish to edit? > ");
		System.out.println("1. Quotation ID\n 2. Category\n 3. Description\n 4. Name\n 5. Date\n 6. Amount");
		if (editElement == 1) {
			int qID = Helper.readInt("New QuotationID: ");
			quotationList.get(index - 1).setQuotationID(qID);
		} else if (editElement == 2) {
			String cat = Helper.readString("New Category: ");
			quotationList.get(index - 1).setCategory(cat);
		} else if (editElement == 3) {
			String desc = Helper.readString("New Description: ");
			quotationList.get(index - 1).setDescription(desc);
		} else if (editElement == 4) {
			String name = Helper.readString("New Name: ");
			quotationList.get(index - 1).setName(name);
		} else if (editElement == 5) {
			String date = Helper.readString("New Date: ");
			quotationList.get(index - 1).setDate(date);
		} else if (editElement == 6) {
			double amt = Helper.readDouble("New Amount: ");
			quotationList.get(index - 1).setAmount(amt);
		}
	}
	
	// Manage Appointment (Done by Vi Ron)
	//================================= Option 1 View =================================
		public static String retrieveAllAppointments(ArrayList<Appointment> AppointmentList) {
			String output = "";

			for (int i = 0; i <  AppointmentList.size(); i++) {
				output += String.format("%-20s\n",  AppointmentList.get(i).toString());

			}
			return output;
		}
		
		public static void viewAllAppointments(ArrayList<Appointment> AppointmentList) {
			C206_CaseStudy.setHeader("APPOINTMENT LIST");

			String output = String.format("%-10s %-30s %-10s\n", "CUST_NAME", "CUST_ID", "APPOINTMENT_DATE");
			output += retrieveAllAppointments(AppointmentList);

			System.out.println(output);
			
		}
		
		//================================= Option 2 Add =================================
		public static Appointment inputAppointment() {
			String custName = Helper.readString("Enter customer name > ");
			int custID = Helper.readInt("Enter id > ");
			String input = Helper.readString("Time of meeting (dd/MM/yy hh:mm) > ");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
			LocalDateTime date_format = LocalDateTime.parse(input, formatter1);
			Appointment a = new Appointment(custName, custID, date_format);
			return a;
			
		}
		public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment cc) {
			
			appointmentList.add(cc);
			System.out.println("Appointment added");
		}
}
