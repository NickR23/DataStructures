/**
 * 
 */
package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**PositionalQueue tests.
 * @author nicholasrrichardson
 *
 */
public class PositionalQueueTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.PositionalQueue#PositionalQueue()}.
	 */
	@Test
	public void testPositionalQueue() {
		PositionalQueue<String> test = new PositionalQueue<String>();
		Assert.assertEquals(0, test.size());
		try {
			test.dequeue();
		}
		catch(NoSuchElementException e)
		{
			Assert.assertEquals(true, true);
		}
		try {
			test.front();
		}
		catch(NoSuchElementException e)
		{
			Assert.assertEquals(true, true);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.PositionalQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue() {
		PositionalQueue<String> test = new PositionalQueue<String>();
		test.enqueue("Hello");
		Assert.assertEquals("Hello", test.front());
		test.enqueue("World");
		Assert.assertEquals("Hello", test.front());
		
		PositionalQueue<String> test2 = new PositionalQueue<String>();
		String[] expected = new String[20];
		String add = "";
		for(int i = 0; i < 20; i++)
		{
			add += "!";
			expected[i] = add;
			test2.enqueue(add);
		}
		for(int i = 0; i < expected.length; i++)
		{
			Assert.assertEquals(expected[i], test2.dequeue());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.PositionalQueue#dequeue()}.
	 */
	@Test
	public void testDequeue() {
		PositionalQueue<String> test = new PositionalQueue<String>();
		test.enqueue("Hello");
		test.enqueue("World");
		Assert.assertEquals("Hello", test.dequeue());
		Assert.assertEquals("World", test.dequeue());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.PositionalQueue#size()}.
	 */
	@Test
	public void testSize() {
		PositionalQueue<String> test = new PositionalQueue<String>();
		Assert.assertEquals(0, test.size());
		test.enqueue("A");
		Assert.assertEquals(1, test.size());
		test.dequeue();
		Assert.assertEquals(0, test.size());
	}

}
