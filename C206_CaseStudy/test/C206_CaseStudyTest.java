import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Package p1;
	private Package p2;
	
	private ArrayList<Package> packageList;


	@Before
	public void setUp() throws Exception {
		//Prepare some test data
		
		p1 = new Package("This house has 4 bedrooms", "P00001",
				10000, "20/8/2020", "20/4/2021", false);
		p2 = new Package("The house has a indoor swimming pool", "P00002", 
				12000, "4/6/2020", "4/10/2020", true);
		
		
		packageList=new ArrayList<Package>();
		
		
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

}
