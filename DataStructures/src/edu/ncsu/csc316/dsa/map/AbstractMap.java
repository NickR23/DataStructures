package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

/**
 * AbstractMap class
 * @author nicholasrrichardson
 * @param <K>
 * @param <V>
 *
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * Map entry class.
     * @author nicholasrrichardson
     *
     * @param <K> - generic key class 
     * @param <V> - generic value class
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;
        /**
         * constructor
         * @param key - key
         * @param value - value
         */
        public MapEntry(K key, V value) {
            setKey(key);
            setValue(value);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        /**
         * setKey
         * @param key - key
         * @return key
         */
        public K setKey(K key) {
            this.key = key;
            return this.key;
        }

        @Override
        public V setValue(V value) {
            V original = this.value;
            this.value = value;
            return original;
        }
    }
    /**
     * KeyIterator
     * @author nicholasrrichardson
     *
     */
    protected class KeyIterator implements Iterator<K> {

        private Iterator<Entry<K, V>> it;
        /**
         * Constructor
         * @param iterator - iterator of the map
         */
        public KeyIterator(Iterator<Entry<K, V>> iterator) {
            it = iterator;
        }
        
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public K next() {
            return it.next().getKey();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported yet.");
        }

    }
    /**
     * ValueIterator
     * @author nicholasrrichardson
     *
     */
    protected class ValueIterator implements Iterator<V> {

        private Iterator<Entry<K, V>> it;
        /**
         * Constructor
         * @param iterator - iterator of the map
         */
        public ValueIterator(Iterator<Entry<K, V>> iterator) {
            it = iterator;
        }
        
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public V next() {
            return it.next().getValue();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported yet.");
        }

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public Iterator<K> iterator() {
    		return new KeyIterator(entrySet().iterator());
    }
    
    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }
    /**
     * ValueIterator
     * @author nicholasrrichardson
     *
     */
    private class ValueIterable implements Iterable<V> {

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator(entrySet().iterator());
        }
    }
    
}