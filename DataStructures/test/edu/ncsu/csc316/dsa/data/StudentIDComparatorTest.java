package edu.ncsu.csc316.dsa.data;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
/**
 * StudentIDComparator test.
 * @author nicholasrrichardson
 *
 */
@SuppressWarnings("deprecation")
public class StudentIDComparatorTest {
	
	private Student student1;
	private Student student2;
	private StudentIDComparator comparator;
	/**
	 * Setup...
	 * @throws Exception - For stuff.
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("Bob", "Howard", 252);
		student2 = new Student("George", "Jordan", 757);
		
		comparator = new StudentIDComparator();
	}

	/**
	 * Test compare().
	 */
	@Test
	public void testCompare() {
		int result = comparator.compare(student1, student2);
		Assert.assertEquals(-1, result);
		
		student1.setId(757);
		result = comparator.compare(student1, student2);
		Assert.assertEquals(0, result);
		
		student2.setId(300);
		result = comparator.compare(student1, student2);
		Assert.assertEquals(1, result);
	}

}
