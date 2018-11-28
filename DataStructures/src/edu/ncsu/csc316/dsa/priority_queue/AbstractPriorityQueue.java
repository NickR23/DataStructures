package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

/**
 * PriorityQueue abstraction
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public abstract class AbstractPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Comparator<K> comparator;
    /**
     * Constructor
     * @param c the comparator
     */
    public AbstractPriorityQueue(Comparator<K> c) {
        setComparator(c);
    }
    
    private void setComparator(Comparator<K> c) {
        if(c == null) {
            c = new NaturalOrder();
        }
        comparator = c;
    }
    /**
     * Natural order comparator
     * @author nicholasrrichardson
     *
     */
    public class NaturalOrder implements Comparator<K> {
	    	/**
	    	 * Compare
	    	 * @return comparison
	    	 * @param first - value to be compared
	    	 * @param second - value to be compared
	    	 */
        public int compare(K first, K second) {
            return ((Comparable<K>) first).compareTo(second);
        }
    }
    /**
     * Compares
     * @param data1 - first value to be compared
     * @param data2 - second value to be compared
     * @return the comparison
     */
    public int compare(K data1, K data2) {
        return comparator.compare(data1, data2);
    }
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // Make sure you import PriorityQueue.Entry and NOT Map.Entry!
    /**
     * Entry class
     * @author nicholasrrichardson
     *
     * @param <K> - generic key class
     * @param <V> - generic value class
     */
    public static class PQEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;
        /**
         * Constructor
         * @param key - key
         * @param value - value
         */
        public PQEntry(K key, V value) {
            setKey(key);
            setValue(value);
        }
        /**
         * Sets the key
         * @param key - new key
         */
        public void setKey(K key) {
            this.key = key;
        }
        /**
         * Sets the value
         * @param value - new value
         */
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
    
    // factory method for constructing a new priority queue entry object
    /**
     * Makes a new priority queue entry
     * @param key - key 
     * @param value - value
     * @return the created entry
     */
    protected Entry<K, V> createEntry(K key, V value) {
        return new PQEntry<K, V>(key, value);
    }
}
