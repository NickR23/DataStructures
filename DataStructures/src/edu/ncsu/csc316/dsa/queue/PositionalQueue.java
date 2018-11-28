/**
 * 
 */
package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;

/**PositionalQueue
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class PositionalQueue<E> extends AbstractQueue<E> {
	private PositionalLinkedList<E> list;
	/**
	 * Constructor.
	 */
	public PositionalQueue(){
		list = new PositionalLinkedList<E>();
	}
	
	@Override
	public void enqueue(E value) {
		list.addLast(value);
	}

	@Override
	public E dequeue() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return list.remove(list.first());
	}

	@Override
	public E front() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return list.first().getElement();
	}

	@Override
	public int size() {
		return list.size();
	}
	
}
