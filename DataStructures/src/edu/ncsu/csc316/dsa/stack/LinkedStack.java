/**
 * 
 */
package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList;

/** LinkedStack.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class LinkedStack<E> extends AbstractStack<E> {
	private FrontSinglyLinkedList<E> list;
	/**
	 * Constructor.
	 */
	public LinkedStack() {
		list = new FrontSinglyLinkedList<E>();
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(E value) {
		list.addFirst(value);
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
		return list.removeFirst();
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
		return list.first();
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.stack.Stack#size()
	 */
	@Override
	public int size() {
		return list.size();
	}
}
