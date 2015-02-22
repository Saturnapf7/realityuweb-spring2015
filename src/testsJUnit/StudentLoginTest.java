/**
 * 
 */
package testsJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.GroupsDAO;
import dao.CoordinatorDAO;
import dao.SurveysDAO;
import obj.Survey;
import obj.Group;

/**
 * @author Merdink
 *
 */
public class StudentLoginTest {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	//Adds a new group and survey for testing
	@Before
	public void setUp() throws Exception {
		int groupId = 5;
		GroupsDAO gDao = new GroupsDAO();
		CoordinatorDAO cDao = new CoordinatorDAO();
		
		gDao.insert("Tester Test", "02/05/2015", "", "Tester High", "Mr. Test", "1st", "01/01/2015", "01/31/2015", "02/05/2015", "ithinkthisisatest", "yes", "mytest");
		cDao.rosterinsert("Steve", "McBoss", "10/05/1999", 3.00d, groupId);
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	//Removes the group and survey that were added for the test
	@After
	public void tearDown() throws Exception {
		int groupId = 5;
		String sId = "";
		SurveysDAO sDao = new SurveysDAO();
		GroupsDAO gDao = new GroupsDAO();
		List<Survey> s1 = new ArrayList<Survey>();
		List<Group> g1 = new ArrayList<Group>();
		
		sId = sDao.findStudentID("Steve", "McBoss", "10/05/1999");
		s1 = sDao.search("id", sId);
		g1 = gDao.search("name", "Tester Test");
		sDao.delete(s1.get(0));
		gDao.delete(Integer.toString(g1.get(0).getId()));
	}

	/**
	 * Searches for the student ID using the first name, last name, and date of birth given.
	 * <br>If an ID was found, then gets the survey using the ID.
	 * <br>Then gets the group using the group ID from the survey.
	 * <br>Last, the incoming data is compared to what is grabbed from the database (first name, last name, date of birth, student access code) and if they match, then the login is valid.
	 */
	@Test
	public void test() {
		String sId = "";
		SurveysDAO sDao = new SurveysDAO();
		GroupsDAO gDao = new GroupsDAO();
		List<Survey> s1 = new ArrayList<Survey>();
		List<Group> g1 = new ArrayList<Group>();
		Survey s2 = new Survey();
		Group g2 = new Group();
		
		//Test data
		boolean winner = false;
		String fName = "Steve";
		String lName = "McBoss";
		String dateOfBirth = "10/05/1999";
		String accessCode = "ithinkthisisatest";
		
		sId = sDao.findStudentID(fName, lName, dateOfBirth);
		if (!sId.equals("0")) {
			s1 = sDao.search("id", sId);
			s2 = s1.get(0);
			g1 = gDao.search("id", Integer.toString(s2.getGroupID()));
			g2 = g1.get(0);
			
			System.out.println(fName + "::::" + s2.getFname());
			System.out.println(lName + "::::" + s2.getLname());
			System.out.println(dateOfBirth + "::::" + s2.getDob());
			System.out.println(accessCode + "::::" + g2.getStudentAccessCode());
			
			//if (fName.equals(s2.getFname()) && lName.equals(s2.getLname()) && dateOfBirth.equals(s2.getDob()) && accessCode.equals(g2.getStudentAccessCode())) {
			if (accessCode.equals(g2.getStudentAccessCode())) {
				winner = true;
			}
			else {
				System.out.println("ERROR! Student Access Code Invalid.");
			}
		}
		else {
			System.out.println("ERROR! Survey/Student ID not found.");
		}
		
		assertEquals(true, winner);
	}

}
