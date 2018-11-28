package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.list.FrontSinglyLinkedList;

/**LinkedQueue.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class LinkedQueue<E> extends AbstractQueue<E> {
	private FrontSinglyLinkedList<E> list;
	
	/**
	 * Constructor.
	 */
	public LinkedQueue()
	{
		list = new FrontSinglyLinkedList<E>();
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
		return list.removeFirst();
	}

	@Override
	public E front() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return list.first();
	}

	@Override
	public int size() {
		return list.size();
	}


}
