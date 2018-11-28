/**
 * 
 */
package edu.ncsu.csc316.dsa.io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**StudentReader test.
 * @author nicholasrrichardson
 */
public class StudentReaderTest {
	  private Student student1;
	  private Student student2;
	  private Student student3;
	  private Student student4;
	  private Student[] expectedRoster;
	  private Student[] actualRoster;
	  
	/** set up...
	 * @throws java.lang.Exception for stuff.
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("A", "A", 19);
		student2 = new Student("D", "D", 12);
		student3 = new Student("C", "C", 20);
		student4 = new Student("B", "B", 30);
		//Sets it's roster...
		expectedRoster = new Student[4];
		expectedRoster[0] = student1;
		expectedRoster[1] = student2;
		expectedRoster[2] = student3;
		expectedRoster[3] = student4;
	}
	
	/**
	 * Tests readInput()...
	 */
	@Test
	public void testReadInput() {
		actualRoster = StudentReader.readInput("input/testRoster.CSV");
		Assert.assertArrayEquals(expectedRoster, actualRoster);
	}
	
	/**
	 * Tests failcase for file reading.
	 */
	@Test
	public void testFailedInput() {
		try
		{
			StudentReader.readInput("input/nonExistentFile.CSV");
		} catch(IllegalArgumentException e)
		{
			Assert.assertTrue(true);
		}
		
	}


}
