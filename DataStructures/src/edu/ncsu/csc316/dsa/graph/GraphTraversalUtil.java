package edu.ncsu.csc316.dsa.graph;


import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.queue.LinkedQueue;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * Graph Traversal algorithms
 * @author nicholasrrichardson
 *
 */
public class GraphTraversalUtil {
	/**
	 * Searches by depthFirst
	 * @param graph - graph to search
	 * @param start  - starting vertex
	 * @param <E> - generic edge value
	 * @param <V> - generic vertex value
	 * @return The node Map 
	 */
    public static <V , E> Map<Vertex<V> , Edge<E>> depthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
    		HashSet<Vertex<V>> set = new HashSet<Vertex<V>>();
    		LinearProbingHashMap<Vertex<V> , Edge<E>> map = new LinearProbingHashMap<Vertex<V> , Edge<E>>();
    		dfsHelper(graph, start, set, map);
    		return map;
    }
	/**
	 * DepthFirst search helper
	 * @param graph - graph to search
	 * @param start  - starting vertex
	 * @param <E> - generic edge value
	 * @param <V> - generic vertex value
	 */
    private static <V, E> void dfsHelper(Graph<V, E> graph, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
    		known.add(u);
    		for(Edge<E> edge : graph.outgoingEdges(u))
    		{    		
    			Vertex<V> opp = graph.opposite(u, edge);
    			if (!known.contains(opp))
    			{
    				forest.put(opp, edge);
    				dfsHelper(graph, opp, known , forest);
    			}
    		}
    }
    /**
     * BreadthFirstSearch algorithm
     * @param graph - graph for search
     * @param start - start put for search
	 * @param <E> - generic edge value
	 * @param <V> - generic vertex value
     * @return a map of the search
     */
    public static <V, E> Map<Vertex<V>, Edge<E>> breadthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
		HashSet<Vertex<V>> set = new HashSet<Vertex<V>>();
		LinearProbingHashMap<Vertex<V> , Edge<E>> map = new LinearProbingHashMap<Vertex<V> , Edge<E>>();
		LinkedQueue<Vertex<V>> queue = new LinkedQueue<Vertex<V>>();
		
		set.add(start);
		queue.enqueue(start);
		while(!queue.isEmpty())
		{
			Vertex<V> u = queue.dequeue();
			for(Edge<E> edge: graph.outgoingEdges(u))
			{
				Vertex<V> w = graph.opposite(u, edge);
				if (!set.contains(w))
				{
					set.add(w);
					map.put(w, edge);
					queue.enqueue(w);
				}
			}
		}
		
		return map;
    }
}
