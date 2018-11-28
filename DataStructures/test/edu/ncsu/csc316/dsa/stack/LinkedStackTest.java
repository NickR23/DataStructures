package edu.ncsu.csc316.dsa.stack;
import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;

/**Test LinkedStack
 * @author nicholasrrichardson
 *
 */
public class LinkedStackTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.LinkedStack#LinkedStack()}.
	 */
	@Test
	public void testLinkedStack() {
		LinkedStack<String> test = new LinkedStack<String>();
		Assert.assertEquals(0, test.size());
		try {
			test.pop();
		}
		catch(EmptyStackException e)
		{
			Assert.assertEquals(true, true);
		}
		try {
			test.top();
		}
		catch(EmptyStackException e)
		{
			Assert.assertEquals(true, true);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.LinkedStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		LinkedStack<String> test = new LinkedStack<String>();

		test.push("HEY");
		Assert.assertEquals("HEY", test.top());
		test.push("YOU!");
		Assert.assertEquals("YOU!", test.top());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.LinkedStack#pop()}.
	 */
	@Test
	public void testPop() {
		LinkedStack<String> test = new LinkedStack<String>();

		test.push("HEY");
		Assert.assertEquals("HEY", test.top());
		test.push("YOU!");
		Assert.assertEquals("YOU!", test.top());
		test.pop();
		Assert.assertEquals("HEY", test.top());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.LinkedStack#size()}.
	 */
	@Test
	public void testSize() {
		LinkedStack<String> test = new LinkedStack<String>();

		test.push("HEY");
		Assert.assertEquals(1, test.size());
		test.push("YOU!");
		Assert.assertEquals(2, test.size());
		test.pop();
		Assert.assertEquals(1, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.LinkedStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		ArrayBasedStack<String> test = new ArrayBasedStack<String>();
		Assert.assertEquals(true, test.isEmpty());
		test.push("HEY");
		Assert.assertEquals(false, test.isEmpty());
	}

}
