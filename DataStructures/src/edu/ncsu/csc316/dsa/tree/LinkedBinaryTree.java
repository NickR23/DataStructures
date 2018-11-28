package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * LinkedBinaryTree implementation
 * @author nicholasrrichardson
 *
 * @param <E> - generic element class
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    private Node<E> root;
    private int size;

    /**
     * Constructor
     */
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }
    /**
     * validates that a position is a node
     * @param p - specified position node
     * @return - a node of the position
     */
    protected Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Position is not a valid linked binary node");
        }
        return (Node<E>) p;
    }

    /**
     * Binary tree node
     * @author nicholasrrichardson
     *
     * @param <E> - generic element class
     */
    public static class Node<E> extends AbstractNode<E> {
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        /**
         * Constructor
         * @param element - provided element 
         */
        public Node(E element) {
            this(element, null);
        }
        /**
         * Arg constructor
         * @param element - Element to go in the node
         * @param parent - the parent of the node
         */
        public Node(E element, Node<E> parent) {
            super(element);
            setParent(parent);
        }
        /**
         * gets the left node
         * @return the left node
         */
        public Node<E> getLeft() {
            return left;
        }
        /**
         * gets the right node
         * @return the right node
         */
        public Node<E> getRight() {
            return right;
        }
        /**
         * Sets the left node
         * @param left - the new left node
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        /**
         * Sets the right node
         * @param right - the new right node
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }
        /**
         * Gets the parent of the node
         * @return the parent
         */
        public Node<E> getParent() {
            return parent;
        }
        /**
         * Sets the parent of the node
         * @param parent - the parent of the node
         */
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }

    @Override
    public Position<E> left(Position<E> p) {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> addLeft(Position<E> p, E value) {
        Node<E> node = validate(p);
        if (left(node) != null) {
            throw new IllegalArgumentException("Node already has a left child.");
        }
        //node.setLeft(new Node<E>(value, node));
        
        node.setLeft(createNode(value, node, null, null));
        size++;
		return node.getLeft();
    }

    @Override
    public Position<E> addRight(Position<E> p, E value) {
        Node<E> node = validate(p);
        if (right(node) != null) {
            throw new IllegalArgumentException("Node already has a right child.");
        }
        node.setRight(createNode(value, node, null, null));
        size++;
		return node.getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> addRoot(E value) {
        if (root() != null) {
            throw new IllegalArgumentException("The tree already has a root.");
        }
        this.root = createNode(value, null, null, null);
        size++;
        return root;
    }

    @Override
    public E remove(Position<E> p) {
        if (numChildren(p) == 2){
            throw new IllegalArgumentException("The node has two children");
        }
        Node<E> node = validate(p);
        if (isRoot(node))
        {
        		root = null;
        		if (node.getRight() != null)
        		{
        			root = node.getRight();
        		}
        		else if (node.getLeft() != null)
        		{
        			root = node.getLeft();
        		}
        		size--;
        		return node.getElement();
        }
        
        Node<E> parent = node.getParent();
        E value = node.getElement();
        
        if (parent.getLeft() == node)
        {
	        if (node.getLeft() != null)
	        {
	        		node.getLeft().setParent(node.getParent());
	        		parent.setLeft(node.getLeft());	
	        }
	        else if (node.getRight() != null)
	        {
	        		node.getRight().setParent(node.getParent());
	        		parent.setLeft(node.getRight());
	        }
	        else
	        {
	        		parent.setLeft(null);
	        }
	        size--;
        }
        else
        {
	        if (node.getLeft() != null)
	        {
	        		node.getLeft().setParent(node.getParent());
	        		parent.setRight(node.getLeft());	
	        }
	        else if (node.getRight() != null)
	        {
	        		node.getRight().setParent(node.getParent());
	        		parent.setRight(node.getRight());
	        }
	        else
	        {
	        		parent.setRight(null);
	        }
	        size--;
        }

		return value;
    }

    @Override
    public int size() {
        return size;
    }
    /**
     * Makes a new node
     * @param e - generic class
     * @param parent - sets the parent of the  node
     * @param left - sets the left child
     * @param right - sets the right child
     * @return - the new node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        Node<E> newNode = new Node<E>(e);
        newNode.setParent(parent);
        newNode.setLeft(left);
        newNode.setRight(right);
        return newNode;
    }

    // setRoot is needed for a later lab...
    // ...but THIS DESIGN IS BAD! If a client arbitrarily changes
    // the root by using the method, the size may no longer be correct/valid.
    // Instead, the precondition for this method is that
    // it should *ONLY* be used when rotating nodes in 
    // balanced binary search trees. We could instead change
    // our rotation code to not need this setRoot method, but that
    // makes the rotation code messier. For the purpose of this lab,
    // we will sacrifice a stronger design for cleaner/less code.
    /**
     * sets the root node
     * @param p - the position of the new node
     * @return - the new root
     */
    protected Position<E> setRoot(Position<E> p) {
        root = validate(p);
        return root;
    }
}