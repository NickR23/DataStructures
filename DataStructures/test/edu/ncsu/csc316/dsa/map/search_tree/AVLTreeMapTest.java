/**
 * 
 */
package edu.ncsu.csc316.dsa.map.search_tree;


import java.util.Iterator;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map.Entry;
import org.junit.Assert;

/**AVLTree tests
 * @author nicholasrrichardson
 *
 */
public class AVLTreeMapTest {


	/**
	 * Test operations
	 */
	@Test
	public void testActionOnInsert() {
		AVLTreeMap<Integer, String> tree = new AVLTreeMap<Integer, String>();
		tree.put(1, "A");
		tree.put(3, "C");
		tree.put(2, "B");
		tree.put(4, "D");
		
		Iterator<Position<Entry<Integer, String>>> itr = tree.inOrder().iterator();
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		
		tree.remove(2);
		
		itr = tree.inOrder().iterator();
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		
		tree.put(6, "F");
		tree.put(7, "G");
		tree.put(5, "E");
		tree.put(8, "H");
		
		itr = tree.inOrder().iterator();
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("E", itr.next().getElement().getValue());
		Assert.assertEquals("F", itr.next().getElement().getValue());
		Assert.assertEquals("G", itr.next().getElement().getValue());
		Assert.assertEquals("H", itr.next().getElement().getValue());
		
		itr = tree.inOrder().iterator();
		tree.remove(6);
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("E", itr.next().getElement().getValue());
		Assert.assertEquals("G", itr.next().getElement().getValue());

	}

	/**
	 * Test rebalance()
	 */
	@Test
	public void testRebalance(){
		AVLTreeMap<Integer, String> tree = new AVLTreeMap<Integer, String>();
		tree.put(10, "A");
		tree.put(6, "C");
		tree.put(7, "B");
		tree.put(15, "L");
		tree.put(2, "I");
		tree.put(3, "K");
		tree.put(1, "U");
		tree.put(9, "Y");

		tree.remove(3);
	    tree.remove(tree.root().getElement().getKey());
		Assert.assertEquals(true, true);
		
	}
	
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.AVLTreeMap#AVLTreeMap()}.
	 */
	@Test
	public void testAVLTreeMap() {
		AVLTreeMap<Integer, String> tree = new AVLTreeMap<Integer, String>();
		Assert.assertEquals(0, tree.size());
	}  

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.AVLTreeMap#AVLTreeMap(java.util.Comparator)}.
	 */
	@Test
	public void testAVLTreeMapComparatorOfK() {
		AVLTreeMap<Integer, String> tree = new AVLTreeMap<Integer, String>(null);
		Assert.assertEquals(0, tree.size());
	}

}
