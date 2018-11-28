package edu.ncsu.csc316.dsa.graph;
/**
 * Graph interface
 * @author nicholasrrichardson
 *
 * @param <V> - generic vertex class
 * @param <E> - generic edge class
 */
public interface Graph<V, E> {
	/**
	 * Decides if a graph is directed
	 * @return - true for directed graphs
	 */
    boolean isDirected();
    /**
     * Gets the number of verices
     * @return int
     */
    int numVertices();
    /**
     * Gets an iterable of the vertices
     * @return an iterable
     */
    Iterable<Vertex<V>> vertices();
    /**
     * Gets the number of edges
     * @return int 
     */
    int numEdges();
    /**
     * Gets an iterable list of edges
     * @return an iterable
     */
    Iterable<Edge<E>> edges();
    /**
     * Gets the edge between two vertices
     * @param vertex1 - first vertex
     * @param vertex2 - second vertex
     * @return the edge between the two vertices
     */
    Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2);
    /**
     * Returns the two vertices connected to an edge
     * @param edge - an edge
     * @return two vertices (array)
     */
    Vertex<V>[] endVertices(Edge<E> edge);
    /**
     * Returns the vertices on the other side of the edge
     * @param vertex - subject vertex
     * @param edge - subject edge
     * @return - another vertex
     */
    Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge);
    /**
     * Gets the number of edges going into a vertex
     * @param vertex - subject vertex
     * @return int
     */
    int outDegree(Vertex<V> vertex);
    /**
     * Gets the number of edges leaving a vertex
     * @param vertex - subject vertex
     * @return int 
     */
    int inDegree(Vertex<V> vertex);
    /**
     * Gets an iterable of the edges leaving a vertex
     * @param vertex - subject vertex
     * @return an iterable
     */
    Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex);
    /**
     * Gets an iterbale of incoming edges of a vertex
     * @param vertex - subject vertex
     * @return an iterable
     */
    Iterable<Edge<E>> incomingEdges(Vertex<V> vertex);
    /**
     * Inserts a vertex into the graph
     * @param vertexData - The value to be put into the vertex
     * @return the vertex created
     */
    Vertex<V> insertVertex(V vertexData);
    /**
     * Inserts an edge into the graph
     * @param v1 - one of the vertices
     * @param v2 - one of the vertices
     * @param edgeData - The data to be put into the edge
     * @return the edge created
     */
    Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData);
    /**
     * Removes a vertex from the graph
     * @param vertex - vertex to be removed
     * @return the vertex removed
     */
    Vertex<V> removeVertex(Vertex<V> vertex);
    /**
     * Removes an edge from the graph
     * @param edge - the edge to be removed
     * @return the edge removed
     */
    Edge<E> removeEdge(Edge<E> edge);
    /**
     * Edge interface
     * @author nicholasrrichardson
     *
     * @param <E> - Generic element class
     */
    interface Edge<E> {
	    	/**
	    	 * Gets the element stored in the edge
	    	 * @return the element of the edge
	    	 */
        E getElement();
    }
    /**
     * Vertex interface
     * @author nicholasrrichardson
     *
     * @param <V> - generic value class
     */
    interface Vertex<V> {
    		/**
    		 * Gets the value stored in the vertex
    		 * @return the value stored in the vertex
    		 */
        V getElement();
    }
}