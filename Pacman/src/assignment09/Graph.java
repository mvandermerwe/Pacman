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

	private ArrayList<Node> vertices;

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
		 * @param Node2
		 *            - Node index to connect to.
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
		vertices = new ArrayList<>(size);
	}

	public void addVertex(int position) {
		vertices.set(position, new Node());
	}

	/**
	 * Adds an edge to our graph.
	 * 
	 * @param Node1
	 *            - position of first node
	 * @param Node2
	 *            - position of second node.
	 */
	public void addEdge(int node1, int node2) {
		vertices.get(node1).addAdjacent(node2);
		vertices.get(node2).addAdjacent(node1);
		edges++;
	}
	
	/**
	 * Adds multiple edges for a given Node.
	 * 
	 * @param node
	 * @param adjacentNodes
	 */
	public void addEdges(int node, int[] adjacentNodes) {
		for(int adjacentNode: adjacentNodes) {
			addEdge(node, adjacentNode);
		}
	}

	/**
	 * Return all adjacent Nodes to a provided Node.
	 * 
	 * @param Node
	 *            - Node whose adjacents we want to find.
	 * @return - adjacent nodes to provided Node.
	 */
	public HashSet<Integer> getAdjacent(int Node) {
		return vertices.get(Node).getAdjacent();
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
		return vertices.size();
	}

	/**
	 * Getter for Node at index.
	 * 
	 * @param nodeIndex
	 *            - index of Node.
	 * @return - Node at index.
	 */
	public Node getNode(int nodeIndex) {
		return vertices.get(nodeIndex);
	}

	/**
	 * To string for debug purposes. Points each node to its adjacents.
	 */
	public String toString() {
		String toString = "";
		for (int index = 0; index < vertices.size(); index++) {
			toString += index + " -> " + vertices.get(index).getAdjacent().toString();
		}
		return toString;
	}

}
