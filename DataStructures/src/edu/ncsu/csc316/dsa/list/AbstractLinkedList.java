/**
 * 
 */
package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/** LinkedList abstraction.
 * @author nicholasrrichardson
 * @param <E> - Generic class.
 */
public abstract class AbstractLinkedList<E> extends AbstractList<E> {
/**
 * LinkedListNode inner class.
 * @author nicholasrrichardson
 *
 * @param <E>
 */
	protected static class LinkedListNode<E> {
		private E data;
		private LinkedListNode<E> next;
		/**
		 * Constructor.
		 * @param data - Data in the node.
		 */
		public LinkedListNode(E data)
		{
			this.data = data;
		}
		/**
		 * Constructor.
		 * @param data - Data in the node.
		 * @param next - Linked to the next node in the list.
		 */
		public LinkedListNode(E data, LinkedListNode<E> next)
		{
			this.data = data;
			this.next = next;
		}
		/**
		 * Returns the next node.
		 * @return next.
		 */
		public LinkedListNode<E> getNext()
		{
			return next;
		}
		/**
		 * Returns the element.
		 * @return data.
		 */
		public E getElement()
		{
			return data;
		}
		/**
		 * Sets the next node.
		 * @param next - The next node.
		 */
		public void setNext(LinkedListNode<E> next)
		{
			this.next = next;
		}
		/**
		 * Sets the element in the node.
		 * @param data - The new element.
		 */
		public void setElement(E data)
		{
			this.data = data;
		}
	}
	/**
	 * Abstract element iterator.
	 * @author nicholasrrichardson
	 *
	 */
	protected abstract class AbstractElementIterator implements Iterator<E> {
		LinkedListNode<E> current;
		LinkedListNode<E> previous;
		LinkedListNode<E> previousPrevious;
		boolean removeOk;
		/**
		 * Constructor.
		 * @param start - Start of the list.
		 */
		public AbstractElementIterator(LinkedListNode<E> start)
		{
			current = start.getNext();
			previous = start;
			previousPrevious = null;
			removeOk = true;
		}
		/**
		 * Returns next condition.
		 * @return boolean
		 */
		public boolean hasNext()
		{
			if(current == null)
			{
				return false;
			}
			else if (current.getElement() == null)
			{
				return false;
			}
				return current != null;
		}
		/**
		 * Returns the next element.
		 * @return next
		 */
		public E next()
		{
			E hold;
			if (current == null)
			{
				throw new NoSuchElementException();
			}
			hold = current.getElement();
			previousPrevious = previous;
			previous = current;
			current = current.getNext();
			removeOk = true;
			return hold;
		}
	}
	
	@Override
	public E get(int index) {
		Iterator<E> iter = iterator();
		int i = 0;
		E hold = null;
		while(i <= index)
		{
			hold = iter.next();
			i++;
		}
		return hold;
	}


}
