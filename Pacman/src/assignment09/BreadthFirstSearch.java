/**
 * 
 */
package assignment09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import assignment09.Graph.Node;

/**
 * Breadth first search algorithm to find the shortest path between two points
 * in our pacman packs.
 * 
 * @author Mark Van der Merwe and Andrew Haas
 */
public class BreadthFirstSearch {

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
		this.finish = finish;

		graph.getVertex(start).marked = true;
	}

	/**
	 * Performs the bulk of the work by walking breadth first through the nodes
	 * of the graph until we find our finish.
	 * 
	 * @return - integer array path from start to finish.
	 */
	public Integer[] breadthFirstSearch() {
		// Add new nodes and dequeue old ones.
		// Use ArrayDeque because is faster as a Queue than LinkedList.
		Queue<Node> nodes = new ArrayDeque<Node>();
		nodes.add(graph.getVertex(start));

		while (!nodes.isEmpty()) {
			// Continue to add new nodes and dequeue old ones.
			Node node = nodes.remove();
			HashSet<Node> adjacentTo = graph.getAdjacent(node.id);
			for (Node adjacentNode : adjacentTo) {
				// If we've already seen this node, skip over it.
				if (adjacentNode.marked) {
					continue;
				}

				// Add new nodes to the queue.
				nodes.add(adjacentNode);
				adjacentNode.marked = true;
				adjacentNode.back = node;

				// If we find our finish node, create and return our path.
				if (adjacentNode.id == finish) {
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
	public Integer[] generatePath(Node pathEnd) {
		ArrayList<Integer> path = new ArrayList<Integer>();

		// Follow the path back to the seed.
		while (pathEnd != null) {
			path.add(0, pathEnd.id);
			pathEnd = pathEnd.back;
		}

		Integer[] pathArray = new Integer[path.size()];
		return path.toArray(pathArray);
	}

}
