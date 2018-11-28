/**
 * 
 */
package edu.ncsu.csc316.dsa.stack;

/**AbstractStack.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public abstract class AbstractStack<E> implements Stack<E> {
	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

}
