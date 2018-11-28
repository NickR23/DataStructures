package edu.ncsu.csc316.dsa.queue;

/**Queue interface.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public interface Queue<E> {
	/**
	 * Puts a new value in the queue.
	 * @param value - The value to be added to the queue.
	 */
	void enqueue(E value);
	/**
	 * Removes the front of the queue.
	 * @return The front of the queue.
	 */
	E dequeue();
	/**
	 * The front element of the queue.
	 * @return The front element.
	 */
	E front();
	/**
	 * Returns the size of the queue.
	 * @return The size of the queue.
	 */
	int size();
	/**
	 * Returns the occupation of the queue.
	 * @return True if the queue is empty, vice-versa.
	 */
	boolean isEmpty();
}
