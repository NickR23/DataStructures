package edu.ncsu.csc316.dsa.graph;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
/**
 * AdjacencyListGraph
 * @author nicholasrrichardson
 *
 * @param <V> - generic value class
 * @param <E> - generic element class
 */
public class AdjacencyListGraph<V, E> extends AbstractGraph<V, E> {

    private PositionalList<Vertex<V>> vertexList;
    private PositionalList<Edge<E>> edgeList;
    /**
     * No-arg constructor
     */
    public AdjacencyListGraph() {
        this(false);
    }
    /**
     * Constructor
     * @param directed - directed property
     */
    public AdjacencyListGraph(boolean directed) {
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
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
        return validate(vertex).getOutgoing();
    }
    
    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
        return validate(vertex).getIncoming();
    }

    @Override
    public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
        Iterator<Edge<E>> it = edgeList.iterator();
        while (it.hasNext()) {
            GraphEdge current = validate(it.next());
            Vertex<V>[] ends = current.getEndpoints();
            if(!isDirected() && ends[1] == vertex1 && ends[0] == vertex2) {
                return current;
            }
            if (ends[0] == vertex1 && ends[1] == vertex2) {
                return current;
            }
        }
        return null;
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
    public Vertex<V> insertVertex(V vertexData) {
        ALVertex vertex = new ALVertex(vertexData, isDirected());
        Position<Vertex<V>> pos = vertexList.addLast(vertex);
        vertex.setPosition(pos);
        return vertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData) {
        ALEdge edge = new ALEdge(edgeData, v1, v2);
        Position<Edge<E>> pos = edgeList.addLast(edge);
        edge.setPosition(pos);
    		Vertex<V>[] vertices = edge.getEndpoints();
    		edge.setOutgoingListPosition(validate(vertices[0]).outgoing.addLast(edge));
    		edge.setIncomingListPosition(validate(vertices[1]).incoming.addLast(edge));
        return edge;
    }

    @Override
    public Vertex<V> removeVertex(Vertex<V> vertex) {
        ALVertex v = validate(vertex);
        Iterator<Edge<E>> it = v.outgoing.iterator();
        while(it.hasNext())
        {
            GraphEdge e = validate(it.next());
            Vertex<V>[] ends = e.getEndpoints();
            if(ends[0] == v || ends[1] == v) {
                removeEdge(e);
            }
        }
        if(isDirected()) {
            it = v.incoming.iterator();
            while(it.hasNext())
            {
                GraphEdge e = validate(it.next());
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
        ALEdge e = validate(edge);
        Vertex<V>[] ends = e.getEndpoints();
        ALVertex origin = validate(ends[0]);
        ALVertex dest = validate(ends[1]);
        
        edgeList.remove(e.getPosition());
        origin.outgoing.remove(e.getOutgoingListPosition());
        dest.incoming.remove(e.getIncomingListPosition());
        return e;
        
    }
    /**
     * ALVertex
     * @author nicholasrrichardson
     *
     */
    private class ALVertex extends GraphVertex {
        
        private PositionalList<Edge<E>> outgoing;
        private PositionalList<Edge<E>> incoming;
        
        public ALVertex(V data, boolean isDirected) {
            super(data);
            outgoing = new PositionalLinkedList<Edge<E>>();
            if(isDirected) {
                incoming = new PositionalLinkedList<Edge<E>>();
            } else {
                incoming = outgoing;
            }
        }
        
        public PositionalList<Edge<E>> getOutgoing() {
            return outgoing;
        }
        
        public PositionalList<Edge<E>> getIncoming() {
            return incoming;
        }
    }
    /**
     * ALEdge
     * @author nicholasrrichardson
     *
     */
    private class ALEdge extends GraphEdge {    
        private Position<Edge<E>> outgoingListPosition;
        private Position<Edge<E>> incomingListPosition;
        
        public ALEdge(E element, Vertex<V> v1,
                Vertex<V> v2) {
            super(element, v1, v2);
        }
        
        public Position<Edge<E>> getOutgoingListPosition() {
            return outgoingListPosition;
        }
        public void setOutgoingListPosition(Position<Edge<E>> outgoingListPosition) {
            this.outgoingListPosition = outgoingListPosition;
        }
        public Position<Edge<E>> getIncomingListPosition() {
            return incomingListPosition;
        }
        public void setIncomingListPosition(Position<Edge<E>> incomingListPosition) {
            this.incomingListPosition = incomingListPosition;
        }
    }

    private ALVertex validate(Vertex<V> v) {
        if(!(v instanceof AdjacencyListGraph.ALVertex)) {
            throw new IllegalArgumentException("Vertex is not a valid adjacency list vertex.");
        }
        return (ALVertex)v;
    }
    /**
     * Validate edge
     * @param e - edge
     * @return valid edge
     */
    protected ALEdge validate(Edge<E> e) {
        if(!(e instanceof AdjacencyListGraph.ALEdge)) {
            throw new IllegalArgumentException("Edge is not a valid adjacency list edge.");
        }
        return (ALEdge)e;
    }
}