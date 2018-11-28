
package edu.ncsu.csc316.dsa.sorter;
import edu.ncsu.csc316.dsa.data.Student;
//import static org.junit.Assert.assertArrayEquals;
import edu.ncsu.csc316.dsa.sorter.InsertionSorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for InsertionSorter.
 * @author nicholasrrichardson
 *
 */
public class InsertionSorterTest {
  private Student student1;
  private Student student2;
  private Student student3;
  private Student student4;
  private InsertionSorter<Student> sorter;
  
	/**Resets arrays for each test instance.
	 * 
	 * @throws Exception for something...
	 */
	@Before
	public void setUp() throws Exception {
		student1 = new Student("A", "A", 19);
		student2 = new Student("D", "D", 1299);
		student3 = new Student("C", "C", 900);
		student4 = new Student("B", "B", 4090);
		sorter = new InsertionSorter<Student>();
	}
	
/**
 * Tests sort algorithm.
 */
  @Test
  public void testSort() {
    Student[] actualArray = {student1, student2, student3, student4};
	Student[] expectedArray = {student1, student4, student3, student2};
    System.out.println(actualArray[1]);
    sorter.sort(actualArray);
    Assert.assertArrayEquals(expectedArray, actualArray);
  }

}

