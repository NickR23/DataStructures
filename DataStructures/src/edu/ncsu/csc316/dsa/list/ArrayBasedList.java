/**
 * 
 */
package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;

/** Array based list implementation.
 * @author nicholasrrichardson
 * @param <E> - Generic class.
 *	
 */
public class ArrayBasedList<E> extends AbstractList<E> {
	
	private E[] data;
	private int size;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * No-arg Constructor.
	 * Calls the int constructor.
	 */
	public ArrayBasedList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Int constructor.
	 * 
	 * @param initialCapacity - Sets the initial size of the list.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int initialCapacity)
	{
		data = (E[])(new Object[initialCapacity]);
		this.size = 0;
	}
	private void ensureCapacity(int newSize)
	{
		if ( (size + 1) == data.length)
		{
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])(new Object[newSize]);
			for(int i = 0; i < data.length; i++)
			{
				newArray[i] = data[i];
			}
			data = newArray;
		}
	}
	
	/**
	 * Creates an iterator.
	 * @return iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	/**
	 * Inner iterator class.
	 * @author nicholasrrichardson
	 *
	 */
	private class ElementIterator implements Iterator<E> {
		private int position;
		private boolean removeOK;
		

		public ElementIterator()
		{
			position = 0;
			removeOK = false;
		}

		public boolean hasNext()
		{
			boolean result = true;
			if(data[position] == null)
			{
				result = false;
			}
			return result;
		}
		public E next()
		{
			E hold = data[position];
			position++;
			removeOK = true;
			return hold;
		}
		public void remove()
		{
			if (removeOK)
			{
				position--;
				data[position] = null;
				for(int i = position; i < size; i++)
				{
					data[i] = data[i + 1];
				}
				size--;

			}
			removeOK = false;
		}
	}
	
	/**
	 * Adds an element to the specified index.
	 * @param index - Denotes the location for addition.
	 * @param object - Element to be added.
	 */
	public void add(int index, E object) {
		checkIndexForAdd(index);
		/**
		 * If the array is full, create a new, bigger array.
		 */
		ensureCapacity((data.length * 2) + 1);
		
		for(int i = size - 1; i >= index; i--)
		{
			data[i + 1] = data[i];
		}
		data[index] = object;
		size++;
	}


	/**
	 * Returns the element at the specified index.
	 * @param index - The location of the element to be returned.
	 * @return The element at the index.
	 */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}


	/**
	 * Removes the element at the specified index.
	 * @param index - The position of the element to be removed.
	 * @return The element that was removed.
	 */
	public E remove(int index) {
		checkIndex(index);
		E hold = data[index];
		data[index] = null;
		for(int i = index; i < size; i++)
		{
			data[i] = data[i + 1];
		}
		size--;
		return hold;
	}

	/**
	 * Modifies the specified element.
	 * @param index - The position of the element to be modified.
	 * @param value - The new value of the element to be modified.
	 * @return The original value of the modified element.
	 */
	public E set(int index, E value) {
		checkIndex(index);
		E hold = data[index];
		data[index] = value;
		return hold;
	}

	/**
	 * Returns the size of the array.
	 * @return size.
	 */
	public int size() {
		return size;
	}


}
