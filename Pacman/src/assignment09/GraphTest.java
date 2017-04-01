/**
 * I pledge that the work done here was my own and that I have learned how to write
this program (such that I could throw it out and restart and finish it in a timely
manner).  I am not turning in any work that I cannot understand, describe, or
recreate.  Any sources (e.g., web sites) other than the lecture that I used to
help write the code are cited in my work.  When working with a partner, I have
contributed an equal share and understand all the submitted work.  Further, I have
helped write all the code assigned as pair-programming and reviewed all code that
was written separately.
	                      (Mark Van der Merwe, Andrew Haas)
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
	Graph oneGraph;

	/**
	 * Sets up the graphs that are to be used in the test methods.
	 */
	@Before
	public void createGraph() {
		// Create three graphs to test with, one with 4 vertices, one with 1,
		// one with 0.
		graph = new Graph(4);
		for (int i = 0; i < 4; i++) {
			graph.addVertex(i);
		}
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(0, 1);
		graph.addEdge(3, 2);

		zeroGraph = new Graph(0);

		oneGraph = new Graph(1);
		oneGraph.addVertex(0);

	}

	/**
	 * Tests to make sure that the constructor is working properly.
	 */
	@Test
	public void testConstructor() {
		// Test our constructor is working properly by looking at the toString.
		assertEquals("0 -> [2, 1]\n1 -> [2, 0]\n2 -> [0, 1, 3]\n3 -> [2]\n", graph.toString());

		assertEquals("", zeroGraph.toString());

		assertEquals("0 -> []\n", oneGraph.toString());
	}

	/**
	 * Tests to make sure that all the adjacent nodes are correctly counted.
	 */
	@Test
	public void testGetAdjacent() {
		// Use size of adjacent set to make sure adding edges works correctly.
		assertEquals(2, graph.getAdjacent(0).size());

		try {
			zeroGraph.getAdjacent(0).size();
			fail("Shouldn't find anything.");
		} catch (Exception e) {
			// Test passes.
		}

		assertEquals(0, oneGraph.getAdjacent(0).size());
	}

	/**
	 * Tests to make sure that the number of vertices in the graph are correctly
	 * counted.
	 */
	@Test
	public void testNumOfVertices() {
		assertEquals(4, graph.numOfVertices());
		assertEquals(0, zeroGraph.numOfVertices());
		assertEquals(1, oneGraph.numOfVertices());
	}

	/**
	 * Tests to make sure that the number of edges in the graph are counted
	 * correctly.
	 */
	@Test
	public void testNumOfEdges() {
		assertEquals(4, graph.numOfVertices());
		assertEquals(0, zeroGraph.numOfEdges());
		assertEquals(0, oneGraph.numOfEdges());
	}

	/**
	 * Tests to make sure that getVertex correctly returns the right Node.
	 */
	@Test
	public void testGetVertice() {
		assertEquals("3", graph.getVertex(3).toString());

		try {
			zeroGraph.getVertex(0);
			fail("Should've thrown error, array index doesn't work.");
		} catch (IndexOutOfBoundsException e) {
			// Test passes.
		}

		assertEquals("0", oneGraph.getVertex(0).toString());
	}

}
