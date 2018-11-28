/**
 * 
 */
package edu.ncsu.csc316.dsa.map.hashing;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map.Entry;

/**LinearProbingHashMap test
 * @author nicholasrrichardson
 *
 */
public class LinearProbingHashMapTest {
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap#LinearProbingHashMap()}.
	 */
	@Test
	public void testLinearProbingHashMap() {
		LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<Integer, String>();
		Assert.assertEquals(0, hashMap.size());
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap#LinearProbingHashMap(int)}.
	 */
	@Test
	public void testLinearProbingHashMapInt() {
		LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<Integer, String>(999);
		Assert.assertEquals(0, hashMap.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap#entrySet()}.
	 */
	@Test
	public void testEntrySet() {
		LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<Integer, String>();
		hashMap.put(1, "A");
		Assert.assertEquals(1, hashMap.size());
		Assert.assertEquals("A", hashMap.get(1));
		hashMap.put(2, "B");
		hashMap.put(3, "C");
		hashMap.put(4, "D");
		Iterator<Entry<Integer, String>> itr = hashMap.entrySet().iterator();
		
		itr.next();
		itr.next();
		Assert.assertEquals(true, itr.hasNext());
		itr.next();
		itr.next();
		Assert.assertEquals(false, itr.hasNext());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.AbstractHashMap#put(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testPutGetRemove() {
		LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<Integer, String>();
		hashMap.put(1, "A");
		Assert.assertEquals(1, hashMap.size());
		Assert.assertEquals("A", hashMap.get(1));
		hashMap.put(2, "B");
		hashMap.put(3, "C");
		hashMap.put(4, "D");
		Assert.assertEquals("B", hashMap.get(2));
		Assert.assertEquals("C", hashMap.get(3));
		Assert.assertEquals("D", hashMap.get(4));

		hashMap.put(1, "Nick");
		Assert.assertEquals("Nick", hashMap.get(1));

		//Testing remove
		Assert.assertEquals("Nick", hashMap.remove(1));
		Assert.assertEquals(3, hashMap.size());
		
		
		Assert.assertEquals(null, hashMap.remove(999));
		Assert.assertEquals(3, hashMap.size());
	}
	
	/**
	 * Test resize()
	 */
	@Test
	public void testResize()
	{
		LinearProbingHashMap<Integer, String> hashMap = new LinearProbingHashMap<Integer, String>(2);
		hashMap.put(1, "A");
		Assert.assertEquals(1, hashMap.size());
		Assert.assertEquals("A", hashMap.get(1));
		hashMap.put(2, "B");
		hashMap.put(3, "C");
		hashMap.put(4, "D");
		Assert.assertEquals("B", hashMap.get(2));
		Assert.assertEquals("C", hashMap.get(3));
		Assert.assertEquals("D", hashMap.get(4));
	}

}
