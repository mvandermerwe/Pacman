/**
 * 
 */
package assignment09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the functionality of our Graph data structure.
 * 
 * @author Mark Van der Merwe and Andrew Haas
 */
public class GraphTest {
	Graph graph;
	Graph zeroGraph;

	/**
	 * Sets up the graphs that are to be used in the test methods.
	 */
	@Before
	public void createGraph() {
		graph = new Graph(4);
		for (int i = 0; i < 4; i++) {
			graph.addVertex(i);
		}
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(0, 1);
		graph.addEdge(3, 2);
		zeroGraph = new Graph(0);

	}

	/**
	 * Tests to make sure that the constructor is working properly.
	 */
	@Test
	public void testConstructor() {
		System.out.println(graph.toString());
		assertEquals("0 -> [1, 2]\n1 -> [2, 0]\n2 -> [1, 3, 0]\n3 -> [2]\n", graph.toString());
		assertEquals("", zeroGraph.toString());
	}

	/**
	 * Tests to make sure that all the adjacent nodes are correctly counted.
	 */
	@Test
	public void testGetAdjacent() {
		assertEquals(2, graph.getAdjacent(0).size());
		try {
			zeroGraph.getAdjacent(0).size();
			fail("Shouldn't find anything.");
		} catch (Exception e) {
			// Test passes.
		}
	}

	/**
	 * Tests to make sure that the number of vertices in the graph are correctly
	 * counted.
	 */
	@Test
	public void testNumOfVertices() {
		assertEquals(4, graph.numOfVertices());
		assertEquals(0, zeroGraph.numOfVertices());

	}

	/**
	 * Tests to make sure that the number of edges in the graph are counted
	 * correctly.
	 */
	@Test
	public void testNumOfEdges() {
		assertEquals(4, graph.numOfVertices());
		assertEquals(0, zeroGraph.numOfEdges());
	}

	/**
	 * Tests to make sure that getVertex correctly returns the right Node.
	 */
	@Test
	public void testGetVertice() {
		Graph graph2 = new Graph(4);
		for (int i = 0; i < 4; i++) {
			graph2.addVertex(i);
		}
		graph2.addEdge(0, 2);
		graph2.addEdge(1, 2);
		graph2.addEdge(0, 1);
		graph2.addEdge(3, 2);
		assertEquals(graph2.getVertex(3).toString(), graph.getVertex(3).toString());
	}

}
