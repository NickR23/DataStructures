package edu.ncsu.csc316.dsa.priority_queue;

import org.junit.Assert;
import org.junit.Test;
/**
 * HeapPriorityQueue test
 * @author nicholasrrichardson
 *
 */
public class HeapPriorityQueueTest {
	/**
	 * Test constructor
	 */
	@Test
	public void testHeapPriorityQueueComparatorOfK() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		Assert.assertEquals(0, queue.size());
	}
	/**
	 * Test no-arg constructor
	 */
	@Test
	public void testHeapPriorityQueue() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		Assert.assertEquals(0, queue.size());
	}
	/**
	 * Test insert
	 */
	@Test
	public void testInsert() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		queue.insert(100, "Nick");
		Assert.assertEquals(1, queue.size());
		queue.insert(50, "B");
		Assert.assertEquals(2, queue.size());
		queue.insert(20, "B");
		queue.insert(10, "B");
		queue.insert(3, "B");
		Assert.assertEquals(5, queue.size());
	}
	/**
	 * Test min
	 */
	@Test
	public void testMin() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		queue.insert(100, "Nick");
		queue.insert(50, "B");
		queue.insert(20, "B");
		queue.insert(10, "B");
		queue.insert(3, "B");
		Assert.assertEquals("B", queue.min().getValue());
	}
	/**
	 * Test deleteMin
	 */
	@Test
	public void testDeleteMin() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		queue.insert(100, "Nick");
		queue.insert(50, "B");
		queue.insert(20, "B");
		queue.insert(10, "B");
		queue.insert(3, "B");
		Assert.assertEquals("B", queue.deleteMin().getValue());
		Assert.assertEquals(4, queue.size());
		Assert.assertEquals("B", queue.min().getValue());

		}
	/**
	 * Test size
	 */
	@Test
	public void testSize() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		queue.insert(100, "Nick");
		queue.insert(50, "B");
		queue.insert(20, "B");
		queue.insert(10, "B");
		queue.insert(3, "B");	
		Assert.assertEquals(5, queue.size());
	}
	
	/**
	 * Test isEmpty
	 */
	@Test
	public void testIsEmpty() {
		HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<Integer, String>(null);
		Assert.assertEquals(true, queue.isEmpty());
	}

}
