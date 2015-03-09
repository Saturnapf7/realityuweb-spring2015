/**
 * 
 */
package testsJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import obj.Group;
import obj.Survey;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.CoordinatorDAO;
import dao.GroupsDAO;
import dao.SurveysDAO;

/**
 * @author Merdink
 *
 */
public class SurveyCheckTest {

	/**
	 * @throws java.lang.Exception
	 */
	//Adds the test student to the Group 1 roster
	@Before
	public void setUp() throws Exception {
		CoordinatorDAO cDao = new CoordinatorDAO();
		
		cDao.rosterinsert("Steve", "McBoss", "10/05/1999", 3.00d, 1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	//Removes the test student from the Group 1 roster
	@After
	public void tearDown() throws Exception {
		String sId = "";
		SurveysDAO sDao = new SurveysDAO();
		List<Survey> s1 = new ArrayList<Survey>();
		
		sId = sDao.findStudentID("Steve", "McBoss", "10/05/1999");
		s1 = sDao.search("id", sId);
		sDao.delete(s1.get(0));
	}

	/**
	 * Checks to see if the gender value exists and assumes survey has been
	 * <br>filled out if gender exists.
	 */
	
	@Test
	public void test() {
		String sId = "";
		String genderCheck = "";
		SurveysDAO sDao = new SurveysDAO();
		CoordinatorDAO cDao = new CoordinatorDAO();
		Survey s1 = new Survey();
		
		//Test data
		boolean winner = false;
		String fName = "Steve";
		String lName = "McBoss";
		String dateOfBirth = "10/05/1999";
		
		sId = sDao.findStudentID(fName, lName, dateOfBirth);
		s1 = sDao.find(Integer.parseInt(sId));
		s1.setGender("Male"); //Just updating gender for survey check
		sDao.update(s1);
		genderCheck = cDao.findinfo(sId);
		
		if (!genderCheck.equals("Male") && !genderCheck.equals("Female")) {
			System.out.println("Student has not filled out survey.");
		}
		else {
			winner = true;
			System.out.println("Student has already filled out survey.");
		}
		
		assertEquals(true, winner);
	}

}
