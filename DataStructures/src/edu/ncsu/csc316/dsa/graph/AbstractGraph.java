package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Position;

/**
 * Graph abstraction
 * @author nicholasrrichardson
 *
 * @param <V> - Generic value class
 * @param <E> - Generic element class
 */
public abstract class AbstractGraph<V, E> implements Graph<V, E> {
    
    private boolean isDirected;
    /**
     * Constructor
     * @param directed - Indicates if graph is directed or not
     */
    public AbstractGraph(boolean directed) {
        setDirected(directed);
    }
    /**
     * Sets the directed property of the graph
     * @param directed - Indicates if graph is directed or not
     */
    private void setDirected(boolean directed) {
        isDirected = directed;
    }
    
    /**
     * Gets the directed property of the graph
     * @return boolean
     */
    public boolean isDirected() {
        return isDirected;
    }
    
    @Override
    public Vertex<V>[] endVertices(Edge<E> edge) {
        return validate(edge).getEndpoints();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) {
        GraphEdge temp = validate(edge);
        Vertex<V>[] ends = temp.getEndpoints();
        if(ends[0] == vertex) {
            return ends[1];
        }
        if(ends[1] == vertex) {
            return ends[0];
        }
        throw new IllegalArgumentException("Vertex is not incident on this edge.");
    }
    /**
     * Inner vertex class
     * @author nicholasrrichardson
     *
     */
    protected class GraphVertex implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> position;
        /**
         * Constructor
         * @param element - element to be stored in vertex
         */
        public GraphVertex(V element) {
            setElement(element);
        }
        /**
         * Sets the element stored in vertex
         * @param element - new element
         */
        public void setElement(V element) {
            this.element = element;
        }
        /**
         * Gets the element 
         * @return the element
         */
        public V getElement() {
            return element;
        }
        /**
         * Gets the position of the vertex
         * @return the position
         */
        public Position<Vertex<V>> getPosition(){
            return position;
        }
        /**
         * Sets the position of the vertex
         * @param pos - new position
         */
        public void setPosition(Position<Vertex<V>> pos) {
            position = pos;
        }
    }
    /**
     * Inner edge class
     * @author nicholasrrichardson
     *
     */
    protected class GraphEdge implements Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;
        private Position<Edge<E>> position;
        /**
         * Constructor
         * @param element - element to be stored in the edge
         * @param v1 - first vertex
         * @param v2 - second vertex
         */
        @SuppressWarnings("unchecked")
        public GraphEdge(E element, Vertex<V> v1, Vertex<V> v2) {
            setElement(element);
            endpoints = (Vertex<V>[])new Vertex[]{v1, v2};
        }
        /**
         * Sets the element of the edge
         * @param element - the new element
         */
        public void setElement(E element) {
            this.element = element;
        }
        /**
         * Gets the element of the edge
         * @return the element
         */
        public E getElement() {
            return element;
        }
        /**
         * Gets the connecting vertices of the edge
         * @return the two connecting vertices in an array
         */
        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }
        /**
         * Gets the position of the edge
         * @return the position
         */
        public Position<Edge<E>> getPosition(){
            return position;
        }
        /**
         * Sets the position of the edge
         * @param pos - the new position
         */
        public void setPosition(Position<Edge<E>> pos) {
            position = pos;
        }
        
        @Override
        public String toString() {
            return "Edge[element=" + element + "]";
        }
    }
    /**
     * Validates an edge
     * @param e - edge 
     * @return an edge
     */
    protected GraphEdge validate(Edge<E> e) {
        if (!(e instanceof AbstractGraph.GraphEdge)) {
            throw new IllegalArgumentException("Edge is not a valid graph edge.");
        }
        return (GraphEdge) e;
    }
}