package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;
import org.junit.Test;
import org.junit.Assert;

/**
 * TreeSetTest
 * @author nicholasrrichardson
 *
 */
public class TreeSetTest {
	/**
	 * Test constructor
	 */
	@Test
	public void testTreeSet() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		Assert.assertEquals(0,  set.size());
		Assert.assertEquals(false,  set.contains(9));

	}
	/**
	 * Test iterator
	 */
	@Test
	public void testIterator() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		set.add(88);
		set.add(23);
		Iterator<Integer> itr = set.iterator();
		Assert.assertEquals((Integer)9, (Integer)itr.next());
		Assert.assertEquals((Integer)23, (Integer)itr.next());
		Assert.assertEquals((Integer)88, (Integer)itr.next());

	}
	/**
	 * Test add
	 */
	@Test
	public void testAdd() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		Assert.assertEquals(1, set.size());
		Assert.assertEquals(true, set.contains(9));
		Assert.assertEquals(false, set.contains(23));
	}
	/**
	 * Test remove
	 */
	@Test
	public void testRemove() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		set.add(88);
		set.add(23);
		Assert.assertEquals((Integer)9, (Integer)set.remove(9));
		Assert.assertEquals(false, set.contains(9));
		Assert.assertEquals(2, set.size());

		}
	/**
	 * Test addAll
	 */
	@Test
	public void testAddAll() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		set.add(88);
		set.add(23);
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		set2.add(9);
		set2.add(70);
		set2.add(3);
		set.addAll(set2);
		
		Assert.assertEquals(true, set.contains(9));
		Assert.assertEquals(5, set.size());

	}
	/**
	 * Test retainAll
	 */
	@Test
	public void testRetainAll() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		set.add(88);
		set.add(23);
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		set2.add(9);
		set2.add(70);
		set2.add(3);
		set.retainAll(set2);
		
		Assert.assertEquals(true, set.contains(9));
		Assert.assertEquals(false, set.contains(3));
		Assert.assertEquals(1, set.size());	
		}
	/**
	 * Test removeAll
	 */
	@Test
	public void testRemoveAll() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(9);
		set.add(88);
		set.add(23);
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		set2.add(88);
		set2.add(70);
		set2.add(23);
		set.removeAll(set2);
		
		Assert.assertEquals(true, set.contains(9));
		Assert.assertEquals(false, set.contains(70));
		Assert.assertEquals(1, set.size());	
		}
	/**
	 * Test isEmpty
	 */
	@Test
	public void testIsEmpty() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		Assert.assertEquals(true, set.isEmpty());
		set.add(9);
		set.add(88);
		set.add(23);	
		Assert.assertEquals(false, set.isEmpty());

		}

}
