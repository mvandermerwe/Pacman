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
 * Test the functionality of our Breadth First Search.
 * 
 * @author Mark Van der Merwe and Andrew Haas
 */
public class BreadthFirstSearchTest {
	Graph graph;
	Graph zeroGraph;
	BreadthFirstSearch bfs;

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
		bfs = new BreadthFirstSearch(graph, 0, 3);
	}

	/**
	 * This tests the generatePath method and makes sure the path is correct.
	 * Cannot test a zero case because it would never be called.
	 */
	@Test
	public void testGeneratePath() {
		bfs.breadthFirstSearch();
		Integer[] array = new Integer[] { 0, 2, 3 };
		assertArrayEquals(array, bfs.generatePath(graph.getVertex(3)));

	}

	@Test
	public void testBreadthFirstSearch() {
		Integer[] array = new Integer[] { 0, 2, 3 };
		assertArrayEquals(array, bfs.breadthFirstSearch());

	}

}
