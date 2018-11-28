/**
 * 
 */
package edu.ncsu.csc316.dsa.list;

/** Generic List Interface.
 * @author nicholasrrichardson
 * @param <E> generic class.
 */
public interface List<E> extends Iterable<E> {
	/**
	 * Adds to the list.
	 * @param x - position to add.
	 * @param object element to be added.
	 */
	public void add(int x, E object);
	/**
	 * Adds to the beginning of the list.
	 * @param object - Element to be added.
	 */
	public void addFirst(E object);
	/**
	 * Adds to the tail of the list.
	 * @param object - Element to be added.
	 */
	public void addLast(E object);
	/**
	 * Returns the first element of the list.
	 * @return The first element.
	 */
	public E first();
	/**
	 * Returns the element at the specified index of the list.
	 * @param index - Specified index position.
	 * @return The element to be added.
	 */
	E get(int index);
	/**
	 * Returns the state of the list.
	 * @return a boolean
	 */
	boolean isEmpty();
	/**
	 * Return the last element of the list.
	 * @return The last element.
	 */
	public E last();
	/**
	 * Remove the element at the specified index.
	 * @param index - The index of the element.
	 * @return The element removed.
	 */
	public E remove(int index);
	/**
	 * Remove the first element in the list.
	 * @return return the removed element.
	 */
	public E removeFirst();
	/**
	 * Remove the last element in the list.
	 * @return the removed element.
	 */
	public E removeLast();
	/**
	 * Change the value of an element in the list.
	 * @param index - the index of the element.
	 * @param value - the new value.
	 * @return the old value.
	 */
	public E set(int index, E value);
	/**
	 * Return the size of the list.
	 * @return the size of the list.
	 */
	public int size();
}
