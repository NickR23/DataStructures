package edu.ncsu.csc316.dsa.disjoint_set;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
/**
 * UpTreeDisjointSetForest test
 * @author nicholasrrichardson
 *
 */
public class UpTreeDisjointSetForestTest {
	/**
	 * Constructor test
	 */
	@Test
	public void testUpTreeDisjointSetForest() {
		UpTreeDisjointSetForest<String> set = new UpTreeDisjointSetForest<String>();
		assertTrue(set instanceof UpTreeDisjointSetForest);
 	}
	/**
	 * Test find
	 */
	@Test
	public void testFind() {
		UpTreeDisjointSetForest<String> set = new UpTreeDisjointSetForest<String>();
		set.makeSet("C'est");
		set.makeSet("la");
		set.makeSet("Vie");
		Assert.assertEquals("C'est", set.find("C'est").getElement());
		Assert.assertEquals("la", set.find("la").getElement());

	}
	/**
	 * Test union
	 */
	@Test
	public void testUnion() {
		UpTreeDisjointSetForest<String> set = new UpTreeDisjointSetForest<String>();
		set.makeSet("C'est");
		set.makeSet("la");
		set.makeSet("Vie");
		set.union(set.find("C'est"), set.find("la"));
		
		Assert.assertEquals("C'est", set.find("C'est").getElement());
		Assert.assertEquals("C'est", set.find("la").getElement());
	}

}
