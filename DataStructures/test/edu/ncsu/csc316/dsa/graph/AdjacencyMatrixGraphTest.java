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
public class AdjacencyMatrixGraphTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#AdjacencyMatrixGraph()}.
	 */
	@Test
	public void testAdjacencyMatrixGraph() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		Assert.assertEquals(false, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#AdjacencyMatrixGraph(boolean)}.
	 */
	@Test
	public void testAdjacencyMatrixGraphBoolean() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		Assert.assertEquals(true, graph.isDirected());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#edges()}.
	 */
	@Test
	public void testEdges() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
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
	 * Test endVertices
	 */
	@Test
	public void testEndVertices() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);	
		Vertex<String>[] vertices = graph.endVertices(e1);
		Assert.assertEquals("Nick", vertices[0].getElement());
		Assert.assertEquals("Lela", vertices[1].getElement());
	}
	/**
	 * Test opposite
	 */
	@Test
	public void testOpposite() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);	
		Vertex<String> opposite = graph.opposite(v2, e1);
		Assert.assertEquals("Nick", opposite.getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#getEdge(edu.ncsu.csc316.dsa.graph.Graph.Vertex, edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testGetEdge() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);	
		
		Assert.assertEquals((Integer) 5, graph.getEdge(v3, v1).getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#outDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutDegree() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#inDegree(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testInDegree() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
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
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#outgoingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testOutgoingEdges() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.outgoingEdges(v2).iterator();
		Assert.assertEquals(false, itr.hasNext());
		
		graph.insertEdge(v1, v3, 7);	
		itr = graph.outgoingEdges(v1).iterator();
		Assert.assertEquals(true, itr.next().getElement() == 3 || itr.next().getElement() == 7);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#incomingEdges(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testIncomingEdges() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Vertex<String> v3 = graph.insertVertex("Luka");
		graph.insertEdge(v1 , v2, 3);	
		graph.insertEdge(v3 , v1, 5);		
		Iterator<Edge<Integer>> itr = graph.incomingEdges(v2).iterator();
		Assert.assertEquals((Integer) 3, itr.next().getElement());
		
		graph.insertEdge(v2, v1, 7);	
		itr = graph.incomingEdges(v1).iterator();
		Assert.assertEquals( (Integer) 7, itr.next().getElement());
		Assert.assertEquals( (Integer) 5, itr.next().getElement());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#removeVertex(edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testRemoveVertex() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
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
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>(true);
		
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
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.AdjacencyMatrixGraph#removeEdge(edu.ncsu.csc316.dsa.graph.Graph.Edge)}.
	 */
	@Test
	public void testRemoveEdge() {
		AdjacencyMatrixGraph<String, Integer> graph = new AdjacencyMatrixGraph<String, Integer>();
		
		Vertex<String> v1 = graph.insertVertex("Nick");
		Vertex<String> v2 = graph.insertVertex("Lela");
		Edge<Integer> e1 = graph.insertEdge(v1 , v2, 3);		
		graph.removeEdge(e1);
		Assert.assertEquals(0, graph.numEdges());
		Assert.assertEquals(false, graph.edges().iterator().hasNext());	}

}
