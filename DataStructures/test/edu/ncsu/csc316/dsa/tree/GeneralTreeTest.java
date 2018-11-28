package edu.ncsu.csc316.dsa.tree;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
/**
 * GeneralTree tests
 * @author nicholasrrichardson
 *
 */
public class GeneralTreeTest {
	private GeneralTree<Integer> tree;
	
	/**SetUp method.
	 * @throws java.lang.Exception - for stuff
	 */
	@Before
	public void setUp() throws Exception {
		tree = new GeneralTree<Integer>();
		
	}
	/**
	 * Constructor test.
	 */
	@Test
	public void testGeneralTree() {
		Assert.assertEquals(true, tree.isEmpty());
		Assert.assertEquals(null, tree.root());
	}
	/**
	 * Test parent
	 */
	@Test
	public void testParent() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> pos = tree1.addChild(tree1.root(), 3);
		Assert.assertEquals((Integer) 2, tree1.parent(pos).getElement());
	}
	/**
	 * Test iterator
	 */
	@Test
	public void testIterator() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> pos = tree1.addChild(tree1.root(), 3);
		tree1.addChild(pos, 5);
		Iterator<Integer> itr = tree1.iterator();
		Assert.assertEquals((Integer) 2, itr.next());
		Assert.assertEquals((Integer) 3, itr.next());
		Assert.assertEquals((Integer) 5, itr.next());

	}
	/**
	 * test addRoot
	 */
	@Test
	public void testAddRoot() {
		Assert.assertEquals(null, tree.root());
		Assert.assertEquals((Integer) 2, tree.addRoot(2).getElement());
		Assert.assertEquals((Integer) 2, tree.root().getElement());

	}
	/**
	 * Add child test
	 */
	@Test
	public void testAddChild() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		tree1.addChild(tree1.root(), 3);
		
		Iterator<Position<Integer>> itr = tree1.children(tree1.root()).iterator();
		Position<Integer> pos = itr.next();
		Assert.assertEquals((Integer) 3, pos.getElement());
		//Tests remove
		Assert.assertEquals((Integer) 3, tree1.remove(pos));
		}
	/**
	 * Test set
	 */
	@Test
	public void testSet() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> pos = tree1.addChild(tree1.root(), 3);
		Iterator<Integer> itr = tree1.iterator();
		itr.next();
		tree1.set(pos, 123);
		Assert.assertEquals((Integer) 123, itr.next());
	}
	/**
	 * test isInternal and isLeaf
	 */
	@Test
	public void testIsInternalLeaf() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> internal = tree1.addChild(tree1.root(), 3);
		Position<Integer> leaf = tree1.addChild(internal, 10);
		Assert.assertEquals(true, tree1.isInternal(internal));
		Assert.assertEquals(false, tree1.isLeaf(internal));
		Assert.assertEquals(true, tree1.isLeaf(leaf));
		Assert.assertEquals(false, tree1.isInternal(leaf));
	}
	/**
	 * test isRoot
	 */
	@Test
	public void testIsRoot() {
		GeneralTree<Integer> tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> internal1 = tree1.addChild(tree1.root(), 3);
		tree1.addChild(internal1, 10);
		Assert.assertEquals(true, tree1.isRoot(tree1.root()));
		Assert.assertEquals(false, tree1.isRoot(internal1));
	}
	/**
	 * test isEmpty
	 */
	@Test
	public void testIsEmpty() {
		GeneralTree<Integer> tree1 = new GeneralTree<Integer>();
		Assert.assertEquals(true, tree1.isEmpty());
		tree1.addRoot(2);
		Assert.assertEquals(false, tree1.isEmpty());

	}
	/**
	 * postOrder test
	 */
	@Test
	public void testPostOrder() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> internal1 = tree1.addChild(tree1.root(), 3);
		tree1.addChild(internal1, 10);
		
		Position<Integer> internal2 = tree1.addChild(tree1.root(), 6);
		tree1.addChild(internal2, 20);
		
		Iterator<Position<Integer>> itr = tree1.postOrder().iterator();
		Assert.assertEquals((Integer) 10, itr.next().getElement());
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		Assert.assertEquals((Integer) 20, itr.next().getElement());
		Assert.assertEquals((Integer) 6, itr.next().getElement());
		Assert.assertEquals((Integer) 2, itr.next().getElement());
	}

	/**
	 * test levelOrder
	 */
	@Test
	public void testLevelOrder() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> internal1 = tree1.addChild(tree1.root(), 3);
		tree1.addChild(internal1, 10);
		
		Position<Integer> internal2 = tree1.addChild(tree1.root(), 6);
		tree1.addChild(internal2, 20);
		
		Iterator<Position<Integer>> itr = tree1.levelOrder().iterator();
		Assert.assertEquals((Integer) 2, itr.next().getElement());
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		Assert.assertEquals((Integer) 6, itr.next().getElement());
		Assert.assertEquals((Integer) 10, itr.next().getElement());
		Assert.assertEquals((Integer) 20, itr.next().getElement());
	}
	 /**
	  * test to string;
	  */
	@Test
	public void testToString() {
		GeneralTree<Integer>tree1 = new GeneralTree<Integer>();
		tree1.addRoot(2);
		Position<Integer> internal1 = tree1.addChild(tree1.root(), 3);
		tree1.addChild(internal1, 10);
		
		Position<Integer> internal2 = tree1.addChild(tree1.root(), 6);
		tree1.addChild(internal2, 20);
		
		Assert.assertEquals(true, tree1.toString() != null);

	}

}
