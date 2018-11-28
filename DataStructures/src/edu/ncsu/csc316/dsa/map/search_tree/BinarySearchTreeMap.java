package edu.ncsu.csc316.dsa.map.search_tree;

import java.util.Comparator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.ArrayBasedList;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.tree.BinaryTree;
import edu.ncsu.csc316.dsa.tree.LinkedBinaryTree;
import edu.ncsu.csc316.dsa.map.Map.Entry;
import edu.ncsu.csc316.dsa.map.AbstractSortedMap;

/**
 * BinarySearchTreeMap
 * @author nicholasrrichardson
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> extends AbstractSortedMap<K, V>
implements BinaryTree<Entry<K, V>> {

	// The BalanceableBinaryTree class is an inner class below
	private BalanceableBinaryTree<K, V> tree;
	/**
	 * Constructor. Uses natural order comparator.
	 */
	public BinarySearchTreeMap() {
		this(null);
	}
	/**
	 * Constructor
	 * @param compare - Comparator
	 */
	public BinarySearchTreeMap(Comparator<K> compare) {
		super(compare);
		tree = new BalanceableBinaryTree<K, V>();
		tree.addRoot(null);
	}
	
	@Override
	public int size() {
		// Our search trees will all use dummy/sentinel leaf nodes,
		// so the actual number of elements in the tree will be (size-1)/2
		return (tree.size() - 1) / 2;
	}
	
	// This method is used to add dummy/sentinel left and right children as leaves
	private void expandLeaf(Position<Entry<K, V>> p, Entry<K, V> entry) {
        // initially, p is a dummy/sentinel node,
        // so replace the null entry with the new actual entry
        tree.set(p, entry);
        // Then add new dummy/sentinel children
        tree.addLeft(p, null);
        tree.addRight(p, null);
	}
	
	// This helper method traces a path down the tree to locate the position
	// that contains an entry with the given key.
	// Think of "lookUp" as returning the last node visited when tracing
	// a path down the tree to find the given key
	private Position<Entry<K, V>> lookUp(Position<Entry<K, V>> p, K key) {
		// If we have reached a dummy/sentinel node (a leaf), return that sentinel node
		if (isLeaf(p)) {
		    return p;
		}
		int comp = compare(key, p.getElement().getKey());
		if (comp == 0) {
		    // Return the position that contains the entry with the key
		    return p;
		} else if (comp < 0) {
		    return lookUp(left(p), key);
		} else {
		    return lookUp(right(p), key);
		}
	}
	
	@Override
	public V get(K key) {
		Position<Entry<K, V>> p = lookUp(tree.root(), key);
		// actionOnAccess is a "hook" for our AVL, Splay, and Red-Black Trees to use
		actionOnAccess(p);
		if (isLeaf(p)) {
		    return null;
		}
		return p.getElement().getValue();
	}
	
	@Override
	public V put(K key, V value) {
        // Create the new map entry
        Entry<K, V> newEntry = new MapEntry<K, V>(key, value);
        // Get the last node visited when looking for the key
        Position<Entry<K, V>> p = lookUp(root(), key);
        // If the last node visited is a dummy/sentinel node
        if (isLeaf(p)) {
            expandLeaf(p, newEntry);
            // actionOnInsert is a "hook" for our AVL, Splay, and Red-Black Trees to use
            actionOnInsert(p);
            return null;
        } else {
            V original = p.getElement().getValue();
            set(p, newEntry);
            // actionOnAccess is a "hook" for our AVL, Splay, and Red-Black Trees to use
            actionOnAccess(p);
            return original;
        }
	}
	
	@Override
	public V remove(K key) {
		// Get the last node visited when looking for the key
		Position<Entry<K, V>> p = lookUp(root(), key);
		// If p is a dummy/sentinel node
		if (isLeaf(p)) {
		    // actionOnAccess is a "hook" for our AVL, Splay, and Red-Black Trees to use
		    actionOnAccess(p);
		    return null;
		} else {
		    V original = p.getElement().getValue();
		    // If the node has two children (that are not dummy/sentinel nodes)
		    if (isInternal(left(p)) && isInternal(right(p))) {
		        // Replace with the inorder successor
		        Position<Entry<K, V>> replacement = treeMin(right(p));
		        set(p, replacement.getElement());
		        // Move p to the replacement node in the right subtree
		        p = replacement;
		    }
		    // Get the dummy/sentinel node (in case the node has an actual entry as a child)...
		    Position<Entry<K, V>> leaf = (isLeaf(left(p)) ? left(p) : right(p));
		    // ... then get its sibling (will be another sentinel or an actual entry node)
		    Position<Entry<K, V>> sib = sibling(leaf);
		    // Remove the leaf NODE (this is your binary tree remove method)
		    remove(leaf);
		    // Remove the NODE (this is your binary tree remove method)
		    // which will "promote" the sib node to replace p
		    remove(p);
		    // actionOnDelete is a "hook" for our AVL, Splay, and Red-Black Trees to use
		    actionOnDelete(sib);
		    return original;
		}
	}
	
	// Returns the inorder successor (the minimum from the right subtree)
	private Position<Entry<K, V>> treeMin(Position<Entry<K, V>> node) {
		Position<Entry<K, V>> current = node;
		while (isInternal(current)) {
		    current = left(current);
		}
		return parent(current);
		}
		
		@Override
		public Iterable<Entry<K, V>> entrySet() {
		List<Entry<K, V>> set = new ArrayBasedList<Entry<K, V>>(tree.size());
		for (Position<Entry<K, V>> n : tree.inOrder()) {
		    set.addLast(n.getElement());
		}
		return set;
	}
	
	@Override
	public String toString() {
		return tree.toString();
	}
	
	// This is a "hook" method that will be overridden in 
	// your AVL, Splay, and Red-Black tree implementations
	/**
	 * Not implemented here.
	 * @param node - The node
	 */
	protected void actionOnAccess(Position<Entry<K, V>> node) {
		// Do nothing for BST
	}
	
	// This is a "hook" method that will be overridden in 
	// your AVL, Splay, and Red-Black tree implementations
	/**
	 * Not implemented here.
	 * @param node - the node
	 */
	protected void actionOnInsert(Position<Entry<K, V>> node) {
		// Do nothing for BST
	}
	
	// This is a "hook" method that will be overridden in 
	// your AVL, Splay, and Red-Black tree implementations
	/**
	 * Not implemented here.
	 * @param node - Position
	 */
	protected void actionOnDelete(Position<Entry<K, V>> node) {
		// Do nothing for BST
	}
	
	/**
	 * BalanceableBinaryTree
	 * @author nicholasrrichardson
	 *
	 * @param <K> - generic key class
	 * @param <V> - generic value class
	 */
	protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {
	
	// Relink is a helper method for trinode restructuring and rotations
	private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
		if(child != null)
		{
			child.setParent(parent);
		}
		if (makeLeftChild)
		{
			parent.setLeft(child);
		}
		else
		{
			parent.setRight(child);
		}
	}
	
	// Rotate is a helper method for handling rotations and relinking nodes
	/**
	 * Rotates node
	 * @param p - Position
	 */
	public void rotate(Position<Entry<K, V>> p) {
	    Node<Entry<K, V>> node = validate(p);
	    Node<Entry<K, V>> parent = node.getParent();
	    Node<Entry<K, V>> granny = parent.getParent();
	    	
	    if(granny == null)
	    {
	    		setRoot(node);
	    		node.setParent(null);
	    }
	    else
	    {
	    		if (granny.getLeft() == parent)
	    		{
	    			relink(granny, node, true);
	    		}
	    		else
	    		{
	    			relink(granny, node, false);
	    		}
	    }
	    
	    if(parent.getLeft() == node)
	    {
	    		relink(parent, node.getRight(), true);
	    		relink(node, parent, false);
	    }
	    else
	    {
	    	   relink(parent, node.getLeft(), false);
	    	   relink(node, parent, true);
	    }
	}
	
	// Restructure is a helper method to perform a trinode restructuring
	// and trigger the appropriate rotations
	/**
	 * Rebalances
	 * @param x - Position to be rotated
	 * @return - new position of the node
	 */
	public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
		Node<Entry<K, V>> node = validate(x);
		Node<Entry<K, V>> parent = node.getParent();
		Node<Entry<K, V>> granny = parent.getParent();
		
		if ((granny.getLeft() == parent && parent.getLeft() == node) ||
				granny.getRight() == parent && parent.getRight() == node)
		{
			rotate(parent);
			return parent;
		}
		else
		{
			rotate(node);
			rotate(node);
			return node;
		}
	}
	
	@Override
	protected Node<Entry<K, V>> createNode(Entry<K, V> element, Node<Entry<K, V>> parent, Node<Entry<K, V>> left,
	    Node<Entry<K, V>> right) {
	    BSTNode<Entry<K, V>> newNode = new BSTNode<Entry<K, V>>(element);
	    newNode.setParent(parent);
	    newNode.setLeft(left);
	    newNode.setRight(right);
	    newNode.setProperty(0);
	    return newNode;
	}
	
	// A binary search tree node needs to keep track of some property.
	// For example, for AVL trees the "property" is the height of the node.
	// For Red-Black trees, the "property" is the color of the node.
	/**
	 * BinarySearchTree node
	 * @author nicholasrrichardson
	 *
	 * @param <E> - generic element class
	 */
	protected static class BSTNode<E> extends Node<E> {
	
	    private int property;
	    /**
	     * Cosntructor.
	     * @param element - element to be placed into node
	     */
	    public BSTNode(E element) {
	        super(element);
	        setProperty(0);
	    }
	    /**
	     * Sets the height of the node
	     * @param height - The height of the node
	     */
	    public void setProperty(int height) {
	        this.property = height;
	    }
	    /**
	     * Property of the node
	     * @return the property (int)
	     */
	    public int getProperty() {
	        return property;
	    }
	}
	/**
	 * Gets the property of the node
	 * @param p - The position of the node
	 * @return - the property
	 */
	public int getProperty(Position<Entry<K, V>> p) {
	    if (p == null) {
	        return 0;
	    }
	    BSTNode<Entry<K, V>> node = (BSTNode<Entry<K, V>>) p;
	    return node.getProperty();
	}
	/**
	 * Sets the property of the node
	 * @param p - the position of the node
	 * @param value - the value of the node
	 */
	public void setProperty(Position<Entry<K, V>> p, int value) {
	    BSTNode<Entry<K, V>> node = (BSTNode<Entry<K, V>>) (p);
	    node.setProperty(value);
	}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// All the methods below delegate to the BalanceableBinaryTree class, which extends 
	// your linked binary tree implementation
	/////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Position<Entry<K, V>> root() {
		return tree.root();
	}
	
	@Override
	public Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
		return tree.parent(p);
	}
	
	@Override
	public int numChildren(Position<Entry<K, V>> p) {
		int size = 0;
		if (left(p) != null && left(p).getElement() != null)
		{
			size++;
		}
		if (right(p) != null && right(p).getElement() != null)
		{
			size++;
		}
		return size;
	}
	
	@Override
	public boolean isInternal(Position<Entry<K, V>> p) {
		
		return tree.isInternal(p);
	}
	@Override
	public Iterable<Position<Entry<K, V>>> children(Position<Entry<K, V>> p) {
		return tree.children(p);
	}
	/**
	 * Sets the node
	 * @param p - the position of the node
	 * @param entry - the entry of the node
	 * @return - the entry of the node
	 */
	public Entry<K, V> set(Position<Entry<K, V>> p, Entry<K, V> entry) {
		return tree.set(p, entry);
	}
	
	@Override
	public boolean isLeaf(Position<Entry<K, V>> p) {
		return tree.isLeaf(p);
	}
	
	@Override
	public boolean isRoot(Position<Entry<K, V>> p) {
		return tree.isRoot(p);
	}
	
	@Override
	public Iterable<Position<Entry<K, V>>> preOrder() {
		return tree.preOrder();
	}
	
	@Override
	public Iterable<Position<Entry<K, V>>> postOrder() {
		return tree.postOrder();
	}
	
	@Override
	public Iterable<Position<Entry<K, V>>> levelOrder() {
		return tree.levelOrder();
	}
	
	@Override
	public Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
		return tree.left(p);
	}
	/**
	 * Removes the node
	 * @param p - The position of the node
	 * @return The node entry
	 */
	protected Entry<K, V> remove(Position<Entry<K, V>> p) {
		return tree.remove(p);
	}
	
	@Override
	public Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
		return tree.right(p);
	}
	
	@Override
	public Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
		return tree.sibling(p);
	}
	
	@Override
	public Iterable<Position<Entry<K, V>>> inOrder() {
		return tree.inOrder();
	}
	/**
	 * Rotates the node
	 * @param p - the position of the node
	 */
	protected void rotate(Position<Entry<K, V>> p) {
		tree.rotate(p);
	}
	/**
	 * Restructures the node
	 * @param x - The position of the node
	 * @return - the new position of the node
	 */
	protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
		return tree.restructure(x);
	}
	/**
	 * Returns the property of the node 
	 * @param p - The position of the node
	 * @return the property
	 */
	public int getProperty(Position<Entry<K, V>> p) {
		return tree.getProperty(p);
	}
	/**
	 * Sets the property of the node
	 * @param p - The position of the node 
	 * @param value - The value of the node
	 */
	public void setProperty(Position<Entry<K, V>> p, int value) {
		tree.setProperty(p, value);
	}
}