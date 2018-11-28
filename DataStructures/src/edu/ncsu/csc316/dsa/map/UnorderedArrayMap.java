package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.list.*;
/**
 * UnorderedArrayMap
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class UnorderedArrayMap<K, V> extends AbstractMap<K, V> {

    /**
     * ArrayBased list
     * @param <V> - generic value class
     */
    private ArrayBasedList<Entry<K, V>> list;
    /**
     * Constructor 
     */
    public UnorderedArrayMap() {
        list = new ArrayBasedList<Entry<K, V>>();
    }

    // LookUp is a core behavior of all maps
    // This lookup should perform a sequential search
    // and return the index where the entry
    // is located. If the entry is not in the map, return -1
    private int lookUp(K key)
    {
        // You can use your ArrayBasedList's iterator to help
        // locate the entry with the specified Key
    		Iterator<Entry<K, V>> itr = list.iterator();
    		int i = 0;
    		while(itr.hasNext())
    		{
    			if(itr.next().getKey() == key)
    			{
    				return i;
    			}
    			i++;
    		}
	    	
	    	return -1;
    }
    
    @Override
    public V get(K key) {
        int index = lookUp(key);
        return transpose(index);
    }
    
    @Override
    public V put(K key, V value) {
        int index = lookUp(key);
        V newValue = value;
        if (index == -1)
        {
        		index = 0;
        		list.add(index, new MapEntry<K, V>(key, value));
        }
        else
        {
	        newValue = list.get(index).getValue();
	        list.get(index).setValue(value);
	        transpose(index);
        }
        
        return newValue;
    }
    
    @Override
    public V remove(K key) {
       int index = lookUp(key);
       V hold = list.get(index).getValue();
       list.remove(index);
       return hold;
    }

    @Override
    public int size() {
        return list.size();
    }
    
    private V transpose(int index)
    {
    		if(index > 0)
    		{
    			Entry<K, V> hold = list.get(index - 1);
    			list.set(index - 1, list.get(index));
    			list.set(index, hold);
    			return list.get(index - 1).getValue();
    		}
    		else if (index == -1)
    		{
    			return null;
    		}
    		else
    		{
    			return list.get(index).getValue();
    		}
        
    }
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
    		ArrayBasedList<Entry<K, V>> newList = new ArrayBasedList<Entry<K, V>>();
    		Entry<K, V> entry = null;
    		for(int i = 0; i < list.size(); i++)
    		{
    			entry = list.get(i);
    			newList.add(i, entry);
    		}
    		return newList;
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