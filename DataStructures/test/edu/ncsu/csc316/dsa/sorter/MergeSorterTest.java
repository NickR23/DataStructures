/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/** Test for mergeSort.
 * @author nicholasrrichardson
 *
 */
public class MergeSorterTest {
	  private MergeSorter<String> sorter;
	  private String[] expected = {"A", "B", "C", "D", "E", "F", "N", "Z"};
	  private String[] actual = {"B", "A", "C", "D" , "N", "Z", "F", "E"};
		/**
		 * Setup.
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			sorter = new MergeSorter<String>();

		}
		/**
		 * Test MergeSort.
		 */
		@Test
		public void testMergeSort() {
			sorter.sort(actual);
			Assert.assertArrayEquals(expected, actual);
		}

}
