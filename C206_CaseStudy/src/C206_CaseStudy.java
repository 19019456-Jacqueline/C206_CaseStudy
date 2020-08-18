import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT = 6;
	private static final int MANAGE_PACKAGE = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> packageList = new ArrayList<Package>();
		ArrayList<userAccounts> userAccList = new ArrayList<userAccounts>();

		int option = 0;
		while (option != QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Choose option> ");
			if (option == MANAGE_PACKAGE) {

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

	// Manage package (Done by Jacqueline)
	public static Package inputPackage() {
		String pcode = Helper.readString("Enter package code> ");
		String description = Helper.readString("Enter package description> ");
		String startDate = Helper.readString("Enter package start date");
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

			output += String.format("%-10d %-30d %-10s %-10s %-20s %-20s %-20s %-20s %-20s \n",
					quotationList.get(i).getRequestID(), quotationList.get(i).getQuotationID(),
					quotationList.get(i).getCategory(), quotationList.get(i).getDescription(),
					quotationList.get(i).getName(), quotationList.get(i).getDate(), quotationList.get(i).getAmount());
		}

		return output;
	}

	public static void viewAllQuotation(ArrayList<Quotation> quotationList) {

		C206_CaseStudy.setHeader("Manage Quotation");

		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s %-20s \n", "REQUEST ID",
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

		int delete = Helper.readInt("Please enter a Quotation ID to delete: ");

		for (int i=0; i<quotationList.size(); i++) {
			if (quotationList.get(i).getQuotationID() == delete) {
				quotationList.remove(i);
				System.out.println("Quotation deleted!");
			}
		}
	}
}
