/**
 * 
 */
package edu.ncsu.csc316.dsa.queue;

/**AbstractQueue.
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */
public abstract class AbstractQueue<E> implements Queue<E> {

	/* (non-Javadoc)
	 * @see edu.ncsu.csc316.dsa.queue.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

}
