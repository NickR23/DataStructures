package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Generic Tree Interface
 * @author nicholasrrichardson
 * @param <E> - Generic Value class
 */
public interface Tree<E> {
	/**
	 * Returns the root of the tree
	 * @return the root
	 */
    Position<E> root();
    /**
     * Returns the parent position
     * @param p - the current position
     * @return the parent of that node
     */
    Position<E> parent(Position<E> p);
    /**
     * Returns a list of the children positions
     * @param p - a position
     * @return the children of that position
     */
    Iterable<Position<E>> children(Position<E> p);
    /**
     * Gets the number of children
     * @param p - a node
     * @return int children of the node
     */
    int numChildren(Position<E> p);
    /**
     * Decides if the position is internal
     * @param p - a node
     * @return - true if that node is internal
     */
    boolean isInternal(Position<E> p);
    /**
     * Decides if the position is a leaf
     * @param p - a node
     * @return - true if that node is a leaf
     */
    boolean isLeaf(Position<E> p);
    /**
     * Decides if the position is a root
     * @param p - a node
     * @return - true if that node is a leaf
     */
    boolean isRoot(Position<E> p);
    /**
     * Gets the size
     * @return size
     */
    int size();
    /**
     * Decides if empty
     * @return true if empty
     */
    boolean isEmpty();
    
    // We will also add the following traversals to our Tree interface
    /**
     * Provides a list in preOrder
     * @return a list
     */
    Iterable<Position<E>> preOrder();
    /**
     * Provides a list in postOrder
     * @return a list
     */
    Iterable<Position<E>> postOrder();
    /**
     * Provides a list in levelOrder
     * @return a list
     */
    Iterable<Position<E>> levelOrder();
}
