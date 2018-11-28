package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.TailSinglyLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
/**
 * General tree
 * @author nicholasrrichardson
 * @param <E> - generic value class
 */
public class GeneralTree<E> extends AbstractTree<E> implements GeneralTreeCollection<E> {
	
    private Node<E> root;
    private int size;
    /**
     * Constructor
     */
    public GeneralTree() {
        root = null;
        size = 0;
    }

	@Override
	public Position<E> root() {
		return root;
	}
	@Override
	public Position<E> parent(Position<E> p) {
		return validate(p).getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) {
		Node<E> node = validate(p);
		List<Position<E>> returnList = new TailSinglyLinkedList<Position<E>>();
		for(Position<Node<E>> c : node.getChildren().positions())
		{
			returnList.addLast(c.getElement());
		}
		return returnList;
	}
	
	@Override
	public int numChildren(Position<E> p) {
		return validate(p).getChildren().size();
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public Iterator<E> iterator() {
        return new ElementIterator(preOrder().iterator());
	}
	@Override
	public Position<E> addRoot(E value) {
		if (root != null)
		{
			throw new IllegalArgumentException();
		}
		root = new Node<E>(value);
		size++;
		return root;
	}
	@Override
	public Position<E> addChild(Position<E> p, E value) {
		Node<E> parent = validate(p);
		Node<E> child = new Node<E>(value, parent);
		parent.getChildren().addLast(child);
		size++;
		return child;
	}
	@Override
	public E remove(Position<E> p) {
	    Node<E> node = validate(p);
		E value = node.getElement();
		if (numChildren(node) > 1)
		{
			throw new IllegalArgumentException();
		}
		if (isRoot(node))
		{
			root = null;
			root = node.children.first().getElement();
		}
		else
		{
			Node<E> parent = node.getParent();
			//Promote node's children
			Iterator <Node<E>> itr = node.getChildren().iterator();
			Node<E> current = null;
			while (itr.hasNext())
			{
				current = itr.next();
				current.setParent(parent);
				parent.children.addLast(current);
			}
			
			//Remove node from parent children
			itr = parent.getChildren().iterator();
			current = null;
			while (itr.hasNext())
			{
				current = itr.next();
				 if (current == node)
				 {
					 itr.remove();
				 }
			}
		}
		size--;
		return value;
	}
	
	@Override
	public E set(Position<E> p, E value) {
		Node<E> node = validate(p);
		E oldValue = p.getElement();
		node.setElement(value);
		return oldValue;
	}
	
	
	
	/**
	 * AbstractNode class
	 * @author nicholasrrichardson
	 *
	 * @param <E> - generic value class
	 */
    private static class Node<E> extends AbstractNode<E> {

        private Node<E> parent;
        
        // A general tree node needs to maintain a list of children
        private PositionalList<Node<E>> children;
        
        public Node(E element) {
            this(element, null);
        }
        
        public Node(E element, Node<E> parent) {
            super(element);
            setParent(parent);
            children = new PositionalLinkedList<Node<E>>();
        }
        
        public void setParent(Node<E> p) {
            parent = p;
        }
        
        public Node<E> getParent() {
            return parent;
        }
        
        public PositionalList<Node<E>> getChildren() {
            return children;
        }
    }
    
    private Node<E> validate(Position<E> p) {
        if(!(p instanceof Node)) {
            throw new IllegalArgumentException("Position is not a legal general tree node");
        }
        return (Node<E>)p;
    }
}
