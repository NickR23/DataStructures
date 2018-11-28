package edu.ncsu.csc316.dsa.priority_queue;

/**
 * Adaptable interface
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V> {
	/**
	 * Remove entry
	 * @param entry - entry to be removed
	 */
    void remove(Entry<K, V> entry);
    /**
     * Replace key
     * @param entry - entry to have key replaced
     * @param key - new key
     */
    void replaceKey(Entry<K, V> entry, K key);
    /**
     * Replace value
     * @param entry - entry to have value replaced
     * @param value - new value
     */
    void replaceValue(Entry<K, V> entry, V value);   
}