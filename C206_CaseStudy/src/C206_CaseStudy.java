import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int QUIT = 6;
	private static final int MANAGE_PACKAGE = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Package> packageList = new ArrayList<Package>();

		int option = 0;
		while (option != QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Choose option> ");
			if (option == MANAGE_PACKAGE) {

			} else if (option == 2) {

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

	public static void addPackage(ArrayList<Package> packageList, Package p) {
		packageList.add(p);
		System.out.println("Package added!");
	}

	//Manage quotation (Done by Eu Kuang)
	public static String retreiveAllQuotation(ArrayList<Quotation> quotationList) {

		String output = "";

		for (int i = 0; i < quotationList.size(); i++) {

			output += String.format("%-10d %-30d %-10s %-10s %-20s %-20s %-20s %-20s %-20s \n", quotationList.get(i).getRequestID(), quotationList.get(i).getQuotationID(),
					quotationList.get(i).getCategory(), quotationList.get(i).getDescription(), quotationList.get(i).getName(),
					quotationList.get(i).getDate(),quotationList.get(i).getAmount());
		}

		return output;
	}

	public static void viewAllQuotation(ArrayList<Quotation> quotationList) {

		C206_CaseStudy.setHeader("Manage Quotation");

		String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s %-20s %-20s \n", "REQUEST ID", "QUOTATION ID", "CATEGORY",
				"DESCRIPTION", "NAME", "DATE", "AMOUNT");

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

		Quotation quote  = new Quotation(reqID,quotationID,category,description,name,date,amount);
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
