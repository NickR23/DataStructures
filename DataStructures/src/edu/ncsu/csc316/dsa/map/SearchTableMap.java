package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Iterator;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * SearchTableMap
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class. Must extend Comparable
 * @param <V> - generic value class
 */
public class SearchTableMap<K extends Comparable<K>, V> extends AbstractSortedMap<K, V> {

    private ArrayBasedList<Entry<K, V>> list;
    /**
     * no-arg constructor
     */
    public SearchTableMap() {
        this(null);
    }
    /**
     * arg constructor
     * @param compare - Comparator object used to compare keys
     */
    public SearchTableMap(Comparator<K> compare) {
        super(compare);
        list = new ArrayBasedList<Entry<K, V>>();
    }

    private int lookUp(K key) {
        int index = binarySearchHelper(0, list.size() - 1, key); 
        return index;
    }

    private int binarySearchHelper(int min, int max, K key) {
    		if (min > max)
    		{
    			return -1 * (min + 1);
    		}
    		int mid = (max + min) / 2;
    		
    		if (list.get(mid).getKey().compareTo(key) == 0)
    		{
    			return mid;
    		}
    		else if (list.get(mid).getKey().compareTo(key) > 0)
    		{
    			return binarySearchHelper(min, mid - 1, key);
    		}
    		else
    		{
    			return binarySearchHelper(mid + 1, max, key);
    		}
    }
    

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public V get(K key) {
	    int index = lookUp(key);
	    V value = null;
	    if (index >= 0)
	    {
	    		value = list.get(index).getValue();
	    }
	    return value;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayBasedList<Entry<K, V>> set = new ArrayBasedList<Entry<K, V>>();
        for(Entry<K, V> m : list) {
            set.addLast(m);
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        int index = lookUp(key);        		
        //System.out.println("&" + index);

        V oldValue = null;
        if (index >= 0)
        {
        		oldValue = list.get(index).getValue();
        		list.set(index, new MapEntry<K, V>(key, value));
        }
        else
        {
        		oldValue = value;
        		index++;
        		index *= -1;
            //System.out.println("*" + index);

        		list.add(index, new MapEntry<K, V>(key, value));
        }
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int index = lookUp(key);
        
        if(index < 0)
        {
        		return null;
        }
        
        	V value = list.remove(index).getValue();
        	
        return value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[");
        Iterator<Entry<K, V>> it = list.iterator();
        while(it.hasNext()) {
            sb.append(it.next().getKey());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}