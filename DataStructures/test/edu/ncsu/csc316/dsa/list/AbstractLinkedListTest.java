package edu.ncsu.csc316.dsa.list;


import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * AbstractList tests.
 * @author nicholasrrichardson
 *
 */
public class AbstractLinkedListTest {
	/**
	 * Test AbstractElementIterator.
	 */
	@Test
	public void testIter() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Iterator<String> iter = test.iterator();
		Assert.assertEquals(true, iter.hasNext());
		int i = 0;
		while (iter.hasNext())
		{
			i++;
			iter.next();
		}
		Assert.assertEquals(4, i);
	}
	
	/**
	 * Test AbstractElementIterator.
	 */
	@Test
	public void testIterNext() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Iterator<String> iter = test.iterator();
		Assert.assertEquals("A", iter.next());
		Assert.assertEquals("B", iter.next());
		Assert.assertEquals("C", iter.next());
		Assert.assertEquals("D", iter.next());
	}

}
