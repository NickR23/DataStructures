/**
 * 
 */
package edu.ncsu.csc316.dsa.graph;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**Test
 * @author nicholasrrichardson
 *
 */
public class AdjacencyMapGraphTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#AdjacencyMapGraph()}.
	 */
	@Test
	public void testAdjacencyMapGraph() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		Assert.assertEquals(false, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#AdjacencyMapGraph(boolean)}.
	 */
	@Test
	public void testAdjacencyMapGraphBoolean() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		Assert.assertEquals(true, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#edges()}.
	 */
	@Test
	public void testEdges() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);	

		Iterator<Edge<Integer>> itr = graph.edges().iterator();
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		Assert.assertEquals((Integer) 5, itr.next().getElement());
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#getEdge(edu.ncsu.csc316.dsa.graph.Graph.Vertex, edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testGetEdge() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);	
		
		Assert.assertEquals((Integer) 5, graph.getEdge(v3, v1).getElement());
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#outDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutDegree() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		
		Assert.assertEquals(1, graph.outDegree(v1));
		
		graph.insertEdge(v1, v3, 7);
		Assert.assertEquals(2, graph.outDegree(v1));	
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#inDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testInDegree() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		
		Assert.assertEquals(2, graph.inDegree(v1));	
	}
	
	/**
	 * Test for directed stuff
	 */
	@Test
	public void testInDegreeDirected() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		
		Assert.assertEquals(1, graph.inDegree(v1));
		
		graph.insertEdge(v2, v1, 7);
		Assert.assertEquals(2, graph.inDegree(v1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#outgoingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutgoingEdges() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.outgoingEdges(v2).iterator();
		Assert.assertEquals(false, itr.hasNext());
		
		graph.insertEdge(v1, v3, 7);	
		itr = graph.outgoingEdges(v1).iterator();
		int numEdge = itr.next().getElement();
		boolean result = (numEdge == 3 || numEdge == 7);
		Assert.assertTrue(result);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#incomingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testIncomingEdges() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.incomingEdges(v2).iterator();
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		
		graph.insertEdge(v2, v1, 7);	
		itr = graph.incomingEdges(v1).iterator();
		int numEdge = itr.next().getElement();
		boolean result = (numEdge == 5 || numEdge == 7);
		Assert.assertTrue(result);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#removeVertex(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testRemoveVertex() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		graph.insertVertex("Lela");
		graph.removeVertex(v1);
		Assert.assertEquals("Lela", graph.vertices().iterator().next().getElement());
		Assert.assertEquals(1, graph.numVertices());
	}
	
	/**
	 * Test remove directed vertex
	 */
	@Test
	public void testRemoveVertexDirected() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");

		graph.insertEdge(v1 , v2, 3);		
		graph.insertEdge(v3 , v1, 3);		
		graph.removeVertex(v1);
		Assert.assertEquals("Lela", graph.vertices().iterator().next().getElement());
		Assert.assertEquals(2, graph.numVertices());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMapGraph#removeEdge(edu.ncsu.csc316.dsa.graph.Graph.Edge)}.
	 */
	@Test
	public void testRemoveEdge() {
		AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);		
		graph.removeEdge(e1);
		Assert.assertEquals(0, graph.numEdges());
		Assert.assertEquals(false, graph.edges().iterator().hasNext());	}

}
