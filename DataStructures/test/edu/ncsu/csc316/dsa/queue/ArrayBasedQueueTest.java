/**
 * 
 */
package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**ArrayBasedQueue tests.
 * @author nicholasrrichardson
 *
 */
public class ArrayBasedQueueTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.ArrayBasedQueue#ArrayBasedQueue()}.
	 */
	@Test
	public void testArrayBasedQueue() {
		ArrayBasedQueue<String> test = new ArrayBasedQueue<String>();
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
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.ArrayBasedQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue() {
		ArrayBasedQueue<String> test = new ArrayBasedQueue<String>();
		test.enqueue("Hello");
		Assert.assertEquals("Hello", test.front());
		test.enqueue("World");
		Assert.assertEquals("Hello", test.front());
		
		ArrayBasedQueue<String> test2 = new ArrayBasedQueue<String>();
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
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.ArrayBasedQueue#dequeue()}.
	 */
	@Test
	public void testDequeue() {
		ArrayBasedQueue<String> test = new ArrayBasedQueue<String>();
		test.enqueue("Hello");
		test.enqueue("World");
		Assert.assertEquals("Hello", test.dequeue());
		Assert.assertEquals("World", test.dequeue());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.ArrayBasedQueue#size()}.
	 */
	@Test
	public void testSize() {
		ArrayBasedQueue<String> test = new ArrayBasedQueue<String>();
		Assert.assertEquals(0, test.size());
		test.enqueue("A");
		Assert.assertEquals(1, test.size());
		test.dequeue();
		Assert.assertEquals(0, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.queue.ArrayBasedQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		ArrayBasedQueue<String> test = new ArrayBasedQueue<String>();
		Assert.assertEquals(true, test.isEmpty());	
		test.enqueue("NICK");
		Assert.assertEquals(false, test.isEmpty());	

		}

}
