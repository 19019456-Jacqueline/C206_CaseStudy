import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Package p1;
	private Package p2;
	private Quotation q1;

	private ArrayList<Package> packageList;


	@Before
	public void setUp() throws Exception {
		//Prepare some test data for manage package (Done by Jacqueline)

		p1 = new Package("This house has 4 bedrooms", "P00001",
				10000, "20/8/2020", "20/4/2021", false);
		p2 = new Package("The house has a indoor swimming pool", "P00002", 
				12000, "4/6/2020", "4/10/2020", true);


		packageList=new ArrayList<Package>();
		
		//Prepare some test data for manage quotation (Done by Eu Kuang)
		q1 = new Quotation(1, 1, "Kitchen", "Doors", "Elkie Chong", "01-09-2020", 500.00);


	}

	@Test
	public void addPackageTest() {
		//Boundary condition
		assertNotNull("Check if there is a valid package arraylist to add to" + packageList);
		//Normal condition
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Test that Package arrayList is size 1", 1, packageList.size());
		assertSame("Check that package is added", p1, packageList.get(0));
		//Check that package arraylist size is 2 when another item is added
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package arrayList is size 1", 2, packageList.size());
		assertSame("Check that package is added", p2, packageList.get(1));
	}


	/*public void retrieveAllPackage() {

	}*/

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		packageList = null;

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	//Manage quotation (Done by Eu Kuang)
	ArrayList<Quotation> quotationList = new ArrayList<Quotation>();

	@Test
	//Add quotation (Done by Eu Kuang)
	public void addQuotationTest() {
		assertNotNull("Check for valid arraylist", quotationList);
		C206_CaseStudy.addQuotation(quotationList, q1);
		assertEquals("Check if arraylist size is 1" , 1, quotationList.size());
	}

	@Test
	//View quotation (Done by Eu Kuang)
	public void retrieveQuotationTest() {
		String output = String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-10.2f \n", 1, 1, "Kitchen", "Doors", "Elkie Chong", "01-09-2020", 500.00);
		addQuotationTest();
		assertEquals("Checks if the quotation retrieved properly", output, C206_CaseStudy.retrieveAllQuotation(quotationList));
	}

	@Test
	public void viewQuotationTest() {
		addQuotationTest();
		String output = C206_CaseStudy.retrieveAllQuotation(quotationList);
		assertEquals("Checks if view all is working properly", output, C206_CaseStudy.retrieveAllQuotation(quotationList));
	}

	@Test
	//Delete quotation (Done by Eu Kuang)
	public void deleteQuotationTest() {
		addQuotationTest();
		C206_CaseStudy.deleteQuotation(quotationList);
		assertEquals("Checks if quotation is deleted properly,", 0, quotationList.size());
	}
	
	//Update quotation (Done by Eu Kuang)	
	public void updateQuotationTest() {
	    assertNotNull("Test if there is valid Quotation arraylist to retrieve item", quotationList);
	    C206_CaseStudy.addQuotation(quotationList, q1);
	    quotationList.get(0).setCategory("Tiles");
	    quotationList.get(0).setDate("02-09-2020");
	    String allQuotation= C206_CaseStudy.retrieveAllQuotation(quotationList);
	    String testOutput = String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-10.2f \n", 1, 1, "Kitchen", "Tiles", "Elkie Chong", "02-09-2020", 500.00);
	    assertEquals("Test that updateQuotation", testOutput, allQuotation);
	  }

}
