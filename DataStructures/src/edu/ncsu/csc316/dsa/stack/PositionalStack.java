package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;

/** Positional stack.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class PositionalStack<E> extends AbstractStack<E> {
	private PositionalLinkedList<E> list;
	/**
	 * Constructor.
	 */
	public PositionalStack()
	{
		list = new PositionalLinkedList<E>();
	}
	
	@Override
	public void push(E value) {
		list.addFirst(value);
	}

	@Override
	public E pop() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return list.remove(list.first());
	}

	@Override
	public E top() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return list.first().getElement();
	}

	@Override
	public int size() {
		return list.size();
	}

}
