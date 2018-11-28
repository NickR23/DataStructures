package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.AbstractMap.MapEntry;
import edu.ncsu.csc316.dsa.map.Map.Entry;
/**
 * SkipListTest
 * @author nicholasrrichardson
 *
 */
public class SkipListMapTest {

	/**
	 * Default constructor test
	 */
	@Test
	public void testSearchTableMap() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		Assert.assertEquals(null, map.get(123));
	}
	/**
	 * Constructor test
	 */
	@Test
	public void testSearchTableMapComparatorOfK() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		Assert.assertEquals(null, map.get(123));
	}
	/**
	 * Size test
	 */
	@Test
	public void testSize() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		map.put(15, "Nick");
		map.put(23, "Rich");
	}
	/**
	 * Get test
	 */
	@Test
	public void testGet() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		map.put(15, "15");
		map.put(23, "23");
		//System.out.println(map.toFullString());
		Assert.assertEquals("15", map.get(15));
		Assert.assertEquals("23", map.get(23));

	}
	/**
	 * Set test
	 */
	@Test
	public void testEntrySet() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
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
	 * Put test
	 */
	@Test
	public void testPut() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(map.get(2), null);
		map.put(0, "zero");
		Assert.assertEquals("zero", map.get(0));
		map.put(1, "one");
		Assert.assertEquals("one", map.get(1));
		Assert.assertEquals(map.get(0), "zero");
		map.put(0, "zebra");
		Assert.assertEquals(map.get(0), "zebra");
	}
	/**
	 * Remove test
	 */
	@Test
	public void testRemove() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			str += "*";
			map.put(i, str);
		}
		Assert.assertEquals("****", map.get(2));
		Assert.assertEquals("***", map.get(1));
		System.out.println(map.toFullString());
		Assert.assertEquals("****", map.remove(2));
		System.out.println("~~~~~~~~~~~~~After Removing 2~~~~~~~~~~~~~~~~~~");
		System.out.println(map.toFullString());
		Assert.assertEquals(null, map.get(2));

	}
	/**
	 * ToString test
	 */
	@Test
	public void testToString() {
		SkipListMap<Integer, String> map = new SkipListMap<Integer, String>();
		Assert.assertEquals(map.get(2), null);
		map.put(0, "zero");
		map.put(1, "one");
		Assert.assertEquals("SkipListMap[0, 1]", map.toString());
		}

}
