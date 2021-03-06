package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.TailSinglyLinkedList;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.search_tree.*;
/**
 * Hash map using separate chaining
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class SeparateChainingHashMap<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

    private Map<K, V>[] table;
    private int size;
    /**
     * No-arg constructor
     */
    public SeparateChainingHashMap() {
        this(AbstractHashMap.DEFAULT_CAPACITY);
    }
    /**
     * Constructor
     * @param capacity - the initial capacity of the hashMap
     */
    public SeparateChainingHashMap(int capacity) {
        super(capacity);
        size = 0;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> list = new TailSinglyLinkedList<Entry<K, V>>();
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                // Each bucket contains a map, so include
                // all entries in the entrySet for the map
                // at the current bucket
                for(Entry<K, V> entry : table[i].entrySet()) {
                    list.addLast(entry);
                }
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void createTable(int capacity) {
        // Example -- change this to whatever map you'd like
        table = (BinarySearchTreeMap<K, V>[])new BinarySearchTreeMap[capacity];
        size = 0;
    }

    @Override
    public V bucketGet(int hash, K key) {
        // Get the bucket at the specified index in the hash table
        Map<K, V> bucket = table[hash];
        // If there is no map in the bucket, then the entry does not exist
        if(bucket == null) {
            return null;
        }
        // Otherwise, delegate to the existing map's get method to return the value
        return bucket.get(key);
    }

    @Override
    public V bucketPut(int hash, K key, V value) {
        Map<K, V> bucket = table[hash];
        V val = null;
        if (bucket == null)
        {
        		table[hash] = new BinarySearchTreeMap<K, V>();
        }
        bucket = table[hash];
        if (bucket.get(key) == null)
        {
        		size++;
        }
        else
        {
        		val = bucket.get(key);
        }
        bucket.put(key, value);
        return val;
    }

    @Override
    public V bucketRemove(int hash, K key) {
        Map<K, V> bucket = table[hash];
        if (bucket != null && bucket.get(key) != null)
        {
    			size--;
        		return bucket.remove(key);
        }
        return null;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    protected int capacity() {
        return table.length;
    }
}