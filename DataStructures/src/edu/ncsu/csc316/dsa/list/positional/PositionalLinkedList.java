/**
 * 
 */
package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/** PostionalLinkedList
 * @author nicholasrrichardson
 * @param <E> - Generic element class.
 */ 
public class PositionalLinkedList<E> implements PositionalList<E> {
	private int size;
	private PositionalNode<E> front;
	private PositionalNode<E> tail;
	
	/**
	 * Constructor.
	 */
	public PositionalLinkedList()
	{
		size = 0;
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		
	}
	/**
	 * PositionalNode class.
	 * @author nicholasrrichardson
	 *
	 * @param <E> - Stores generic element.
	 */
	 private static class PositionalNode<E> implements Position<E> {

	     private E element;
	     private PositionalNode<E> next;
	     private PositionalNode<E> previous;
	     /**
	      * Constructor.
	      * @param value - Element in node.
	      */
	     public PositionalNode(E value) {
	    	 	element = value;
	    	 	next = null;
	    	 	previous = null;
	     }
	     //Removed one of the constructors...

	     public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
	    	 	element = value;
	    	 	this.next = next;
	    	 	previous = prev;
	     }

	     public void setPrevious(PositionalNode<E> prev) {
	    	 	this.previous = prev;
	     }

	     public PositionalNode<E> getPrevious() {
	    	 	return previous;
	     }
	        
	     public void setNext(PositionalNode<E> next) {
	         this.next = next;
	     }

	     public PositionalNode<E> getNext() {
	         return next;
	     }

	     @Override
	     public E getElement() {
	         return element;
	     }
	     public void setElement(E element) {
	         this.element = element;
	     }
	 }
	
	 /**
	  * Position iterator.
	  * @author nicholasrrichardson
	  *
	  */
	    private class PositionIterator implements Iterator<Position<E>> {

	        private Position<E> current;
	        private boolean removeOK;

	        public PositionIterator(PositionalNode<E> start) {
	            current = start;
	            removeOK = false;
	        }

	        @Override
	        public boolean hasNext() {
	        		return current != tail;
	        }

	        @Override
	        public Position<E> next() {
	        		PositionalNode<E> hold = (PositionalNode<E> )current;
	        		current = ((PositionalNode<E>) current).getNext();
	        		
	        		removeOK = true;
	        		return hold;
	        }

	        @Override
	        public void remove() {
		        	if(removeOK)
		        	{
		        		PositionalLinkedList.this.remove(((PositionalNode<E>)current).getPrevious());
			        	removeOK = false;
		        	}
	        }
	    }
	   
	    /**
	     * Element iterator.
	     * @author nicholasrrichardson
	     *
	     */
	    private class ElementIterator implements Iterator<E> {

	        private Iterator<Position<E>> it;

	        public ElementIterator(PositionalNode<E> start) {
	            it = new PositionIterator(start);
	        }

	        @Override
	        public boolean hasNext() {
	            return it.hasNext();
	        }

	        @Override
	        public E next() {
	        		E hold  = it.next().getElement();
	        		return hold;
	        }

	        @Override
	        public void remove() {
	        		it.remove();
	        }
	    }	    
	
	    /**
	     * Wrapper class for positionIterator.
	     * @author nicholasrrichardson
	     *
	     */
	    private class PositionIterable implements Iterable<Position<E>> {
	    		@Override
	    		public Iterator<Position<E>> iterator() {
	    			return new PositionIterator(front.getNext());
	    		}
	    }
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}
	
	
	private Position<E> addBetween(E value, PositionalNode<E> next, PositionalNode<E> prev)
	{
		PositionalNode<E> hold = new PositionalNode<E>(value);
		hold.setNext(next);
		hold.setPrevious(prev);
		next.setPrevious(hold);
		prev.setNext(hold);
		size++;
		return hold;
	}
	@Override 
	public Position<E> addAfter(Position<E> p, E value) {
		validate(p);
		return addBetween(value, ((PositionalNode<E>) p).getNext(), ((PositionalNode<E>) p));
	}

	@Override
	public Position<E> addBefore(Position<E> p, E value) {
		validate(p);
		return addBetween(value, ((PositionalNode<E>) p), ((PositionalNode<E>) p).getPrevious());
	}

	@Override
	public Position<E> addFirst(E value) {
		return addBetween(value, front.getNext(), front);
	}

	@Override
	public Position<E> addLast(E value) {
		return addBetween(value,  tail, tail.getPrevious());

	}

	@Override
	public Position<E> after(Position<E> p) {
		validate(p);
		PositionalNode<E> node = (PositionalNode<E>) p;
		if (node.getNext() == null)
		{
			throw new NoSuchElementException();
		}
		return node.getNext();
	}

	@Override
	public Position<E> before(Position<E> p) {
		validate(p);
		PositionalNode<E> node = (PositionalNode<E>) p;
		if (node.getPrevious() == null)
		{
			throw new NoSuchElementException();
		}
		return node.getPrevious();
	}

	@Override
	public Position<E> first() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return front.getNext();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> last() {
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return tail.getPrevious();
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionIterable positions = new PositionIterable();
		return positions;
	}

	@Override
	public E remove(Position<E> p) {
		validate(p);
		PositionalNode<E> node = (PositionalNode<E>) p;
		E hold = node.getElement();
		node.getPrevious().setNext(node.getNext());
		if(node.getNext() != null)
		{
	    		node.getNext().setPrevious(node.getPrevious());
		}
		

		node.setNext(null);
		node.setPrevious(null);
		size--;
		return hold;
	}

	@Override
	public E set(Position<E> p, E value) {
		validate(p);
		PositionalNode<E> node = (PositionalNode<E>) p;
		E hold = node.getElement();
		node.setElement(value);
		return hold;
	}

	@Override
	public int size() {
		return size;
	}

	private PositionalNode<E> validate(Position<E> p)
	{
		if (p instanceof PositionalNode)
		{
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional node.");
	}
}
