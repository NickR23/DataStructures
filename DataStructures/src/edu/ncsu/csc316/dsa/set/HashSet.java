package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * HashSet
 * @author nicholasrrichardson
 *
 * @param <E> - generic element class
 */
public class HashSet<E> extends AbstractSet<E> {

    private Map<E, E> map;
    /**
     * Constructor
     */
    public HashSet() {
        map = new LinearProbingHashMap<E, E>();
    }
    
    @Override
    public Iterator<E> iterator() {
        return map.iterator();
    }

    @Override
    public void add(E value) {
		if(!contains(value))
		{
			map.put(value, value);
		}
    }

    @Override
    public boolean contains(E value) {
		Iterator<E> itr = map.iterator();
		boolean result = false;
		while(itr.hasNext() && !result)
		{
			result = itr.next() == value;
		}
		return result;    }

    @Override
    public E remove(E value) {
    		return map.remove(value);
    }
    /**
     * Size
     * @return size
     */
    public int size() {
    		return map.size();
    }
}