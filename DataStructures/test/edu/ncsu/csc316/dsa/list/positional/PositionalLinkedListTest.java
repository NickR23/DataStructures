/**
 * 
 */
package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;


/** PositionalLinkedList test cases.
 * @author nicholasrrichardson
 *
 */
public class PositionalLinkedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#PositionalLinkedList()}.
	 */
	@Test
	public void testPositionalLinkedList() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		Assert.assertEquals(0, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#iterator()}.
	 */
	@Test
	public void testIterator() {
		String[] expected = {"A", "B", "C", "D"};
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("A");
		test.addLast("B");
		test.addLast("C");
		test.addLast("D");
		Iterator<String> iter = test.iterator();
		int i = 0;
		while(iter.hasNext())
		{
			Assert.assertEquals(expected[i], iter.next());
			i++;
		}
		Iterator<String> iter2 = test.iterator();
		iter2.next();
		iter2.remove();
		Assert.assertEquals("B", test.first().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#addAfter(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testAddAfter() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("A");
		test.addAfter(test.first(), "B");
		Assert.assertEquals(2, test.size());
		Assert.assertEquals("B", test.last().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#addBefore(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testAddBefore() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("B");
		test.addBefore(test.first(), "A");
		Assert.assertEquals(2, test.size());
		Assert.assertEquals("A", test.first().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		Assert.assertEquals("Nick", test.first().getElement());
		test.addFirst("All hail");
		Assert.assertEquals("All hail", test.first().getElement());
		Assert.assertEquals("Nick", test.last().getElement());

		
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#addLast(java.lang.Object)}.
	 */
	@Test
	public void testAddLast() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		Assert.assertEquals("Nick", test.first().getElement());
		test.addLast("All hail");
		Assert.assertEquals("Nick", test.first().getElement());
		Assert.assertEquals("All hail", test.last().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#after(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testAfter() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		test.addLast("All hail");
		Assert.assertEquals("All hail", test.after(test.first()).getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#before(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testBefore() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		test.addLast("All hail");
		Assert.assertEquals("Nick", test.before(test.last()).getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#first()}.
	 */
	@Test
	public void testFirst() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		test.addLast("All hail");
		Assert.assertEquals("Nick", test.first().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		Assert.assertEquals(true, test.isEmpty());
		test.addFirst("Nick");
		Assert.assertEquals(false, test.isEmpty());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#last()}.
	 */
	@Test
	public void testLast() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("Nick");
		test.addLast("All hail");
		Assert.assertEquals("All hail", test.last().getElement());
	}

	/** 	NOT FINISHED
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#positions()}.
	 */
	@Test
	public void testPositions() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		String[] expected = new String[10];
		String hold = "";
		for (int i = 0; i < 10; i++)
		{
			hold += "$";
			expected[i] = hold;
			test.addLast(hold);
			
		}
		Iterable<Position<String>> pos = test.positions();
		Iterator<Position<String>> iter = pos.iterator();
		int i = 0;
		while(iter.hasNext()) 
		{
			Assert.assertEquals(expected[i], iter.next().getElement());
			i++;
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#remove(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testRemove() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		test.addFirst("B");
		test.addFirst("A");
		test.addLast("C");
		test.remove(test.after(test.first()));
		Assert.assertEquals(2, test.size());
		Assert.assertEquals("C", test.after(test.first()).getElement());
		

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#set(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		String hold = "";
		for (int i = 0; i < 10; i++)
		{
			hold += "$";
			test.addFirst(hold);
		}
		test.set(test.first(), "Nick");
		Assert.assertEquals("Nick", test.first().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		PositionalLinkedList<String> test = new PositionalLinkedList<String>();
		String hold = "";
		for (int i = 0; i < 10; i++)
		{
			hold += "$";
			test.addFirst(hold);
		}
		Assert.assertEquals(10, test.size());
	}

}
