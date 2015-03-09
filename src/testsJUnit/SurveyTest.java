package testsJUnit;

import static org.junit.Assert.*;
import obj.Survey;

import org.junit.Test;

public class SurveyTest {

	/**
	 * Test method for {@link obj.Survey()}.
	 */
	@Test
	public void testGroup2() {
		System.out.println("Test Survey constructor");
		String expResult = "0abc0.0e2ghij3n0opqrst0.01.1uv";
		Survey instance = new Survey(0, "a", "b", "c", 0.0, "e", 2, "g", "h", "i", "j", 3, "n", 0, "o", "p", "q", "r", "s", "t", 0.0, 1.1, "u", "v");
		String result = instance.getId() + instance.getFname() + instance.getLname() + instance.getDob() + instance.getGpa() +
				instance.getGender() + instance.getGroupID() + instance.getEducation() + instance.getPrefJob() + instance.getJob() +
				instance.getMarried() + instance.getSpouse() + instance.getChildren() + instance.getNumChild() +
				instance.getCCards() + instance.getCCardUses() + instance.getGroceries() + instance.getClothing() + instance.getHome() +
				instance.getVehicle() + instance.getChildSupport() + instance.getCreditScore() + instance.getSave() + instance.getEntertainment();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test method for {@link obj.Survey.getGpaCategory()}.
	 */
	//GPA Categories
	// 1 = under 1.5, 2 = 1.5 - 1.9 
	// 3 = 2.0 - 2.4,  4 = 2.5 - 2.9 
	// 5 = 3.0 - 3.4, 6 = 3.5 - 4.0 
	@Test
	public void testGpaCategory() {
		Survey s1 = new Survey();
		int gpaCat = 0;
		int expectedCat = 5;
		
		s1.setGpa(3.00d);
		gpaCat = s1.getGpaCategory();
		
		assertEquals(expectedCat, gpaCat);
	}

}
