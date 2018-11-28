package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * HeapPriorityQueue
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class HeapPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

    // Remember that heaps can be easily implemented using an internal array representation
    // versus a linked representation.
	/**
	 * List
	 */
    protected ArrayBasedList<Entry<K, V>> list;
    /**
     * Constructor
     * @param comparator - comparator
     */
    public HeapPriorityQueue(Comparator<K> comparator) {
        super(comparator);
        list = new ArrayBasedList<Entry<K, V>>();
    }
    /**
     * No-arg constructor
     */
    public HeapPriorityQueue() {
        this(null);
    }
    
    //////////////////////////////////////////////////
    // Convenience methods to help abstract the math
    // involved in jumping to parent or children
    //////////////////////////////////////////////////
    /**
     * Gives the index of the parent
     * @param index - index of the child
     * @return the index of the parent
     */
    protected int parent(int index) {
        return (index - 1) / 2;
    }
    /**
     * Gives the index of the left child
     * @param index - the parent
     * @return the left child
     */
    protected int left(int index) {
        return (2 * index) + 1;
    }
    /**
     * Gives the index of the right child
     * @param index - the parent
     * @return the right child
     */
    protected int right(int index) {
        return (2 * index) + 2;
    }
    /**
     * Checks if there's a left child
     * @param index - the parent
     * @return a boolean
     */
    protected boolean hasLeft(int index) {
        return left(index) < list.size();
    }
    /**
     * Checks if there's a right child
     * @param index - the parent
     * @return a boolean
     */
    protected boolean hasRight(int index) {
        return right(index) < list.size();
    }

    //////////////////////////////////////////
    // ADT Operations
    //////////////////////////////////////////
    
    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> temp = createEntry(key, value);
        list.add(list.size(), temp);
        upHeap(list.size() - 1);
        return temp;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Entry<K, V> deleteMin() {
        if (list.isEmpty()) {
            return null;
        }
        Entry<K, V> hold = list.get(0);
        swap(0, list.size() - 1);
        list.remove(size() - 1);
        downHeap(0);
        return hold;
    }

    @Override
    public int size() {
        return list.size();
    }

    //////////////////////////////////////////////
    // Bubbling Operations (up heap, down heap)
    //////////////////////////////////////////////
    /**
     * Upheaps
     * @param index - index to be upheaped
     */
    protected void upHeap(int index) {
    		if (index > 0 && (compare(list.get(parent(index)).getKey() , list.get(index).getKey()) > 0))
    		{
			swap(parent(index), index);
			upHeap(parent(index));
    		}
    }
    /**
     * Downheaps
     * @param index - index to be downheaped
     */
    protected void downHeap(int index) {
    		int i = 0;
    		if (hasRight(index) && hasLeft(index))
    		{
    			if (compare(list.get(right(index)).getKey() , list.get(left(index)).getKey()) <= 0)
    			{
    				i = right(index);
    			}
    			else
    			{
    				i = left(index);
    			}
    		}
    		
    		else if (hasLeft(index) && !hasRight(index))
		{
			i = left(index);
		}
    		
    		
    		if (i > 0 && compare(list.get(index).getKey(), list.get(i).getKey()) > 0)
    		{
    			swap(index, i);
    			downHeap(i);
    		}
    }
    	/**
    	 * swaps
    	 * @param index1 - index to be swapped
    	 * @param index2 - index to be swapped
    	 */
    protected void swap(int index1, int index2) {
        Entry<K, V> temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}