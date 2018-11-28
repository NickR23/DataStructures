
package edu.ncsu.csc316.dsa.map.search_tree;

import java.util.Iterator;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map.Entry;
import org.junit.Assert;

/**BinarySearchTreeMap test
 * @author nicholasrrichardson
 *
 */
public class BinarySearchTreeMapTest {
	
	BinarySearchTreeMap<Integer, String> tree = new BinarySearchTreeMap<Integer, String>();
	
	

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#BinarySearchTreeMap()}.
	 */
	@Test
	public void testBinarySearchTreeMap() {
		Assert.assertEquals(0, tree.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#size()}.
	 */
	@Test
	public void testSize() {
		tree.put(1, "A");
		tree.put(2, "B");
		tree.put(3, "C");
		Assert.assertEquals(3, tree.size());
	}
	

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#get(java.lang.Comparable)}.
	 */
	@Test
	public void testGetPut() {
		tree.put(1, "A");
		tree.put(2, "B");
		tree.put(3, "C");
		Assert.assertEquals("A", tree.get(1));
		Assert.assertEquals("B", tree.get(2));
		Assert.assertEquals("C", tree.get(3));
		tree.put(2, "Nick");
		Assert.assertEquals("Nick", tree.get(2));

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#remove(java.lang.Comparable)}.
	 */
	@Test
	public void testRemoveK() {
		tree.put(2, "B");
		tree.put(1, "A");
		tree.put(3, "C");
		tree.put(5, "E");
		tree.put(4, "D");
		tree.put(6, "F");
		Assert.assertEquals("A", tree.get(1));
		Assert.assertEquals("B", tree.get(2));
		Assert.assertEquals("C", tree.get(3));
		Assert.assertEquals("E", tree.remove(5));
		Assert.assertEquals(null, tree.remove(23));
		}

	
	/**
	 * Test method for restructure.
	 */
	@Test
	public void testRestructure() {
		tree.put(2, "B");
		tree.put(1, "A");
		tree.put(3, "C");
		tree.put(5, "E");
		tree.put(4, "D");

		Assert.assertEquals("A", tree.get(1));
		Assert.assertEquals("B", tree.get(2));
		Assert.assertEquals("C", tree.get(3));
		tree.restructure(tree.left(tree.right(tree.right(tree.root()))));
		Iterator<Position<Entry<Integer, String>>> itr = tree.inOrder().iterator();
		
		
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("D", itr.next().getElement().getValue());
		Assert.assertEquals("E", itr.next().getElement().getValue());

		
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(1, "A");
		tree1.put(2, "B");
		tree1.put(3, "C");
		tree.restructure(tree.right(tree.right(tree.root())));
		Iterator<Position<Entry<Integer, String>>> itr1 = tree.postOrder().iterator();
		Assert.assertEquals("A", itr1.next().getElement().getValue());
		Assert.assertEquals("C", itr1.next().getElement().getValue());
		Assert.assertEquals("B", itr1.next().getElement().getValue());
		}
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#entrySet()}.
	 */
	@Test
	public void testEntrySet() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Iterator<Entry<Integer, String>> itr = tree1.entrySet().iterator();
		Assert.assertEquals(true, itr.hasNext());
		Assert.assertEquals("A", tree1.get(itr.next().getKey()));
		Assert.assertEquals("B", tree1.get(itr.next().getKey()));
		Assert.assertEquals("C", tree1.get(itr.next().getKey()));

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#toString()}.
	 */
	@Test
	public void testToString() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(1, "A");
		tree1.put(2, "B");
		tree1.put(3, "C");
		String result = tree1.toString();		
		Assert.assertEquals(true, result != null);
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#root()}.
	 */
	@Test
	public void testRoot() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(1, "A");
		tree1.put(2, "B");
		tree1.put(3, "C");
		Assert.assertEquals("A", tree1.root().getElement().getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#parent(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testParent() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Iterator<Position<Entry<Integer, String>>> itr = tree1.children(tree1.root()).iterator();
		Assert.assertEquals("B", tree1.parent(itr.next()).getElement().getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#children(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testChildren() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Iterator<Position<Entry<Integer , String>>> itr = tree1.children(tree1.root()).iterator();
		Assert.assertEquals(true, itr.hasNext());
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());

		Assert.assertEquals(false, itr.hasNext());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#numChildren(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testNumChildren() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Assert.assertEquals(2, tree1.numChildren(tree1.root()));
		Position<Entry<Integer, String>> right = tree1.right(tree1.root());
		Assert.assertEquals(0, tree1.numChildren(right));
		Position<Entry<Integer, String>> left = tree1.left(tree1.root());
		Assert.assertEquals(0, tree1.numChildren(left));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#isInternal(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testIsInternal() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		Position<Entry<Integer, String>> left = tree1.left(tree1.root());
		Assert.assertEquals(true, tree1.isInternal(left));
		Assert.assertEquals(false, tree1.isInternal(tree1.left(left)));

		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#isLeaf(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testIsLeaf() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		Position<Entry<Integer, String>> left = tree1.left(tree1.root());
		Assert.assertEquals(false, tree1.isLeaf(left));
		Assert.assertEquals(true, tree1.isLeaf(tree1.left(left)));	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#isRoot(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testIsRoot() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		Position<Entry<Integer, String>> root = tree1.root();
		Assert.assertEquals(true, tree1.isRoot(root));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#preOrder()}.
	 */
	@Test
	public void testPreOrder() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		
		Iterator<Position<Entry<Integer, String>>> itr = tree1.preOrder().iterator();
		Assert.assertEquals(true, itr.hasNext());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("Nick", itr.next().getElement().getValue());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#postOrder()}.
	 */
	@Test
	public void testPostOrder() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Iterator<Position<Entry<Integer, String>>> itr = tree1.postOrder().iterator();
		Assert.assertEquals(true, itr.hasNext());
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#levelOrder()}.
	 */
	@Test
	public void testLevelOrder() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		
		Iterator<Position<Entry<Integer, String>>> itr = tree1.preOrder().iterator();
		Assert.assertEquals(true, itr.hasNext());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());
		Assert.assertEquals("Nick", itr.next().getElement().getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#left(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testLeft() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Assert.assertEquals("A", tree1.left(tree1.root()).getElement().getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#right(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testRight() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		Assert.assertEquals("C", tree1.right(tree1.root()).getElement().getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#sibling(edu.ncsu.csc316.dsa.Position)}.
	 */
	@Test
	public void testSibling() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(2, "B");
		tree1.put(1, "A");
		tree1.put(3, "C");
		tree1.put(4, "Nick");
		Position<Entry<Integer, String>> left = tree1.left(tree1.root());

		Assert.assertEquals("C", tree1.sibling(left).getElement().getValue());
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap#inOrder()}.
	 */
	@Test
	public void testInOrder() {
		BinarySearchTreeMap<Integer, String> tree1 = new BinarySearchTreeMap<Integer, String>();
		tree1.put(1, "A");
		tree1.put(2, "B");
		tree1.put(3, "C");
		Iterator<Position<Entry<Integer, String>>> itr = tree1.inOrder().iterator();
		
		Assert.assertEquals("A", itr.next().getElement().getValue());
		Assert.assertEquals("B", itr.next().getElement().getValue());
		Assert.assertEquals("C", itr.next().getElement().getValue());

	}

}
