/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;

/**CountingSorterTest.
 * @author nicholasrrichardson
 *
 */
public class CountingSorterTest {
	  private Student student1;
	  private Student student2;
	  private Student student3;
	  private Student student4;
	  private Student[] expected;
	  private Student[] actual;
	  private CountingSorter<Student> sorter;
	  
	/**Setup.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("A", "A", 19);
		student2 = new Student("D", "D", 59);
		student3 = new Student("C", "C", 90);
		student4 = new Student("B", "B", 40);
		sorter = new CountingSorter<Student>();
		expected = new Student[4];
		actual = new Student[4];
		expected[0] = student1;
		expected[1] = student4;
		expected[2] = student2;
		expected[3] = student3;
		actual[0] = student1;
		actual[1] = student2;
		actual[2] = student3;
		actual[3] = student4;
	}
	
	/**
	 * CountingSort test.
	 */
	@Test
	public void testCountingSort() {
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
//		student2.setId(3);
//		expected[0] = student1;
//		expected[1] = student4;
//		expected[2] = student2;
//		expected[3] = student3;
//		sorter.sort(actual);
//		Assert.assertArrayEquals(expected, actual);
	}

}
