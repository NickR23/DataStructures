package edu.ncsu.csc316.dsa.map.search_tree;


import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map.Entry;
/**
 * Tests for SplayTreeMap
 * @author nicholasrrichardson
 *
 */
public class SplayTreeMapTest {
	/**
	 * Test reconstructing behavior
	 */
	@Test
	public void testOperations() {
		SplayTreeMap<Integer, String> tree = new SplayTreeMap<Integer, String>();
		tree.put(1, "A");
		tree.put(3, "C");
		tree.put(2, "B");
		tree.put(4, "D");
		
		Iterator<Position<Entry<Integer, String>>> itr = tree.preOrder().iterator();
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("A", itr.next().getElement().getValue());

		Assert.assertEquals("A", tree.get(1));	
		
		itr = tree.preOrder().iterator();
		
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		
		Assert.assertEquals("D", tree.get(4));	

		
		itr = tree.preOrder().iterator();
		
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
	}
	
	/**
	 * Test constructor
	 */
	@Test
	public void testSplayTreeMap() {
		SplayTreeMap<Integer, String> tree = new SplayTreeMap<Integer, String>();
		Assert.assertEquals(0, tree.size());
	}
	/**
	 * Test arg constructor
	 */
	@Test
	public void testSplayTreeMapComparatorOfK() {
		SplayTreeMap<Integer, String> tree = new SplayTreeMap<Integer, String>(null);
		Assert.assertEquals(0, tree.size());
	}

}
