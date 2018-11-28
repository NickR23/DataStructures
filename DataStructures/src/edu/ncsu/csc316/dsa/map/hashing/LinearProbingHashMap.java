package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.TailSinglyLinkedList;
/**
 * Hash map implemented with linear probing
 * @author nicholasrrichardson
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class LinearProbingHashMap<K, V> extends AbstractHashMap<K, V> {

    // This time, our array is an array of TableEntry objects
    private TableEntry<K, V>[] table;
    private int size;
    
    /**
     * No-arg constructor
     */
    public LinearProbingHashMap() {
        this(AbstractHashMap.DEFAULT_CAPACITY);
    }
    /**
     * Constructor
     * @param capacity - initial capacity of the hash map
     */
    public LinearProbingHashMap(int capacity) {
        super(capacity);
        size = 0;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> list = new TailSinglyLinkedList<Entry<K, V>>();
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null && !table[i].isDeleted()) {
                list.addLast(table[i]);
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void createTable(int capacity) {
        table = (TableEntry<K, V>[]) new TableEntry[capacity];
        size = 0;
    }
    
    // Helper method to determine whether a bucket has an entry or not
    private boolean isAvailable(int index) {
        return (table[index] == null || table[index].isDeleted());
    }

    // Helper method to find the bucket for an entry;
    // If the entry *is* in the map, returns the index of the bucket
    // If the entry is *not* in the map, returns -(a + 1) to indicate 
    //     that the entry should be added at index a
    private int findBucket(int index, K key) {
        int avail = -1;
        int j = index;
        do
        {
        		if (isAvailable(j))
        		{
        			if (avail == -1)
        			{
        				avail = j;
        			}
        			if (table[j] == null)
        			{
        				return -(avail + 1);
        			}
        		}
        		else if (table[j].getKey().equals(key))
        		{
        			return j;
        		}
        		j = (j + 1) % capacity();
        } while (j != index);
        
        return -(avail + 1);
    }    

    //If the key CANNOT be found, the helper method can instead return -(a + 1) 
    //such that the key should be added at the bucket with index a.
    @Override
    public V bucketGet(int hash, K key) {
        int index = findBucket(hash, key);
        if (index < 0 || table[index] == null || table[index].isDeleted())
        {
        		return null;
        }
        else
        {
        		return table[index].getValue();
        }
    }
    
    //If the key CANNOT be found, the helper method can instead return -(a + 1) 
    //such that the key should be added at the bucket with index a.

    @Override
    public V bucketPut(int hash, K key, V value) {
        int index = findBucket(hash, key);
        int j = index;
        V val = null;
        //If index is taken... index > 0
        if (index >= 0)
        {
        		while(table[j] != null && table[j].getKey() != key)
        		{
        			j++;
        			if(j >= capacity())
        			{
        				j %= capacity();
        			}
        		}
        		if (table[j].isDeleted())
        		{
        			size++;
        		}
        		val = table[j].getValue();
        		table[j] = new TableEntry<K, V>(key, value);
        }
        else
        {
        		size++;
        		table[-1 * (j + 1)] = new TableEntry<K, V>(key, value);
        }
        return val;
    }
    //If the key CANNOT be found, the helper method can instead return -(a + 1) 
    //such that the key should be added at the bucket with index a.
    @Override
    public V bucketRemove(int hash, K key) {
        int index = findBucket(hash, key);
        V val = null;
        //Bucket is found
        if (index >= 0)
        {
        		while(table[index] != null && table[index].getKey() != key)
        		{
        			index++;
        		}
        		if(table[index] != null && table[index].getKey() == key)
        		{
        			size--;
            		table[index].setDeleted(true);
            		val = table[index].getValue();
        		}
        	}
        else
        {
        		return null;
        }
        return val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int capacity() {
        return table.length;
    }
    
    /**
     * Table entry class
     * @author nicholasrrichardson
     *
     * @param <K> - generic key class
     * @param <V> - generic value class
     */
    private static class TableEntry<K, V> extends MapEntry<K, V> {

        private boolean isDeleted;

        public TableEntry(K key, V value) {
            super(key, value);
            setDeleted(false);
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }
    }
}
