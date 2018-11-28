/**
 * 
 */
package edu.ncsu.csc316.dsa.manager;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**StudentManager test.
 * @author nicholasrrichardson
 *
 */
public class StudentManagerTest {
	  private Student student1;
	  private Student student2;
	  private Student student3;
	  private Student student4;
	  private StudentManager manager;
	  private Student[] expectedRoster;
	  private Student[] actualRoster;
	  
	/**Resets arrays for each test instance.
	 * 
	 * @throws Exception for something...
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("A", "A", 19);
		student2 = new Student("D", "D", 12);
		student3 = new Student("C", "C", 20);
		student4 = new Student("B", "B", 30);
		//Sets it's roster...
		manager = new StudentManager("input/testRoster.CSV");
		expectedRoster = new Student[4];
		expectedRoster[0] = student1;
		expectedRoster[1] = student4;
		expectedRoster[2] = student3;
		expectedRoster[3] = student2;
	}
		
	/**
	 * test sort method...
	 */
	@Test
	public void testManagerSort() {
		//Sort it's roster...
		actualRoster = manager.sort();
		Assert.assertArrayEquals(expectedRoster, actualRoster);
	}

}
