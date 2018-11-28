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
public class CircularlyLinkedListTest {

	private CircularlyLinkedList<String> actual = new CircularlyLinkedList<String>();
	/** Setup.
	 * @throws java.lang.Exception - For stuff
	 */
	@Before
	public void setUp() throws Exception {
		
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
		Assert.assertEquals(0, test.size());
	}

	/**	NOT FINISHED!!!
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		
		CircularlyLinkedList<String> test2 = new CircularlyLinkedList<String>();
		test2.add(0, "A");
		test2.add(1, "B");
		test2.add(2, "C");
		test2.add(1, "D");
		Assert.assertEquals("D", test2.get(1));
		test2.add(0, "F");
		Assert.assertEquals("F", test2.get(0));
		test2.add(4, "L");
		Assert.assertEquals("L", test2.get(4));
		
		
		CircularlyLinkedList<String> test3 = new CircularlyLinkedList<String>();
		test3.add(0, "A");
		Assert.assertEquals("A", test3.get(0));
		test3.add(1, "B");
		Assert.assertEquals("B", test3.get(1));
		test3.add(2, "*");
		Assert.assertEquals("*", test3.get(2));
		Assert.assertEquals(3, test3.size());

		test3.add(2, "P");
		Assert.assertEquals("P", test3.get(2));

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		Assert.assertEquals("A", actual.get(0));
		Assert.assertEquals("B", actual.get(1));
		Assert.assertEquals("C", actual.get(2));
		Assert.assertEquals("D", actual.get(3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, actual.isEmpty());
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
		test.add(0, "A");
		test.add(1, "B");
		test.add(2, "C");
		test.add(3, "D");
		Assert.assertEquals("C", test.remove(2));
		Assert.assertEquals("D", test.get(2));
		Assert.assertEquals("A", test.remove(0));
		Assert.assertEquals("B", test.get(0));
		Assert.assertEquals("D", test.remove(1));
		Assert.assertEquals("B", test.get(0));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
		CircularlyLinkedList<String> test = new CircularlyLinkedList<String>();
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
