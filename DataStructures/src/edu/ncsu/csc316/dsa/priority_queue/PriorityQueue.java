package edu.ncsu.csc316.dsa.priority_queue;
/**
 * PriorityQueue
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public interface PriorityQueue<K, V> {
	/**
	 * Entry class
	 * @author nicholasrrichardson
	 *
	 * @param <K> - generic key class
	 * @param <V> - generic value class
	 */
    interface Entry<K, V> {
	    	/**
	    	 * Gives the key
	    	 * @return the key
	    	 */
        K getKey();
        /**
         * Gives the value
         * @return the value
         */
        V getValue();
    }
    /**
     * Inserts the key value
     * @param key - the key
     * @param value - the value
     * @return the entry inserted
     */
    Entry<K, V> insert(K key, V value);
    /**
     * Returns the minimum entry
     * @return the min entry
     */
    Entry<K, V> min();
    /**
     * Removes the minimum entry
     * @return the minimum entry removed
     */
    Entry<K, V> deleteMin();
    /**
     * Gives the size
     * @return the size
     */
    int size();
    /**
     * Decides if empty
     * @return boolean
     */
    boolean isEmpty();
}