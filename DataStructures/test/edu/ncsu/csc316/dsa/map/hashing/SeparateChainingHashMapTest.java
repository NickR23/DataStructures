package edu.ncsu.csc316.dsa.map.hashing;

import java.util.Iterator;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map.Entry;
import org.junit.Assert;

/**SeperateChainingHashMap test
 * @author nicholasrrichardson
 *
 */
public class SeparateChainingHashMapTest {
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.SeparateChainingHashMap#SeparateChainingHashMap()}.
	 */
	@Test
	public void testSeparateChainingHashMap() {
		SeparateChainingHashMap<Integer, String> hashMap = new SeparateChainingHashMap<Integer, String>();
		Assert.assertEquals(0, hashMap.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.SeparateChainingHashMap#SeparateChainingHashMap(int)}.
	 */
	@Test
	public void testSeparateChainingHashMapInt() {
		SeparateChainingHashMap<Integer, String> hashMap = new SeparateChainingHashMap<Integer, String>(20);
		Assert.assertEquals(0, hashMap.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.hashing.SeparateChainingHashMap#entrySet()}.
	 */
	@Test
	public void testEntrySet() {
		SeparateChainingHashMap<Integer, String> hashMap = new SeparateChainingHashMap<Integer, String>();
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
		SeparateChainingHashMap<Integer, String> hashMap = new SeparateChainingHashMap<Integer, String>();
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

}
