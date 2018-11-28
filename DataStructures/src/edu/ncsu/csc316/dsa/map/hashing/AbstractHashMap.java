package edu.ncsu.csc316.dsa.map.hashing;

import java.util.Random;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.map.AbstractMap;
/**
 * Provides common functionality for hashMaps
 * @author nicholasrrichardson
 *
 * @param <K> key - generic key class
 * @param <V> value - generic value class
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

    // An initial capacity for the hash table
	/**
	 * Default capacity for the table
	 */
    protected static final int DEFAULT_CAPACITY = 17;
    
    // From our discussion in class, the expected number of probes
    // for separate chaining remains relatively the same no matter
    // what the load factor may be. However, for linear probing, to
    // reduce the chance of having large clusters, we will resize
    // when the load factor reaches 0.5
    private static final double MAX_LOAD_FACTOR = 0.5;
    
    /** 
     * Define a default prime number for our compression strategy
     */
    protected static final int DEFAULT_PRIME = 109345121;
    
    // Alpha and Beta values for MAD compression
    // This implementation uses a variation of the MAD method
    // where h(k) = ( (alpha * f(k) + beta) % DEFAULT_PRIME) % capacity
    private long alpha;
    private long beta;
    /***
     * Constructor
     * @param capacity - initial capacity of the hashMap
     */
    public AbstractHashMap(int capacity) {
        Random rand = new Random();
        // Generate a random alpha value (cannot be 0)
        alpha = rand.nextInt(DEFAULT_PRIME - 1) + 1;
        // Generate a random beta value
        beta = rand.nextInt(DEFAULT_PRIME);
        createTable(capacity);
    }
    /**
     * No-arg constructor
     */
    public AbstractHashMap() {
        this(DEFAULT_CAPACITY);
    }
    
    private int compress(K key) {
        return (int)((Math.abs(key.hashCode() * alpha + beta) % DEFAULT_PRIME) % capacity());
    }

    @Override
    public V put(K key, V value) {
        V ret = bucketPut(compress(key), key, value);
        if( (double)size() / capacity() > MAX_LOAD_FACTOR){
            resize(2 * capacity() + 1);
        }
        return ret;
    }
    
    @Override
    public V get(K key) {
        return bucketGet(compress(key), key);
    }

    @Override
    public V remove(K key) {
        return bucketRemove(compress(key), key);
    }
    
    private void resize(int newCapacity) {
        List<Entry<K, V>> list = new ArrayBasedList<Entry<K, V>>();
        for(Entry<K, V> entry : entrySet()) {
            list.addLast(entry);
        }
        createTable(newCapacity);
        for(Entry<K, V> entry : list) {
            put(entry.getKey(), entry.getValue());
        }
    }
    /**
     * Abstract method.
     * @return the capacity of the hashTable
     */
    protected abstract int capacity();
    /**
     * Make a table
     * @param capacity - The initial capacity of the table
     */
    protected abstract void createTable(int capacity);
    /**
     * Gets the element from the bucket
     * @param hash - the hash of the element
     * @param key - the key of the element
     * @return - the value of the element
     */
    protected abstract V bucketGet(int hash, K key);
    /**
     * Puts an element into the bucket
     * @param hash - the hash of the element
     * @param key - the key of the element
     * @param value - the value of the element
     * @return - the value of the element
     */
    protected abstract V bucketPut(int hash, K key, V value);
    /**
     * Removes the element from the bucket
     * @param hash - the hash of the bucket
     * @param key - the key of the element
     * @return - the value of the element to be removed
     */
    protected abstract V bucketRemove(int hash, K key);
}