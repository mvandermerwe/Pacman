/**
 * 
 */
package assignment09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author markvandermerwe
 *
 */
public class BreadthFirstSearchTest {
	Graph graph;
	Graph zeroGraph;
	BreadthFirstSearch bfs;
	
	@Before
	public void createGraph() {
		graph = new Graph(4);
		for(int i = 0; i<4;i++){
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
	 * This tests the generatePath method and makes sure
	 * the path is correct. Cannot test a zero case because 
	 * it would never be called.
	 */
	@Test
	public void testGeneratePath() {
		bfs.breadthFirstSearch();
		Integer[] array = new Integer[] {0,2,3};
		assertArrayEquals(array,bfs.generatePath(graph.getVertex(3)));
		
	}
	
	@Test
	public void testBreadthFirstSearch() {
		Integer[] array = new Integer[] {0,2,3};
		assertArrayEquals(array,bfs.breadthFirstSearch());
		
	}

}
