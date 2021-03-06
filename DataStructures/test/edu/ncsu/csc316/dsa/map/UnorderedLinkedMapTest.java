/**
 * 
 */
package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.AbstractMap.MapEntry;
import edu.ncsu.csc316.dsa.map.Map.Entry;

/** UnorderArrayMapTest JUnit. Fun stuff.
 * @author nicholasrrichardson
 *
 */
public class UnorderedLinkedMapTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#UnorderedArrayMap()}.
	 */
	@Test
	public void testUnorderedArrayMap() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		Assert.assertEquals("UnorderedLinkedMap[]", map.toString());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#get(java.lang.Object)}.
	 */
	@Test
	public void testGetPut() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		Assert.assertEquals(map.get(2), null);
		map.put(0, "zero");
		Assert.assertEquals(map.get(0), "zero");
		map.put(1, "one");
		Assert.assertEquals(map.get(1), "one");
		Assert.assertEquals(map.get(0), "zero");
		map.put(0, "zebra");
		Assert.assertEquals(map.get(0), "zebra");
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			map.put(i, str + str);
		}
		Assert.assertEquals("**", map.get(2));
		Assert.assertEquals("**", map.remove(2));
		Assert.assertEquals(null, map.get(2));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#size()}.
	 */
	@Test
	public void testSize() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			map.put(i, str + str);
		}
		Assert.assertEquals(10, map.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#entrySet()}.
	 */
	@Test
	public void testEntrySet() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			map.put(i, str + str);
		}
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		int i = 0;
		str = "*";
		while (itr.hasNext())
		{
			Assert.assertEquals(map.get(i), ((MapEntry<Integer, String>) itr.next()).getValue());
			i++;
			str += "*";
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.UnorderedArrayMap#toString()}.
	 */
	@Test
	public void testToString() {
		UnorderedLinkedMap<Integer, String> map = new UnorderedLinkedMap<Integer, String>();
		Assert.assertEquals(map.get(2), null);
		map.put(0, "zero");
		map.put(1, "one");
		Assert.assertEquals("UnorderedLinkedMap[1, 0]", map.toString());
		}


}
