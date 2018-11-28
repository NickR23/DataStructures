package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Defines Tree modification procedures.
 * @author nicholasrrichardson
 *
 * @param <E> - Generic value class
 */
public interface GeneralTreeCollection<E> extends Tree<E>, Iterable<E> {
	/**
	 * adds a root
	 * @param value - value to be made a root
	 * @return the position of the new root
	 */
    Position<E> addRoot(E value);
    /**
     * adds a child
     * @param p - the position for adding the child
     * @param value - the child to be added
     * @return the position of the child
     */
    Position<E> addChild(Position<E> p, E value);
    /**
     * removes a node
     * @param p - the position of the node
     * @return the value stored in the node
     */
    E remove(Position<E> p);
    /**
     * modifies the value of a node
     * @param p - position for modification
     * @param value - the new value
     * @return the old value
     */
    E set(Position<E> p, E value);
}