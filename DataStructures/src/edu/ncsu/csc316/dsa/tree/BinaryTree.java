package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Interfacing for BinaryTree
 * @author nicholasrrichardson
 *
 * @param <E> - Generic element class
 */
public interface BinaryTree<E> extends Tree<E> {
	/**
	 * Gives the position to the left
	 * @param p - specified position
	 * @return - a position
	 */
    Position<E> left(Position<E> p);
    /**
     * Gives position to the right of the position
     * @param p - specified position
     * @return a position
     */
    Position<E> right(Position<E> p);
    /**
     * Gives positions on the same level
     * @param p - a specified position
     * @return a position
     */
    Position<E> sibling(Position<E> p);
    /**
     * Gives an in order iterable
     * @return an iterable
     */
    Iterable<Position<E>> inOrder();
}