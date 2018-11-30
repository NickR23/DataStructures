/**
 * 
 */
package edu.ncsu.csc316.dsa.graph;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import org.junit.Assert;
/**GraphTraversal tests
 * @author nicholasrrichardson
 *
 */
public class GraphTraversalUtilTest {

	AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
	private Vertex<String> v1;
	private Vertex<String> v2;
	private Vertex<String> v3;
	private Vertex<String> v4;
	private Vertex<String> v5;
	
	private Edge<Integer> e1;
	private Edge<Integer> e2;
	private Edge<Integer> e3;
	//private Edge<Integer> e4;

	/**Set up operations
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		v1 = graph.insertVertex("Nick");
		v2 = graph.insertVertex("Lela");
		v3 = graph.insertVertex("Luka");
		v4 = graph.insertVertex("Pepper");
		v5 = graph.insertVertex("Honey");

		
		e1 = graph.insertEdge(v1, v2, 23);
		e2 = graph.insertEdge(v2, v3, 3);
		e3 = graph.insertEdge(v3, v4, 40);
		//e4 = graph.insertEdge(v2, v4, 10);
		graph.insertEdge(v4, v5, 10);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.GraphTraversalUtil#depthFirstSearch(edu.ncsu.csc316.dsa.graph.Graph, edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testDepthFirstSearch() {

		Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.depthFirstSearch(graph, v2);
		Assert.assertEquals(e1, map.get(v1));
		Assert.assertEquals(e2, map.get(v3));
		Assert.assertEquals(e3, map.get(v4));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.dsa.graph.GraphTraversalUtil#breadthFirstSearch(edu.ncsu.csc316.dsa.graph.Graph, edu.ncsu.csc316.dsa.graph.Graph.Vertex)}.
	 */
	@Test
	public void testBreadthFirstSearch() {
		Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.breadthFirstSearch(graph, v2);
		Assert.assertEquals(e1, map.get(v1));
		Assert.assertEquals(e2, map.get(v3));
	}

}
