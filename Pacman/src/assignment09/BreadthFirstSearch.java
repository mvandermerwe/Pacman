/**
 * 
 */
package assignment09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * Breadth first search algorithm to find the shortest path between two points
 * in our pacman packs.
 * 
 * @author markvandermerwe
 */
public class BreadthFirstSearch {

	// Nifty Changes.
	// More nifty changes.
	// New nifty changes.

	private boolean[] marked;
	private Integer[] edgeTo;

	private final int start;
	private final int finish;

	private Graph graph;

	/**
	 * Constructor sets up an object to take care of completing a breadth first
	 * search on the provided graph.
	 * 
	 * @param graph
	 *            - Graph to perform BFS on.
	 * @param start
	 *            - starting node in graph.
	 * @param finish
	 *            - node we are searching for.
	 */
	public BreadthFirstSearch(Graph graph, int start, int finish) {
		this.graph = graph;
		this.start = start;
		marked[start] = true;
		this.finish = finish;

		marked = new boolean[graph.numOfVertices()];
		edgeTo = new Integer[graph.numOfVertices()];
	}

	/**
	 * Performs the bulk of the work by walking breadth first through the nodes
	 * of the graph until we find our finish.
	 * 
	 * @return - integer array path from start to finish.
	 */
	public Integer[] breadthFirstSearch() {
		// Add new nodes and dequeue old ones.
		Queue<Integer> nodes = new ArrayDeque<Integer>();
		nodes.add(start);

		while (!nodes.isEmpty()) {
			// Continue to add new nodes and dequeue old ones.
			int node = nodes.remove();
			HashSet<Integer> adjacentTo = graph.getAdjacent(node);
			for (Integer adjacentNode : adjacentTo) {
				// If we've already seen this node, skip over it.
				if (marked[adjacentNode]) {
					continue;
				}

				// Add new nodes to the queue.
				nodes.add(adjacentNode);
				marked[adjacentNode] = true;
				edgeTo[adjacentNode] = node;
				
				// If we find our finish node, create and return our path.
				if (adjacentNode == finish) {
					return generatePath(adjacentNode);
				}
			}
		}
		// If we don't find it return a null path.
		return null;
	}

	/**
	 * Generate a path from the given till the seed by following what pointed to
	 * it down till nothing points on anymore (i.e., we have reached the start
	 * or seed)
	 * 
	 * @param pathEnd
	 *            - where the path leads to from the start.
	 * @return - integer array path from start to the path end.
	 */
	public Integer[] generatePath(int pathEnd) {
		ArrayList<Integer> path = new ArrayList<Integer>();

		// Follow the path back to the seed.
		while (edgeTo[pathEnd] != null) {
			path.add(0, pathEnd);
			pathEnd = edgeTo[pathEnd];
		}

		Integer[] pathArray = new Integer[path.size()];
		return path.toArray(pathArray);
	}

}
