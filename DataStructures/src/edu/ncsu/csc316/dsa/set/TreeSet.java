package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.search_tree.AVLTreeMap;

/**
 * TreeSet
 * @author nicholasrrichardson
 *
 * @param <E> -generic element class
 */
public class TreeSet<E extends Comparable<E>> extends AbstractSet<E> {

    private Map<E, E> tree;
    /**
     * Constructor
     */
    public TreeSet() {
        tree = new AVLTreeMap<E, E>();
    }
    
    @Override
    public Iterator<E> iterator() {
        return tree.iterator();
    }

    @Override
    public void add(E value) {
    		if(!contains(value))
    		{
    			tree.put(value, value);
    		}
    }

    @Override
    public boolean contains(E value) {
    		Iterator<E> itr = tree.iterator();
    		boolean result = false;
    		while(itr.hasNext() && !result)
    		{
    			result = itr.next() == value;
    		}
    		return result;
    }

    @Override
    public E remove(E value) {
    		return tree.remove(value);
    }

    @Override
    public int size() {
    		return tree.size();
    }
}
