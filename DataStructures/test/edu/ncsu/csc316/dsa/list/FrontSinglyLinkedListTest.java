/**
 * 
 */
package edu.ncsu.csc316.dsa.list;


import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** FrontSinglyLinkedList test.
 * @author nicholasrrichardson
 *
 */
public class FrontSinglyLinkedListTest {

	private String[] expected;
	private FrontSinglyLinkedList<String> actual = new FrontSinglyLinkedList<String>();
	/** Setup.
	 * @throws java.lang.Exception - For stuff
	 */
	@Before
	public void setUp() throws Exception {
		expected = new String[4];
		expected[0] = "A";
		expected[1] = "B";
		expected[2] = "C";
		expected[3] = "D";
		
		actual.add(0, "A");
		actual.add(1, "B");
		actual.add(2, "C");
		actual.add(3, "D");
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#FrontSinglyLinkedList()}.
	 */
	@Test
	public void testFrontSinglyLinkedList() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		Assert.assertEquals(0, test.size());
	}

	/**	NOT FINISHED!!!
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals(4, test.size());

		for (int i = 0; i < test.size(); i++)
		{
			Assert.assertEquals(expected[i], test.get(i));
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(1, "C");
		test.add(3, "D");
		test.addFirst("E");
		Assert.assertEquals("E", test.get(0));
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#addLast(java.lang.Object)}.
	 */
	@Test
	public void testAddLast() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(1, "C");
		test.add(3, "D");
		test.addLast("E");
		Assert.assertEquals("E", test.get(4));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#first()}.
	 */
	@Test
	public void testFirst() {
		Assert.assertEquals("A", actual.first());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#get(int)}.
	 */
	@Test
	public void testGet() {
		Assert.assertEquals("C", actual.get(2));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, actual.isEmpty());
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		Assert.assertEquals(true, test.isEmpty());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#last()}.
	 */
	@Test
	public void testlast() {
		Assert.assertEquals("D", actual.last());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals("C", test.remove(2));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals("A", test.removeFirst());
		Assert.assertEquals("B", test.first());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLast() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals("D", test.removeLast());
		Assert.assertEquals("C", test.last());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		test.set(1, "F");
		Assert.assertEquals("F", test.get(1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals(4, test.size());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#size()}.
	 */
	@Test
	public void testIterRemove() {
		FrontSinglyLinkedList<String> test = new FrontSinglyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Iterator<String> iter = test.iterator();
		iter.next();
		iter.remove();
		Assert.assertEquals("B", test.get(0));
	}

}
