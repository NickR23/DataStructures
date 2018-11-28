package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * UptreeDisjointSetForest
 * @author nicholasrrichardson
 * @param <E> - Generic element class set
 */
public class UpTreeDisjointSetForest<E> implements DisjointSet<E> {
    private Map<E, UpTreeNode<E>> map;
    /**
     * Constructor
     */
    public UpTreeDisjointSetForest() {
        map = new LinearProbingHashMap<E, UpTreeNode<E>>();
    }
	
    @Override
    public Position<E> makeSet(E value) {
    		UpTreeNode<E> node = new UpTreeNode<E>(value);
    		node.setCount(1);
    		map.put(value, node);
    		return node;
    }

    @Override
    public Position<E> find(E value) {
    		UpTreeNode<E> node = map.get(value);
    		while(node.getParent() != node)
    		{
        		findHelper(node);
    			node = node.getParent();
    		}
    		return node;
    }
    
    private UpTreeNode<E> findHelper(UpTreeNode<E> current) {
    		if (current != current.getParent())
    		{
    			current.setParent(findHelper(current.getParent()));
    		}
    		return current.getParent();
    }

    @Override
    public void union(Position<E> s, Position<E> t) {

        UpTreeNode<E> a = validate(find(s.getElement()));
        UpTreeNode<E> b = validate(find(t.getElement()));
        
        if (a.getCount() >= b.getCount())
        {
        		a.setCount(a.getCount() + b.getCount());
        		b.setParent(a);
        }
        else
        {
    			b.setCount(a.getCount() + b.getCount());
    			a.setParent(b);
        }
    }
	
	
	
	
	
	
	
	/**
	 * UpTreeNode
	 * @author nicholasrrichardson
	 *
	 * @param <E>
	 */
    private static class UpTreeNode<E> implements Position<E> {
        
        private E element;
        private UpTreeNode<E> parent;
        private int count;
        
        public UpTreeNode(E element) {
            setElement(element);
            setParent(this);
            setCount(1);
        }
        
        public void setElement(E element) {
            this.element = element;
        }
        
        @Override
        public E getElement() {
            return element;
        }
        
        public void setParent(UpTreeNode<E> parent) {
            this.parent = parent;
        }
        
        public UpTreeNode<E> getParent() {
            return parent;
        }
        
        public void setCount(int count) {
            this.count = count;
        }
        
        public int getCount() {
            return count;
        }
    }

    private UpTreeNode<E> validate(Position<E> p) {
        if(!(p instanceof UpTreeNode)) {
            throw new IllegalArgumentException("Position is not a valid up tree node.");
        }
        return (UpTreeNode<E>)p;
    }

}
