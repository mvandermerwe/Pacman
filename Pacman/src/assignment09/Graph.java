/**
 * 
 */
package assignment09;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Graph object, links nodes with edges.
 * 
 * @author Mark Van der Merwe and Andrew Haas
 */
public class Graph {

	private Node[] vertices;

	private int edges;

	/**
	 * Node object, referring to the vertices of our Graph.
	 * 
	 * @author Mark Van der Merwe and Andrew Haas
	 */
	private class Node {

		boolean visited = false;
		private HashSet<Integer> adjacent;

		/**
		 * Default constructor.
		 */
		public Node() {
			adjacent = new HashSet<>();
		}

		/**
		 * Return the set of adjacent Nodes.
		 * 
		 * @return - set of adjacent Nodes.
		 */
		public HashSet<Integer> getAdjacent() {
			return adjacent;
		}

		/**
		 * Add an edge for this Node.
		 * 
		 * @param Node2 - Node index to connect to.
		 */
		public void addAdjacent(int Node2) {
			adjacent.add(Node2);
		}
	}

	/**
	 * Constructor that defines the size of the graph.
	 * 
	 * @param size
	 *            - number of vertices.
	 */
	public Graph(int size) {
		vertices = new Node[size];
	}

	/**
	 * Adds an edge to our graph.
	 * 
	 * @param Node1
	 *            - position of first node
	 * @param Node2
	 *            - position of second node.
	 */
	public void addEdge(int Node1, int Node2) {
		vertices[Node1].addAdjacent(Node2);
		vertices[Node2].addAdjacent(Node1);
		edges++;
	}

	/**
	 * Return all adjacent Nodes to a provided Node.
	 * 
	 * @param Node
	 *            - Node whose adjacents we want to find.
	 * @return - adjacent nodes to provided Node.
	 */
	public HashSet<Integer> getAdjacent(int Node) {
		return vertices[Node].getAdjacent();
	}

	/**
	 * Getter for num of edges.
	 * 
	 * @return num of edges.
	 */
	public int numOfEdges() {
		return edges;
	}

	/**
	 * Getter for num of vertices.
	 * 
	 * @return num of vertices.
	 */
	public int numOfVertices() {
		return vertices.length;
	}

	/**
	 * Getter for Node at index.
	 * 
	 * @param nodeIndex
	 *            - index of Node.
	 * @return - Node at index.
	 */
	public Node getNode(int nodeIndex) {
		return vertices[nodeIndex];
	}

}
