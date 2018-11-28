package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * BinaryTreeCollection interface
 * @author nicholasrrichardson
 *
 * @param <E> - A generic element class
 */
public interface BinaryTreeCollection<E> extends BinaryTree<E>, Iterable<E> {
	/**
	 * adds a root
	 * @param value - value of the root
	 * @return - the position of the new root
	 */
    Position<E> addRoot(E value);
    /**
     * adds to the left of the position
     * @param p - a specified position
     * @param value - value to be stored in the position
     * @return the position of the added node
     */
    Position<E> addLeft(Position<E> p, E value);
    /**
     * adds to the right of the position
     * @param p - a specified position
     * @param value - value to be stored in a position
     * @return the position of the new node
     */
    Position<E> addRight(Position<E> p, E value);
    /**
     * removes the specified node
     * @param p - the position of the node
     * @return the value of the removed node
     */
    E remove(Position<E> p);
    /**
     * modifies the value of the specified node
     * @param p - the position of the node to be modified
     * @param value - the new value for the node
     * @return the old value
     */
    E set(Position<E> p, E value);
}