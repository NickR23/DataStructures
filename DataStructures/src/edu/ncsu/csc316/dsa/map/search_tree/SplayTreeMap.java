/**
 * 
 */
package edu.ncsu.csc316.dsa.map.search_tree;

import java.util.Comparator;

import edu.ncsu.csc316.dsa.Position;

/**SplayTreeMap
 * @author nicholasrrichardson
 * @param <V> - generic value class
 * @param <K> - generic key class
 */
public class SplayTreeMap<K extends Comparable<K>, V> extends BinarySearchTreeMap<K, V> {
	/**
	 * No arg constructor
	 */
    public SplayTreeMap() {
        super(null);
    }
    /**
     * Arg constructor
     * @param compare - Comparator
     */
    public SplayTreeMap(Comparator<K> compare) {
        super(compare);
    }

    private void splay(Position<Entry<K, V>> p) {
    		Position<Entry<K, V>> node = p;

    		while (!isRoot(node)) {
    			Position<Entry<K, V>> parent = parent(node);
    			Position<Entry<K, V>> granny = parent(parent);
    			
    			if (granny == null)
    			{
    				rotate(node);
    			}
    			else if(left(granny) == parent && left(parent) == node || right(granny) == parent && right(parent) == node)
    			{
    				rotate(parent);
    				rotate(node);
    			}
    			else
    			{
    				rotate(node);
    				rotate(node);
    			}
    		}
    	
    }

    @Override
    protected void actionOnAccess(Position<Entry<K, V>> p) {
        // If p is a dummy/sentinel node, move to the parent
        if(isLeaf(p)) {
            p = parent(p);
        }
        if(p != null) {
            splay(p);
        }
    }

    @Override
    protected void actionOnInsert(Position<Entry<K, V>> node) {
        splay(node);
    }

    @Override
    protected void actionOnDelete(Position<Entry<K, V>> p) {
        if(!isRoot(p)) {
            splay(parent(p));
        }
    }
}