package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Random;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;
import edu.ncsu.csc316.dsa.list.List;
/**
 * SkipListMap
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class must extend Comparable
 * @param <V> - generic value class
 */
public class SkipListMap<K extends Comparable<K>, V> extends AbstractSortedMap<K, V> {

    private Random coinToss;
    private SkipListEntry<K, V> start;
    private int size;
    private int height;
    /**
     * no-arg constructor
     */
    public SkipListMap() {
        this(null);
    }
    /**
     * comparator constructor
     * @param compare - comparator
     */
   public SkipListMap(Comparator<K> compare) {
        super(compare);
        coinToss = new Random();        
        // Create a dummy node for the left "-INFINITY" sentinel tower
        start = new SkipListEntry<K, V>(null, null);
        // Create a dummy node for the right "+INFINITY" sentinel tower
        start.setNext(new SkipListEntry<K, V>(null, null));
        // Set the +INFINITY tower's previous to be the "start" node
        start.getNext().setPrevious(start);
        size = 0;
        height = 0;
        coinToss = new Random();
    }
    
    // Helper method to determine if an entry is one of the sentinel
    // -INFINITY or +INFINITY nodes (containing a null key)
    private boolean isSentinel(SkipListEntry<K, V> entry) {
        return entry.getKey() == null;
    }
    //Finds the node right before the key, or where it should be.
    private SkipListEntry<K, V> lookUp(K key) {
        SkipListEntry<K, V> current = start;
        while (current.below != null) {
            current = current.below;
            while (!isSentinel(current.next) && compare(key, current.next.getKey()) >= 0) {
                current = current.next;
            }
        }
        return current;
    }

    @Override
    public V get(K key) {
        SkipListEntry<K, V> temp = lookUp(key);
        if (temp.getKey() != key)
        {
        		return null;
        }
		return temp.getValue();
    }

    private SkipListEntry<K, V> insertAfterAbove(SkipListEntry<K, V> prev, SkipListEntry<K, V> down, K key, V value) {
    	   // Create a new skip list entry
    	    SkipListEntry<K, V> newEntry = new SkipListEntry<K, V>(key, value);
        // Set the below and previous entries
        newEntry.setBelow(down);
        newEntry.setPrevious(prev);
        // Update the next and previous entry pointers
        if (newEntry.getPrevious() != null)
        {
            newEntry.setNext(prev.next);
            newEntry.getPrevious().setNext(newEntry);
        }
        if( newEntry.next != null)
        		newEntry.next.setPrevious(newEntry);
        // Update the below entry pointers
        if (newEntry.getBelow() != null)
        {
        		
           down.setAbove(newEntry);
        }
        return newEntry;
    }

    @Override
    public V put(K key, V value) {
        SkipListEntry<K, V> temp = lookUp(key);
        return insert(temp, key, value);
    }
    
    private V insert (SkipListEntry<K, V> temp, K key, V value)
    {
        
        
        //Entry with the key already exists in the map
        if (temp.getKey() == key)
        {
        		V oldValue = temp.getValue();
        		while(temp != null)
        		{
        			temp.setValue(value);
        			temp = temp.getAbove();
        		}
        		return oldValue;
        }
        
        //If entry needs to be created
        int currentLevel = -1;
        SkipListEntry<K, V> q = null;
        SkipListEntry<K, V> tail = null;
        do {
        		currentLevel++;
        		//Check if we need a new top level
        		if (currentLevel >= height)
        		{
        			//Increase height
        			height++;
        			//Add tail pointer to current tail of the list
        			tail = start.getNext();
        	        //Insert new start node
        	        start = insertAfterAbove(null, start, null, null);
        	        insertAfterAbove(start, tail, null, null);
        		}
    	        // Insert the new entry into current level of the list
    	        q = insertAfterAbove(temp, q, key, value);
    	        // Backtrack to the entry immediately before the insertion location in the level "above"
    	        while (temp.getAbove() == null)
    	        {
    	            temp = temp.prev;
    	        }
    	        temp = temp.getAbove();        
        } while(coinToss.nextBoolean());
        
        size++;
		return null;
    }


    @Override
    public V remove(K key) {
        SkipListEntry<K, V> temp = lookUp(key);
        V originalValue = temp.getValue();
        
        if (isSentinel(temp) || temp.getKey() != key)
        {
        		return null;
        }
        
        while (temp != null)
        {
        		temp.prev.setNext(temp.next);
        		temp.next.setPrevious(temp.getPrevious());         		
        		temp = temp.above;
        }
        
        while (start.below != null && isSentinel(start.below.next))
        {
        		start = start.below;
        		height--;
        }
        size--;
		return originalValue;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> set = new ArrayBasedList<Entry<K, V>>();
        SkipListEntry<K, V> current = start;
        while(current.below != null){
            current = current.below;
        }
        current = current.next;
        while(!isSentinel(current)) {
            set.addLast(current);
            current = current.next;
        }
        return set;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[");
        SkipListEntry<K, V> cursor = start;
        while( cursor.below != null) {
            cursor = cursor.below;
        }
        cursor = cursor.next;
        while(cursor != null && cursor.getKey() != null) {
            sb.append(cursor.getKey());
            if(cursor.next != null && cursor.next.getKey() != null) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    // This method may be useful for testing or debugging.
    // You may comment-out this method instead of testing it, since
    // the full string will depend on the series of random coin flips
    // and will not have deterministic expected results.
    /**
     * Creates a string
     * @return a string
     */
    public String toFullString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
        SkipListEntry<K, V> cursor = start;
        SkipListEntry<K, V> firstInList = start;
        while( cursor != null) {
            firstInList = cursor;
            sb.append("-INF -> ");
            cursor = cursor.next;
            while(cursor != null && !isSentinel(cursor)) {
                sb.append("[" + cursor.getKey() + ":" + cursor.getValue() + "]" +  " -> ");
                cursor = cursor.next;
            }
            sb.append("+INF\n");
            cursor = firstInList.below;
        }
        sb.append("]");
        return sb.toString();
    }
    /**
     * SkipListEntry class
     * @author nicholasrrichardson
     *
     * @param <K> - generic key class
     * @param <V> - generic value class
     */
    private static class SkipListEntry<K, V> extends MapEntry<K, V> {

        private SkipListEntry<K, V> above;
        private SkipListEntry<K, V> below;
        private SkipListEntry<K, V> prev;
        private SkipListEntry<K, V> next;

        public SkipListEntry(K key, V value) {
            super(key, value);
            setAbove(null);
            setBelow(null);
            setPrevious(null);
            setNext(null);
        }
        
        public SkipListEntry<K, V> getBelow() {
            return below;
        }
        
        public SkipListEntry<K, V> getNext() {
            return next;
        }
        
        public SkipListEntry<K, V> getPrevious() {
            return prev;
        }
        
        public SkipListEntry<K, V> getAbove() {
            return above;
        }
        
        public void setBelow(SkipListEntry<K, V> down) {
            this.below = down;
        }
        
        public void setNext(SkipListEntry<K, V> next) {
            this.next = next;
        }
        
        public void setPrevious(SkipListEntry<K, V> prev) {
            this.prev = prev;
        }
        public void setAbove(SkipListEntry<K, V> up) {
            this.above = up;
        }
    }
}
