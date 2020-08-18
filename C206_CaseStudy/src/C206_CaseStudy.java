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

	
}
