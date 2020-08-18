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

				// MANAGE CUSTOMERS
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
				}

			} else if (option == 3) {
				C206_CaseStudy.setHeader("MANAGE QUOTATION");
				System.out.println("1. View All Quotation");
				System.out.println("2. Add Quotation");
				System.out.println("3. Delete Quotation");

				int quotationOption = Helper.readInt("Enter an option > ");

				if (quotationOption == 1) {
					C206_CaseStudy.viewAllQuotation(quotationList);
				}

				else if (quotationOption == 2) {
					int reqID = Helper.readInt("Request ID: ");
					int quotationID = Helper.readInt("Quotation ID: ");
					String category = Helper.readString("Category: ");
					String description = Helper.readString("Description: ");
					String name = Helper.readString("Name of Designer: ");
					String date = Helper.readString("Start Date: ");
					double amount = Helper.readDouble("Quotation Amount: ");

					C206_CaseStudy.addQuotation(quotationList, inputQuotation(reqID, quotationID, category, description, name, date, amount));
				}

				else if (quotationOption == 3) {
					int delete = Helper.readInt("Enter Quotation ID To Delete: ");
					C206_CaseStudy.deleteQuotation(quotationList, delete);
				}

			} else if (option == 4) {

			} else if (option == 5) {

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

	// Manage quotation (Done by Eu Kuang)
	public static String retreiveAllQuotation(ArrayList<Quotation> quotationList) {

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

	public static void viewAllQuotation(ArrayList<Quotation> quotationList) {

		C206_CaseStudy.setHeader("Manage Quotation");

		String output = String.format("%-5s %-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "INDEX", "REQUEST ID",
				"QUOTATION ID", "CATEGORY", "DESCRIPTION", "NAME", "DATE", "AMOUNT");

		output += retreiveAllQuotation(quotationList);
		System.out.println(output);
	}

	public static Quotation inputQuotation() {

		int reqID = Helper.readInt("Request ID: ");
		int quotationID = Helper.readInt("Quotation ID: ");
		String category = Helper.readString("Category: ");
		String description = Helper.readString("Description: ");
		String name = Helper.readString("Name of Designer: ");
		String date = Helper.readString("Start Date: ");
		double amount = Helper.readDouble("Quotation Amount: ");

		Quotation quote = new Quotation(reqID, quotationID, category, description, name, date, amount);
		return quote;
	}

	public void addQuotation(ArrayList<Quotation> quotationList, Quotation quote) {
		quotationList.add(quote);
		System.out.println("Quotation added!");
	}

	public static void deleteQuotation(ArrayList<Quotation> quotationList) {

		int delete = Helper.readInt("Please enter Quotation ID to delete: ");

		for (int i = 0; i < quotationList.size(); i++) {
			if (quotationList.get(i).getQuotationID() == delete) {
				quotationList.remove(i);
				System.out.println("Quotation deleted!");
			}
		}
	}

	// Done by Jun Lim
	public void editRequest(ArrayList<Quotation> quotationList) {
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
}
