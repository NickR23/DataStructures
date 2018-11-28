/**
 * 
 */
package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

/**generic map interface
 * @author nicholasrrichardson
 * @param <V> - generic value class
 * @param <K>- generic key class
 */
public interface Map<K, V> extends Iterable<K> {
	/**
	 * Returns an iterable set of the values.
	 * @return a set of values
	 */
	    Iterable<Entry<K, V>> entrySet();
	    /**
	     * gets a value based on provided key
	     * @param key - key for value
	     * @return the value
	     */
	    V get(K key);
	    /**
	     * true if the map is empty
	     * @return a boolean
	     */
	    boolean isEmpty();
	    /**
	     * Creates an iterator for the map
	     * @return an iterator 
	     */
	    Iterator<K> iterator();
	    /**
	     * puts a value and key pair into the map
	     * @param key - provided key
	     * @param value - provided value
	     * @return the value
	     */
	    V put(K key, V value);
	    /**
	     * removes the value
	     * @param key - the key of the value
	     * @return the value removed
	     */
	    V remove(K key);
	    /**
	     * the size of the map
	     * @return the size
	     */
	    int size();
	    /**
	     * gives an iterator over the values
	     * @return an iterator
	     */
	    Iterable<V> values();
	    /**
	     * The class for the individual entries to the map
	     * @author nicholasrrichardson
	     *
	     * @param <K> - generic key class
	     * @param <V> - generic value class
	     */
	    interface Entry<K, V> {
		    	/**
		    	 * gets the key of the entry
		    	 * @return the key
		    	 */
	        K getKey();
	        /**
	         * gets the value of the entry 
	         * @return the value
	         */
	        V getValue();
	        /**
	         * sets the key of the entry
	         * @param key - the key 
	         * @return the old key
	         */
	        K setKey(K key);
	        /**
	         * Sets the value of the entry
	         * @param value - the new value of the entry
	         * @return the old value
	         */
	        V setValue(V value);
	    }
	

}
