/**
 * 
 */
package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;

import org.junit.*;

/**LinkedBinaryTree test
 * @author nicholasrrichardson
 *
 */
public class LinkedBinaryTreeTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#LinkedBinaryTree()}.
	 */
	@Test
	public void testLinkedBinaryTree() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		Assert.assertEquals(0, tree.size());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#addLeft(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testAddLeft() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Assert.assertEquals("A", tree.root().getElement());
		Position<String> pos = tree.addLeft(tree.root(), "B");
		Assert.assertEquals("B", tree.left(tree.root()).getElement());
		tree.addLeft(pos, "C");
		Assert.assertEquals("C", tree.left(pos).getElement());
		try
		{
			tree.addLeft(tree.root(), "Nick");
		} catch(IllegalArgumentException e)
		{
			Assert.assertTrue(true);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#addRight(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testAddRight() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Assert.assertEquals("A", tree.root().getElement());
		Position<String> pos = tree.addRight(tree.root(), "B");
		Assert.assertEquals("B", tree.right(tree.root()).getElement());
		tree.addRight(pos, "C");
		Assert.assertEquals("C", tree.right(pos).getElement());
		
		try
		{
			tree.addRight(pos, "Nick");
		} catch(IllegalArgumentException e)
		{
			Assert.assertTrue(true);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#root()}.
	 */
	@Test
	public void testRoot() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Assert.assertEquals("A", tree.root().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#parent(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testParent() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		Position<String> leaf = tree.addLeft(pos, "C");
		Assert.assertEquals(tree.root(), tree.parent(pos));
		Assert.assertEquals("B", tree.parent(leaf).getElement());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#remove(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testRemove() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addRight(pos, "C");
		
		Assert.assertEquals("B", tree.remove(pos));
		Assert.assertEquals("C", tree.left(tree.root()).getElement());

		//Right side
		Position<String> pos2 = tree.addRight(tree.root(), "D");
		tree.addRight(pos2, "E");
		Assert.assertEquals("D", tree.remove(pos2));
		Assert.assertEquals("E", tree.right(tree.root()).getElement());
		
	
		//Root
		LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<String>();
		tree1.addRoot("A");
		tree1.remove(tree1.root());
		Assert.assertEquals(0, tree1.size());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.LinkedBinaryTree#size()}.
	 */
	@Test
	public void testSize() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addRight(pos, "C");
		Assert.assertEquals(3, tree.size());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#inOrder()}.
	 */
	@Test
	public void testInOrder() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addLeft(pos, "C");
		tree.addRight(pos, "D");
		Iterator<Position<String>> itr = tree.inOrder().iterator();
		Assert.assertEquals("C", itr.next().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#sibling(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testSibling() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		Position<String> sib = tree.addRight(tree.root(), "C");
		Assert.assertEquals(sib.getElement(), tree.sibling(pos).getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#numChildren(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testNumChildren() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		tree.addLeft(tree.root(), "B");
		Position<String> sib = tree.addRight(tree.root(), "C");
		tree.addRight(sib, "Uh oh");
		Assert.assertEquals(2, tree.numChildren(tree.root()));	
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#set(edu.ncsu.csc316.dsa.Position, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addRight(pos, "C");
		tree.set(pos, "123");
		Assert.assertEquals("123", pos.getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#iterator()}.
	 */
	@Test
	public void testIterator() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addRight(pos, "C");
		Iterator<String> itr = tree.iterator();
		Assert.assertEquals("B", itr.next());
		Assert.assertEquals("C", itr.next());
		Assert.assertEquals("A", itr.next());
		Assert.assertEquals(false, itr.hasNext());
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
	 * Test method for {@link edu.ncsu.csc316.dsa.tree.AbstractBinaryTree#children(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testChildren() {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		tree.addRoot("A");
		Position<String> pos = tree.addLeft(tree.root(), "B");
		tree.addRight(pos, "C");
		Iterator<Position<String>> itr = tree.children(tree.root()).iterator();
		Assert.assertEquals("B", itr.next().getElement());
	}

}
