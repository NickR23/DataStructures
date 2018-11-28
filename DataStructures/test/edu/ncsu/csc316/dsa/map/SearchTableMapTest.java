package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.AbstractMap.MapEntry;
import edu.ncsu.csc316.dsa.map.Map.Entry;
/**
 * SearchTableMap test
 * @author nicholasrrichardson
 *
 */
public class SearchTableMapTest {
	/**
	 * Default constructor test
	 */
	@Test
	public void testSearchTableMap() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		Assert.assertEquals(null, map.get(123));
	}
	/**
	 * Constructor test
	 */
	@Test
	public void testSearchTableMapComparatorOfK() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		Assert.assertEquals(null, map.get(123));
	}
	/**
	 * Size test
	 */
	@Test
	public void testSize() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		map.put(15, "Nick");
		map.put(23, "Rich");
	}
	/**
	 * Get test
	 */
	@Test
	public void testGet() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
		Assert.assertEquals(0, map.size());
		map.put(15, "Nick");
		map.put(23, "Rich");
		Assert.assertEquals("Nick", map.get(15));
		Assert.assertEquals("Rich", map.get(23));

	}
	/**
	 * Set test
	 */
	@Test
	public void testEntrySet() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
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
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
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
	 * Remove test
	 */
	@Test
	public void testRemove() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
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
	 * ToString test
	 */
	@Test
	public void testToString() {
		SearchTableMap<Integer, String> map = new SearchTableMap<Integer, String>();
		Assert.assertEquals(map.get(2), null);
		map.put(0, "zero");
		map.put(1, "one");
		Assert.assertEquals("SearchTableMap[0, 1]", map.toString());
		}
}


