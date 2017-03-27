/**
 * 
 */
package assignment09;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Graph object, links nodes with edges.
 * 
 * @author markvandermerwe
 */
public class Graph {

	private Node[] vertices;
	private ArrayList<HashSet<Integer>> adjacent;

	private int edges;

	/**
	 * Node object, referring to the vertices of our Graph.
	 * 
	 * @author markvandermerwe
	 */
	private class Node {

	}

	/**
	 * Constructor that defines the size of the graph.
	 * 
	 * @param size
	 *            - number of vertices.
	 */
	public Graph(int size) {
		vertices = new Node[size];
		adjacent = new ArrayList<HashSet<Integer>>(size);
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
		adjacent.get(Node1).add(Node2);
		adjacent.get(Node2).add(Node1);
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
		return adjacent.get(Node);
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
