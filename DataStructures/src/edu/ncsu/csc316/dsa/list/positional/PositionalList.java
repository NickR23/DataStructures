/**
 * 
 */
package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;

/**PositionalList interface.
 * @author nicholasrrichardson
 * @param <E> - Element at the position.
 */
public interface PositionalList<E> extends Iterable<E> {
	/**
	 * Adds after the position.
	 * @param p - position to be added.
	 * @param value - Value to be added.
	 * @return A position.
	 */
    Position<E> addAfter(Position<E> p, E value);
	/**
	 * Before after the position.
	 * @param p - position to be added.
	 * @param value - Value to be added.
	 * @return A position.
	 */
    Position<E> addBefore(Position<E> p, E value);
	/**
	 * Adds to the beginning of the list.
	 * @param value - Value to be added.
	 * @return A position.
	 */
    Position<E> addFirst(E value);
	/**
	 * Adds to the end of the list.
	 * @param value - Value to be added.
	 * @return A position.
	 */
    Position<E> addLast(E value);
	/**
	 * Gets the position after.
	 * @param p  - The position.
	 * @return A position.
	 */
    Position<E> after(Position<E> p);
	/**
	 * Gets the position before.
	 * @param p - The position.
	 * @return A position.
	 */
    Position<E> before(Position<E> p);
	/**
	 * Gets the first position.
	 * @return A position.
	 */
    Position<E> first();
	/**
	 * Gets the status of the list.
	 * @return A boolean
	 */
    boolean isEmpty();
	/**
	 * Gets the last position.
	 * @return A position.
	 */
    Position<E> last();
	/**
	 * Creates an iterator for the list.
	 * @return An iterator
	 */
    Iterable<Position<E>> positions();
	/**
	 * Removes the value at the position.
	 * @param p The position for removal.
	 * @return The value removed.
	 */
    E remove(Position<E> p);
	/**
	 * Modifies the value at the position.
	 * @param p - The position.
	 * @param value - The new value.
	 * @return The value removed.
	 */
    E set(Position<E> p, E value);
    /**
     * Returns the size of the array.
     * @return The size of the array.
     */
    int size();
}
