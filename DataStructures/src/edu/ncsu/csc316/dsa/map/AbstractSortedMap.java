package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;

/**
 * AbstractSortedMap
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public abstract class AbstractSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    private Comparator<K> compare;
    /**
     * Constructor
     * @param compare - comparator
     */
    public AbstractSortedMap(Comparator<K> compare) {
        if (compare == null) {
            this.compare = new NaturalOrder();
        } else {
            this.compare = compare;
        }
    }
    /**
     * Compares keys based on camparator
     * @param key1 - key 1
     * @param key2 - key 2
     * @return - An integer value comparing key 1 and key 2.
     */
    public int compare(K key1, K key2) {
        return compare.compare(key1, key2);
    }
    /**
     * Default comparator class. Natural order.
     * @author nicholasrrichardson
     *
     */
    private class NaturalOrder implements Comparator<K> {
        public int compare(K first, K second) {
            return ((Comparable<K>) first).compareTo(second);
        }
    }
}