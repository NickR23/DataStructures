package edu.ncsu.csc316.dsa.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Test quickSort
 * @author nicholasrrichardson
 *
 */
public class QuickSorterTest {

	  private QuickSorter<String> sorter;
	  private String[] expected = {"A", "B", "C", "D", "E", "F", "N", "Z"};
	  private String[] actual = {"B", "A", "C", "D" , "N", "Z", "F", "E"};
		/**
		 * Setup.
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			sorter = new QuickSorter<String>(QuickSorter.MIDDLE_ELEMENT_SELECTOR);

		}
		/**
		 * Test MergeSort.
		 */
		@Test
		public void testQuickSort() {
			sorter.sort(actual);
			Assert.assertArrayEquals(expected, actual);
			
			sorter = new QuickSorter<String>(QuickSorter.FIRST_ELEMENT_SELECTOR);
			String[] actual1 = {"B", "A", "C", "D" , "N", "Z", "F", "E"};
			sorter.sort(actual1);
			Assert.assertArrayEquals(expected, actual1);

			sorter = new QuickSorter<String>(QuickSorter.LAST_ELEMENT_SELECTOR);
			String[] actual2 = {"B", "A", "C", "D" , "N", "Z", "F", "E"};
			sorter.sort(actual2);
			Assert.assertArrayEquals(expected, actual2);
			
			sorter = new QuickSorter<String>();
			String[] actual3 = {"B", "A", "C", "D" , "N", "Z", "F", "E"};
			sorter.sort(actual3);
			Assert.assertArrayEquals(expected, actual3);
		}

}
