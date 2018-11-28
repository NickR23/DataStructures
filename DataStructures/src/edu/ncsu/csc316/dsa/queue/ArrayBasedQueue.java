/**
 * 
 */
package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;

/**ArrayBasedQueue
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;
    /**
     * Default capacity of the queue.
     */
    public static final int DEFAULT_CAPACITY = 10;
    /**
     * Constructor.
     * @param initialCapacity - The initial capacity of the queue.
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(int initialCapacity)
    {
        data = (E[])(new Object[initialCapacity]);
        size = 0;
    }
    /**
     * No-arg constructor.
     */
    public ArrayBasedQueue()
    {
        this(DEFAULT_CAPACITY);
    }
	@Override
	public void enqueue(E value) {
		ensureCapacity(data.length * 2 + 1);
		if(isEmpty())
		{
			data[0] = value;
			rear = 1;
			front = 0;
		}
		else
		{
			data[rear] = value;
			rear++;
			if(rear > data.length - 1)
			{
				rear = 0;
			}
		}
		size++;
	}
	@Override
	public E dequeue() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		E hold = data[front];
		data[front] = null;
		front++;
		if(front > data.length - 1)
		{
			front = data.length - 1;
		}
		size--;
		return hold;
	}
	@Override
	public E front() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return data[front];
	}
	@Override
	public int size() {
		return size;
	}
	
	private void ensureCapacity(int newSize)
	{
		if ( (size + 1) == data.length)
		{
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])(new Object[newSize]);
			int i = front;
			while(i != rear)
			{
				newArray[i] = data[i];
				if (i == data.length - 1)
				{
					i = 0;
				}
				i++;
			}
			data = newArray;
		}
	
	}
}
