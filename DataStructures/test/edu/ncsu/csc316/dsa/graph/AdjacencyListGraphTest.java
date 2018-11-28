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
public class AdjacencyListGraphTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#AdjacencyListGraph()}.
	 */
	@Test
	public void testAdjacencyListGraph() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		Assert.assertEquals(false, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#AdjacencyListGraph(boolean)}.
	 */
	@Test
	public void testAdjacencyListGraphBoolean() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		Assert.assertEquals(true, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#edges()}.
	 */
	@Test
	public void testEdges() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#outgoingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutgoingEdges() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.outgoingEdges(v2).iterator();
		Assert.assertEquals(false, itr.hasNext());
		
		graph.insertEdge(v1, v3, 7);	
		itr = graph.outgoingEdges(v1).iterator();
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		Assert.assertEquals((Integer) 7, itr.next().getElement());
		}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#incomingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testIncomingEdges() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.incomingEdges(v2).iterator();
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		
		graph.insertEdge(v2, v1, 7);	
		itr = graph.incomingEdges(v1).iterator();
		Assert.assertEquals((Integer) 5, itr.next().getElement());
		Assert.assertEquals((Integer) 7, itr.next().getElement());

	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#getEdge(edu.ncsu.csc316.dsa.graph.Graph.Vertex, edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testGetEdge() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);	
		
		Assert.assertEquals((Integer) 5, graph.getEdge(v3, v1).getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#outDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutDegree() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		
		Assert.assertEquals(1, graph.outDegree(v1));
		
		graph.insertEdge(v1, v2, 7);
		Assert.assertEquals(2, graph.outDegree(v1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#inDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testInDegree() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		
		Assert.assertEquals(2, graph.inDegree(v1));
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#inDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testInDegreeDirected() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#insertVertex(java.lang.Object)}.
	 */
	@Test
	public void testInsertVertex() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		graph.insertVertex("Nick");
		Iterator<Vertex<String>> itr = graph.vertices().iterator();
		Assert.assertEquals("Nick", itr.next().getElement());
		Assert.assertEquals(1, graph.numVertices());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#insertEdge(edu.ncsu.csc316.dsa.graph.Graph.Vertex, edu.ncsu.csc316.dsa.graph.Graph.Vertex, java.lang.Object)}.
	 */
	@Test
	public void testInsertEdge() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		
		graph.insertEdge(v1 , v2, 3);
		Iterator<Edge<Integer>> itr = graph.edges().iterator();
		
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		
		Assert.assertEquals(1, graph.numEdges());	
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#removeVertex(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testRemoveVertex() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
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
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyListGraph#removeEdge(edu.ncsu.csc316.dsa.graph.Graph.Edge)}.
	 */
	@Test
	public void testRemoveEdge() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);		
		graph.removeEdge(e1);
		Assert.assertEquals(0, graph.numEdges());
		Assert.assertEquals(false, graph.edges().iterator().hasNext());
	}


	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AbstractGraph#endVertices(edu.ncsu.csc316.dsa.graph.Graph.Edge)}.
	 */
	@Test
	public void testEndVertices() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);		
		
		Vertex<String>[] ends = graph.endVertices(e1);
		Assert.assertEquals("Nick", ends[0].getElement());
		Assert.assertEquals("Lela", ends[1].getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AbstractGraph#opposite(edu.ncsu.csc316.dsa.graph.Graph.Vertex, edu.ncsu.csc316.dsa.graph.Graph.Edge)}.
	 */
	@Test
	public void testOpposite() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);		
		
		Assert.assertEquals("Lela", graph.opposite(v1, e1).getElement());
		Assert.assertEquals("Nick", graph.opposite(v2, e1).getElement());
	}


}
