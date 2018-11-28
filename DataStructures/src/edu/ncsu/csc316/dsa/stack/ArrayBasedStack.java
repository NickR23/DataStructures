/**
 * 
 */
package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/** ArrayBasedStack
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class ArrayBasedStack<E> extends AbstractStack<E> {
	private ArrayBasedList<E> list;
	/**
	 * Constructor.
	 */
	public ArrayBasedStack() {
		list = new ArrayBasedList<E>();
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(E value) {
		list.addLast(value);
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#pop()
	 */
	@Override
	public E pop() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return list.removeLast();
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#top()
	 */
	@Override
	public E top() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return list.last();
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#size()
	 */
	@Override
	public int size() {
		return list.size();
	}

}
