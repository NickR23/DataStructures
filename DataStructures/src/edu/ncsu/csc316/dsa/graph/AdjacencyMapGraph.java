package edu.ncsu.csc316.dsa.graph;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
/**
 * AdjancencyMapGraph
 * @author nicholasrrichardson
 *
 * @param <V> - generic value class
 * @param <E> - generic element class
 */
public class AdjacencyMapGraph<V, E> extends AbstractGraph<V, E> {

    private PositionalList<Vertex<V>> vertexList;
    private PositionalList<Edge<E>> edgeList;
    /**
     * No-arg constructor
     */
    public AdjacencyMapGraph() {
        this(false);
    }
    /**
     * Constructor
     * @param directed - boolean
     */
    public AdjacencyMapGraph(boolean directed) {
        super(directed);
        vertexList = new PositionalLinkedList<Vertex<V>>();
        edgeList = new PositionalLinkedList<Edge<E>>();
    }
    
    @Override
    public int numVertices() {
        return vertexList.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertexList;
    }

    @Override
    public int numEdges() {
        return edgeList.size();
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edgeList;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
        return validate(vertex1).getOutgoing().get(vertex2);
    }

    @Override
    public int outDegree(Vertex<V> vertex) {
        return validate(vertex).getOutgoing().size();
    }

    @Override
    public int inDegree(Vertex<V> vertex) {
        return validate(vertex).getIncoming().size();
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
        return validate(vertex).getOutgoing().values();
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
        return validate(vertex).getIncoming().values();
    }

    @Override
    public Vertex<V> insertVertex(V vertexData) {
        AMVertex vertex = new AMVertex(vertexData, isDirected());
        Position<Vertex<V>> pos = vertexList.addLast(vertex);
        vertex.setPosition(pos);
        return vertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData) {
        GraphEdge edge = new GraphEdge(edgeData, v1, v2);
        Position<Edge<E>> pos = edgeList.addLast(edge);
        edge.setPosition(pos);
        AMVertex origin = validate(v1);
        AMVertex destination = validate(v2);
        origin.outgoing.put(destination, edge);
        destination.incoming.put(origin, edge);
        return edge;
    }

    @Override
    public Vertex<V> removeVertex(Vertex<V> vertex) {
        AMVertex v = validate(vertex);
        Iterator<Vertex<V>> it = v.outgoing.iterator();
        while(it.hasNext())
        {
            GraphEdge e = validate(v.outgoing.get(it.next()));
            Vertex<V>[] ends = e.getEndpoints();
            if(ends[0] == v || ends[1] == v) {
                removeEdge(e);
            }
        }
        if(isDirected()) {
            it = v.incoming.iterator();
            while(it.hasNext())
            {
                GraphEdge e = validate(v.incoming.get(it.next()));
                Vertex<V>[] ends = e.getEndpoints();
                if(ends[0] == v || ends[1] == v) {
                    removeEdge(e);
                }
            }
        }
        vertexList.remove(v.getPosition());
        return v;
    }

    @Override
    public Edge<E> removeEdge(Edge<E> edge) {
        GraphEdge e = validate(edge);
        Vertex<V>[] ends = e.getEndpoints();
        AMVertex origin = validate(ends[0]);
        AMVertex destination = validate(ends[1]);
        origin.outgoing.remove(destination);
        destination.incoming.remove(origin);
        edgeList.remove(e.getPosition());
        return edge;
    }
    /**
     * Innert AMVertex
     * @author nicholasrrichardson
     *
     */
    private class AMVertex extends GraphVertex {
        
        private Map<Vertex<V>, Edge<E>> outgoing;
        private Map<Vertex<V>, Edge<E>> incoming;
        
        public AMVertex(V data, boolean isDirected) {
            super(data);
            outgoing = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
            if(isDirected) {
                incoming = new LinearProbingHashMap<>();
            } else {
                incoming = outgoing;
            }
        }
        
        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }
        
        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }
    }
    
    private AMVertex validate(Vertex<V> v) {
        if(!(v instanceof AdjacencyMapGraph.AMVertex)) {
            throw new IllegalArgumentException("Vertex is not a valid adjacency map vertex.");
        }
        return (AMVertex)v;
    }
}