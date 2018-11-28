package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

/**
 * HeapAdaptablePriorityQueue
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class HeapAdaptablePriorityQueue<K extends Comparable<K>, V> extends HeapPriorityQueue<K, V>
implements AdaptablePriorityQueue<K, V> {
	/**
	 * Constructor
	 * @param c - comparator
	 */
	public HeapAdaptablePriorityQueue(Comparator<K> c) {
		super(c);
	}
	/**
	 * No-arg constructor
	 */
	public HeapAdaptablePriorityQueue() {
		this(null);
	}
	
	// Adaptable PQ Entries must be location-aware so that the 
	// performance of replaceKey, replaceValue, and remove are O(log n)
	/**
	 * Adaptable entry
	 * @author nicholasrrichardson
	 *
	 * @param <K> - generic key class
	 * @param <V> - generic value class
	 */
	public static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
		
		private int index;
		/**
		 * Constructor
		 * @param key - key 
		 * @param value - value
		 * @param index - index
		 */
		public AdaptablePQEntry(K key, V value, int index) {
		    super(key, value);
		    setIndex(index);
		}
		/**
		 * Gives the index
		 * @return index
		 */
		public int getIndex() {
		    return index;
		}
		/**
		 * Sets the index
		 * @param index - the new index
		 */
		public void setIndex(int index) {
		    this.index = index;
		}
	}
	
	// Factory method for creating a new adaptable PQ entry
	@Override
	protected AdaptablePQEntry<K, V> createEntry(K key, V value) {
	// A new adaptable PQ Entry added to the heap will be at index size()
	AdaptablePQEntry<K, V> temp = new AdaptablePQEntry<K, V>(key, value, size());
	return temp;
	}
	
	// Make sure the entry is a valid Adaptable PQ Entry and is located within the heap structure
	private AdaptablePQEntry<K, V> validate(Entry<K, V> entry) {
	if(!(entry instanceof AdaptablePQEntry)){
	    throw new IllegalArgumentException("Entry is not a valid adaptable priority queue entry.");
	}
	AdaptablePQEntry<K, V> temp = (AdaptablePQEntry<K, V>)entry;
		if(temp.getIndex() >= list.size() || list.get(temp.getIndex()) != temp) {
		    throw new IllegalArgumentException("Invalid Adaptable PQ Entry.");
		}
		return temp;
	}
	
	@Override
	public void swap(int index1, int index2) {
		// Delegate to the super class swap method
		super.swap(index1, index2);
		// But then update the index of each entry so that they remain location-aware
		((AdaptablePQEntry<K, V>)list.get(index1)).setIndex(index1);
		((AdaptablePQEntry<K, V>)list.get(index2)).setIndex(index2);
	}
	
	@Override
	public void remove(Entry<K, V> entry) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		int index = temp.getIndex();
        swap(index, list.size() - 1);
        list.remove(size() - 1);
        bubble(0);
	}
	
	private void bubble(int index) {
		if(index > 0 && compare(list.get(index).getKey(), list.get(parent(index)).getKey()) < 0) {
		    upHeap(index);
		} else {
		    downHeap(index);
		}
	}
	
	@Override
	public void replaceKey(Entry<K, V> entry, K key) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		temp.setKey(key);
		bubble(temp.getIndex());
	}
	
	@Override
	public void replaceValue(Entry<K, V> entry, V value) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		temp.setValue(value);
		}
}
