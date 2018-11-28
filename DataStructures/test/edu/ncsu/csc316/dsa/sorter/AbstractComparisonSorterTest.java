package edu.ncsu.csc316.dsa.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
/**
 * Test for AbstractComparisonSorter as well as NaturalOrder.
 * NaturalOrder is an inner class in AbstractionComparisonSorter.
 * @author nicholasrrichardson
 *
 */
public class AbstractComparisonSorterTest {

		private BubbleSorter<Student> bs;
		private Student s1;
		private Student s2;
/**
 * Setup operations.
 * @throws Exception
 */
	@Before
	public void setUp() throws Exception {
		bs = new BubbleSorter<Student>();
		s1 = new Student("John" , "Doe" , 199);
		s2 = new Student("Bob" , "Wallen" , 200);
	}

	/**
	 * Test method for NaturalOrder.compare().
	 */
	@Test
	public void testCompare() {
		int result = bs.compare(s1, s2);
		Assert.assertEquals(-1, result);

	}

}
