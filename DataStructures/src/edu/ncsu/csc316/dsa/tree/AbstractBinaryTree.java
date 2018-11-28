package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.TailSinglyLinkedList;
/**
 * BinaryTree Abstraction
 * @author nicholasrrichardson
 *
 * @param <E> - generic element class
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTreeCollection<E> {

	@Override
	public Iterable<Position<E>> inOrder() {
		List<Position<E>> traversal = new TailSinglyLinkedList<Position<E>>();

		if (!isEmpty()) {
			inOrderHelper(root(), traversal);
		}

		return traversal;
	}

	private void inOrderHelper(Position<E> node, List<Position<E>> traversal) {
		if (node == null)
		{
			return;
		}
//		queue.enqueue(node);
//		while (!queue.isEmpty())
//		{
//			element = queue.dequeue();
//			itr = children(element).iterator();
//			traversal.addLast(element);
//			
//			while(itr.hasNext())
//			{
//				queue.enqueue(itr.next());
//			}
//			
//		}
		inOrderHelper(left(node), traversal);
		if(node.getElement() != null)
		{
			traversal.addLast(node);
		}
		inOrderHelper(right(node), traversal);
	}
	
	@Override
	public Position<E> sibling(Position<E> p) {
		Position<E> momma = parent(p);
		if (left(momma) == p)
		{
			return right(momma);
		}
		return left(momma);
	}
	
	private AbstractNode<E> validate(Position<E> p) {
		if(!(p instanceof AbstractNode)) {
			throw new IllegalArgumentException("Position is not a valid binary tree node");
		}
		return (AbstractNode<E>)(p);
	}
	
	@Override
	public int numChildren(Position<E> p) {
		int size = 0;
		if(left(p) != null)
		{
			size++;
		}
		if(right(p) != null)
		{
			size++;
		}
		return size;
	}
	
	@Override
	public E set(Position<E> p, E value) {
		E oldValue = p.getElement();
		AbstractNode<E> node = validate(p);
		node.setElement(value);
		return oldValue;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(inOrder().iterator());
	}
	
	@Override
	public Iterable<Position<E>> children(Position<E> p) {
		//AbstractNode<E> node = validate(p);
		List<Position<E>> returnList = new TailSinglyLinkedList<Position<E>>();
		if(left(p) != null && left(p).getElement() != null) {
			//System.out.println("^" + left(p));
			returnList.addLast(left(p));
		}
		if(right(p) != null && right(p).getElement() != null) {
			returnList.addLast(right(p));
		}
		return returnList;
	}
}