/**
 * 
 */
package edu.ncsu.csc316.dsa.stack;

/** Stack interface.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public interface Stack<E> {
	/**
	 * Pushes the element onto the stack
	 * @param value - The element.
	 */
	void push(E value);
	/**
	 * Pops the top element off of the stack.
	 * @return The element popped.
	 */
	E pop();
	/**
	 * Returns the top of the stack.
	 * @return The top of the stack.
	 */
	E top();
	/**
	 * Returns the size of the stack.
	 * @return The size.
	 */
	int size();
	/**
	 * Checks if the stack is empty.
	 * @return False if occupied, true if empty.
	 */
	boolean isEmpty();
}
