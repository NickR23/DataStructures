/**
 * 
 */
package edu.ncsu.csc316.dsa.data;


import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/** GPAComparator test.
 * @author nicholasrrichardson
 *
 */
@SuppressWarnings("deprecation")
public class StudentGPAComparatorTest {
	private Student student1;
	private Student student2;
	private StudentGPAComparator comparator;
	/**SetUp method.
	 * @throws java.lang.Exception - for stuff
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("Bob", "Howard", 777);
		student1.setGpa(2.0);
		student2 = new Student("George", "Jordan", 757);
		student2.setGpa(3.0);
		
		comparator = new StudentGPAComparator();
	}

	/**
	 * Tests compare method.
	 */
	@Test
	public void testCompare() {
		int result = comparator.compare(student1, student2);
		Assert.assertEquals(-1, result);
		
		student1.setGpa(3.0);
		result = comparator.compare(student1, student2);
		Assert.assertEquals(0, result);
		
		student2.setGpa(2.0);
		result = comparator.compare(student1, student2);
		Assert.assertEquals(1, result);
	}

}
