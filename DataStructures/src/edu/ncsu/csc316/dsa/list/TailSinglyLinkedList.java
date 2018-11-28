package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;

/** Tail SinglyLinkedList.
 * @author nicholasrrichardson
 * @param <E> - Generic class.
 */
public class TailSinglyLinkedList<E> extends AbstractLinkedList<E> {
	
	private int size;
	private LinkedListNode<E> front;
	private LinkedListNode<E> tail;

	
	/**
	 * Constructor.
	 */
	public TailSinglyLinkedList()
	{
		size = 0;
		//Dummy node.
		front = new LinkedListNode<E>(null);
		tail = null;
	}
	
	@Override
	public void add(int x, E object) {
		checkIndexForAdd(x);
		if (x == 0)
		{
			front.setNext(new LinkedListNode<E>(object, front.getNext()));
			if(front.getNext().getNext() == null)
			{
				tail = front.getNext();
			}
		}
		else if (x == size)
		{
			tail.setNext(new LinkedListNode<E>(object, null));
			tail = tail.getNext();
		}
		else
		{
			//System.out.println(object);
			LinkedListNode<E> p = front;
			for (int i = 0; i < x; i++)
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
			LinkedListNode<E> p = front;
			while (p.getNext() != null && p.getNext() != tail)
			{
				p = p.getNext();
			}
			
			tail = p;
			value = p.getNext().getElement();
			p.setNext(null);
		}
		else
		{
			LinkedListNode<E> p = front.getNext();
			for(int i = 0; i < index; i++)
			{
				p = p.getNext();
			}
			value = p.getElement();
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
