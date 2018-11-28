/**
 * 
 */
package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;
import org.junit.Assert;
import org.junit.Test;

/** PostionalStack test cases.
 * @author nicholasrrichardson
 *
 */
public class PositionalStackTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.PositionalStack#PositionalStack()}.
	 */
	@Test
	public void testPositionalStack() {
		PositionalStack<String> test = new PositionalStack<String>();
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
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.PositionalStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		PositionalStack<String> test = new PositionalStack<String>();

		test.push("HEY");
		Assert.assertEquals("HEY", test.top());
		test.push("YOU!");
		Assert.assertEquals("YOU!", test.top());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.PositionalStack#pop()}.
	 */
	@Test
	public void testPop() {
		PositionalStack<String> test = new PositionalStack<String>();

		test.push("HEY");
		Assert.assertEquals("HEY", test.top());
		test.push("YOU!");
		Assert.assertEquals("YOU!", test.top());
		test.pop();
		Assert.assertEquals("HEY", test.top());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.stack.PositionalStack#size()}.
	 */
	@Test
	public void testSize() {
		PositionalStack<String> test = new PositionalStack<String>();

		test.push("HEY");
		Assert.assertEquals(1, test.size());
		test.push("YOU!");
		Assert.assertEquals(2, test.size());
		test.pop();
		Assert.assertEquals(1, test.size());
	}

}
