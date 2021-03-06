/**
 * 
 */
package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;


/** Circularly linked list implementation.
 * @author nicholasrrichardson
 * @param <E> - Generic class.
 */
public class CircularlyLinkedList<E> extends AbstractLinkedList<E> {
	private int size;
	private LinkedListNode<E> front;
	/**
	 * Constructor.
	 */
	public CircularlyLinkedList()
	{
		this.size = 0;
		this.front = new LinkedListNode<E>(null, null);
	}
	@Override
	public void add(int x, E object) {
		checkIndexForAdd(x);
		if (isEmpty())
		{
			front.setNext(new LinkedListNode<E>(object, front));
		}
		else if (x == 0)
		{
			LinkedListNode<E> newNode = new LinkedListNode<E>(object, front.getNext());
			front.setNext(newNode);
		}
		else if (x  == size + 1)
		{
			LinkedListNode<E> p = front;
			while (p.getNext() != front)
			{
				p = p.getNext();
			}
			p.setNext(new LinkedListNode<E>(object, front));
		}
		else
		{
			LinkedListNode<E> p = front.getNext();
			for(int i = 0; i < x - 1; i++)
			{
				p = p.getNext();
			}
			p.setNext(new LinkedListNode<E>(object, p.getNext()));
		}
		size++;		
	}

	@Override
	public E remove(int index) {
		E value;
		checkIndex(index);
		if (index == 0)
		{
			value = front.getNext().getElement();
			front.setNext(front.getNext().getNext());
		}
		else if (index  == size - 1)
		{
			LinkedListNode<E> p = front.getNext();
			LinkedListNode<E> q = front;
			while (p.getNext() != front)
			{
				p = p.getNext();
				q = q.getNext();
			}
			value = p.getElement();
			q.setNext(p.getNext());
		}
		else
		{
			LinkedListNode<E> p = front.getNext();
			for(int i = 0; i < index - 1; i++)
			{
				p = p.getNext();
			}
			value = p.getNext().getElement();
			p.setNext(p.getNext().getNext());
		}
		size--;
		return value;
	}

	@Override
	public E set(int index, E value) {
		E hold;
		LinkedListNode<E> p = front.getNext();
		for(int i = 0; i < index; i++)
		{
			p = p.getNext();
		}
		hold = p.getElement();
		p.setElement(value);
		return hold;
	}

	@Override
	public int size() {
		return size;
	}
	/**
	 * Iterator class.
	 * @author nicholasrrichardson
	 * 
	 */
	private class ElementIterator extends AbstractElementIterator {
		
		public ElementIterator(LinkedListNode<E> start) {
			super(start);
		}
		@Override

		public void remove()
		{
			if (removeOk)
			{			
				if (previousPrevious == null)
				{
					previous.setNext(current.getNext());
				}
				else
				{
					previousPrevious.setNext(previous.getNext());
				}
				previous = previousPrevious;
				
				
			}
			size--;
			removeOk = false;
		
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front);
	}

}
