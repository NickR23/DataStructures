/**
 * 
 */
package edu.ncsu.csc316.dsa.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests Student class.
 * @author nicholasrrichardson
 *
 */
public class StudentTest {
	private Student testStudent;
	private Student newStudent;
	private Student compare1;
	private Student compare2;
	
	/**Resets arrays for each test instance.
	 * 
	 * @throws Exception for something...
	 */
	@Before
	public void setUp() throws Exception {
		testStudent = new Student("Nick", "Richardson", 12399);
		newStudent = new Student("Nick", "Richardson", 12399);
		compare1 = new Student("A", "B", 9090);
		compare2 = new Student("B", "C", 4090);
		
	}
	
	/**
	 * Tests constructor.
	 */
	@Test
	public void testConstructor(){
		Assert.assertEquals(testStudent, newStudent);
	}
	/**
	 * Tests getFirst().
	 */
	@Test
	public void testGetFirst(){
		Assert.assertEquals("Nick", newStudent.getFirst());
	}
	
	/**
	 * Tests setFirst().
	 */
	@Test
	public void testSetFirst(){
		newStudent.setFirst("William");
		Assert.assertEquals("William", newStudent.getFirst());
	}
	/**
	 * Tests getLast().
	 */
	@Test
	public void testGetLast(){
		Assert.assertEquals("Richardson", newStudent.getLast());
	}
	
	/**
	 * Tests setLast().
	 */
	@Test
	public void testSetLast(){
		newStudent.setLast("Faulkner");
		Assert.assertEquals("Faulkner", newStudent.getLast());
	}
	
	/**
	 * Tests getID().
	 */
	@Test
	public void testGetId(){
		Assert.assertEquals(12399, newStudent.getId());
	}
	
	/**
	 * Tests setId().
	 */
	@Test
	public void testSetId(){
		newStudent.setId(00001);
		Assert.assertEquals(00001, newStudent.getId());
	}
	
	/**
	 * Tests setCreditHours().
	 */
	@Test
	public void testSetCreditHours(){
		newStudent.setCreditHours(30);
		Assert.assertEquals(30, newStudent.getCreditHours());
	}
	/**
	 * Tests getCreditHours().
	 */
	@Test
	public void testGetCreditHours(){
		newStudent.setCreditHours(50);
		Assert.assertEquals(50, newStudent.getCreditHours());
	}
	
	/**
	 * Tests setGpa().
	 */
	@Test
	public void testSetGpa(){
		newStudent.setGpa(4.0);
		Assert.assertEquals(4.0, newStudent.getGpa(), 0.001);
	}
	
	/**
	 * Tests getGpa().
	 */
	@Test
	public void testGetGpa(){
		newStudent.setGpa(3.0);
		Assert.assertEquals(3.0, newStudent.getGpa(), 0.001);
	}
	
	/**
	 * Tests setUnityId().
	 */
	@Test
	public void testSetUnityId(){
		newStudent.setUnityID("Bbobbietest");
		Assert.assertEquals("Bbobbietest", newStudent.getUnityId());
	}
	
	/**
	 * Tests getUnityId().
	 */
	@Test
	public void testGetUnityId(){
		newStudent.setUnityID("AbcDleD01");
		Assert.assertEquals("AbcDleD01", newStudent.getUnityId());
	}
	
	/**
	 * Tests compareTo method.
	 */
	@Test
	public void testCompareTo() {
		int result = compare1.compareTo(compare2);
		Assert.assertEquals(-1, result);
		compare1.setFirst("D");
		compare1.setLast("E");
		result = compare1.compareTo(compare2);
		Assert.assertEquals(1, result);
		
		compare1.setFirst("D");
		compare1.setLast("C");
		result = compare1.compareTo(compare2);
		Assert.assertEquals(1, result);
		compare1.setId(4090);
		compare2.setId(4090);
		result = compare1.compareTo(compare2);
		Assert.assertEquals(0, result);
	}
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testToString() {
		Student s = new Student("Sam", "Ash", 19);
		Assert.assertEquals("Ash, Sam, 19", s.toString());
	}
}
