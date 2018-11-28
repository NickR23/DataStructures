package edu.ncsu.csc316.dsa.priority_queue;

import org.junit.Test;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;
import org.junit.Assert;
/**
 * Adaptable test
 * @author nicholasrrichardson
 *
 */
public class HeapAdaptablePriorityQueueTest {
	/**
	 * Constructor test
	 */
	@Test
	public void testHeapAdaptablePriorityQueueComparatorOfK() {
		HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<Integer, String>(null);
		Assert.assertEquals(0, queue.size());
	}
	/**
	 * Constructor test
	 */
	@Test
	public void testHeapAdaptablePriorityQueue() {
		HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<Integer, String>();
		Assert.assertEquals(0, queue.size());

	}
	/**
	 * Test remove
	 */
	@Test
	public void testRemove() {
		HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<Integer, String>();
		queue.insert(3, "A");
		Entry<Integer, String> entry = queue.insert(2, "B");
		queue.insert(1, "C");
		queue.remove(entry);
		
		Assert.assertEquals(2, queue.size());
		Assert.assertEquals("C", queue.deleteMin().getValue());
		Assert.assertEquals("A", queue.deleteMin().getValue());

	}
	/**
	 * Test replaceKey
	 */
	@Test
	public void testReplaceKey() {
		HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<Integer, String>();
		queue.insert(5, "A");
		Entry<Integer, String> entry = queue.insert(4, "B");
		queue.insert(3, "C");
		queue.replaceKey(entry, 1);
		
		Assert.assertEquals("B", queue.deleteMin().getValue());
		Assert.assertEquals("C", queue.deleteMin().getValue());	
		}
	/**
	 * Test replaceValue
	 */
	@Test
	public void testReplaceValue() {
		HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<Integer, String>();
		queue.insert(5, "A");
		Entry<Integer, String> entry = queue.insert(4, "B");
		queue.insert(3, "C");
		queue.replaceValue(entry, "Rich");
		
		Assert.assertEquals("C", queue.deleteMin().getValue());
		Assert.assertEquals("Rich", queue.deleteMin().getValue());		}

}
