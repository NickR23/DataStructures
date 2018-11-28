package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;
/**
 * AbstractMapTest
 * @author nicholasrrichardson
 *
 */
public class AbstractMapTest {

	/**
	 * IsEmptyTest
	 */
	@Test
	public void testIsEmpty() {
		UnorderedArrayMap<Integer, String> map = new UnorderedArrayMap<Integer, String>();
		Assert.assertEquals(true, map.isEmpty());
		map.put(2, "Curious George");
		Assert.assertEquals(false, map.isEmpty());
	}
	
	/**
	 * Iterator test
	 */
	@Test
	public void testIterator() {
		UnorderedArrayMap<Integer, String> map = new UnorderedArrayMap<Integer, String>();
		Iterator<Integer> itr = map.iterator();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			str += "*";
			map.put(i, str);
		}
		Integer i = 0;
		while(itr.hasNext())
		{
			Assert.assertEquals(i, itr.next());
			i++;
		}
		try
		{
			itr.remove();
		}
		catch(UnsupportedOperationException e)
		{
			Assert.assertTrue(true);
		}
	}

	/**
	 * Values test
	 */
	@Test
	public void testValues() {
		UnorderedArrayMap<Integer, String> map = new UnorderedArrayMap<Integer, String>();
		Iterator<String> itr = map.values().iterator();
		String str = "*";
		for(int i = 0; i < 10; i++)
		{
			str += "*";
			map.put(i, str);
		}
		str = "*";
		while(itr.hasNext())
		{
			str += "*";
			Assert.assertEquals(str, itr.next());
		}
		try
		{
			itr.remove();
		}
		catch(UnsupportedOperationException e)
		{
			Assert.assertTrue(true);
		}
	}

}
