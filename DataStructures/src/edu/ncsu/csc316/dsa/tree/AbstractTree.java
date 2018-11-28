package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.TailSinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;

/**
 * Tree abstraction
 * @author nicholasrrichardson
 *
 * @param <E> - generic value class
 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }
    
    @Override
    public boolean isLeaf(Position<E> p) {
        return numChildren(p) == 0;
    }
    
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public Iterable<Position<E>> preOrder()
    {
        // You can use any list data structure here that supports
        // O(1) addLast
        List<Position<E>> traversal = new TailSinglyLinkedList<Position<E>>();
        if (!isEmpty()) {
			//System.out.println("*");
            preOrderHelper(root(), traversal);
        }
        return traversal;
    }
    
    private void preOrderHelper(Position<E> node, List<Position<E>> traversal) {
    		if (node == null)
    		{
    			return;
    		}
    		if (node.getElement() != null)
    		{
    			traversal.addLast(node);
    		}
    		Iterator<Position<E>> itr = children(node).iterator();

    		while(itr.hasNext())
    		{
    			preOrderHelper(itr.next(), traversal);
    		}
    } 
    
    
	@Override
	public Iterable<Position<E>> postOrder() {
        List<Position<E>> traversal = new TailSinglyLinkedList<Position<E>>();
        if (!isEmpty()) {
            postOrderHelper(root(), traversal);
        }
        return traversal;
	}
	
    private void postOrderHelper(Position<E> node, List<Position<E>> traversal) {
		if (node == null)
		{
			return;
		}
		Iterator<Position<E>> itr = children(node).iterator();
		while(itr.hasNext())
		{
			postOrderHelper(itr.next(), traversal);
		}
		if (node.getElement() != null)
		{
			traversal.addLast(node);
		}
    } 
    
   
	@Override
	public Iterable<Position<E>> levelOrder() {
        List<Position<E>> traversal = new TailSinglyLinkedList<Position<E>>();
        if (!isEmpty()) {
            levelOrderHelper(root(), traversal);
        }
        return traversal;
	}
	
	private void levelOrderHelper(Position<E> node, List<Position<E>> traversal)
	{
		ArrayBasedQueue<Position<E>> queue = new ArrayBasedQueue<Position<E>>();
		Iterator<Position<E>> itr = null;
		Position<E> element = null;
		if (node == null)
		{
			return;
		}
		queue.enqueue(node);
		while (!queue.isEmpty())
		{
			element = queue.dequeue();
			itr = children(element).iterator();
			if (node.getElement() != null)
			{
				traversal.addLast(element);
			}
			
			while(itr.hasNext())
			{
				queue.enqueue(itr.next());
			}
			
		}
	}
	/**
	 * Iterates over the elements of a tree.
	 * @author nicholasrrichardson
	 *
	 */
    protected class ElementIterator implements Iterator<E> {
        private Iterator<Position<E>> it;
        /**
         * Constructor.
         * @param iterator - thingamajig
         */
        public ElementIterator(Iterator<Position<E>> iterator) {
            it = iterator;
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public E next() {
            return it.next().getElement();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported yet.");
        }
    }  
	
    
    // Since every tree node is going to be a "Position", every tree
    // node will need the getElement and setElement methods
    /**
     * Node abstraction
     * @author nicholasrrichardson
     *
     * @param <E> - generic value class
     */
    protected abstract static class AbstractNode<E> implements Position<E> {

        private E element;
        /**
         * Constructor
         * @param element - generic element class
         */
        public AbstractNode(E element) {
            setElement(element);
        }
        
        @Override
        public E getElement() {
            return element;
        }
        /**
         * Modifies an element
         * @param element - the new element
         */
        public void setElement(E element) {
            this.element = element;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
        toStringHelper(sb, "", root());
        sb.append("]");
        return sb.toString();
    }
    
    private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
        if(root == null) {
            return;
        }
        sb.append(indent).append(root.getElement()).append("\n");
        for(Position<E> child : children(root)) {
            toStringHelper(sb, indent + " ", child);
        }
    }    
}