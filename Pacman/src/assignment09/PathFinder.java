/**
 * 
 */
package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Determines the shortest path given a scenario using Graph path finding,
 * specifically Breadth First Search.
 * 
 * @author markvandermerwe
 */
public class PathFinder {

	public static void main(String[] args) {
		solveMaze("mazes/tinyMaze.txt", "");
	}

	private static int[][] maze;
	private static int[] dimensions;
	private static BufferedReader mazeReader;

	private static int start;
	private static int finish;

	/**
	 * Solve the pacman maze by turning the provided maze file into a graph,
	 * using BFS to find shortest path, then writing the solution onto an
	 * outputfile.
	 * 
	 * @param inputFileName
	 *            - txt file to read maze from.
	 * @param outputFileName
	 *            - txt file to write solution to.
	 */
	public static void solveMaze(String inputFileName, String outputFileName) {
		// Read the vals into our maze array.
		try {
			readFromFile(inputFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		Graph mazeGraph = new Graph();

		// Add all the vertices in our maze into the graph.
		for (int row = 0; row < dimensions[0]; row++) {
			for (int col = 0; col < dimensions[1]; col++) {
				if (maze[row][col] != -1) {
					mazeGraph.addVertex(maze[row][col]);
				}
			}
		}

		// Add the edges.
		for (int row = 1; row < dimensions[0] - 1; row++) {
			for (int col = 1; col < dimensions[1] - 1; col++) {
				if (maze[row][col] != -1) {
					if (maze[row + 1][col] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row + 1][col]);
					}
					if (maze[row - 1][col] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row - 1][col]);
					}
					if (maze[row][col + 1] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row][col + 1]);
					}
					if (maze[row][col - 1] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row][col - 1]);
					}
				}
			}
		}
		System.out.println(mazeGraph.toString());

		// Perform breadth first search on our start and finish.
		BreadthFirstSearch search = new BreadthFirstSearch(mazeGraph, start, finish);
		Integer[] path = search.breadthFirstSearch();
		System.out.println(Arrays.toString(path));
	}

	/**
	 * Reads the values from the provided file into our Maze array. Represents
	 * Xs as -1 and each open space or Start/Goal as its index in the Graph's
	 * array.
	 * 
	 * @param file
	 *            - txt file to grab the maze from.
	 * @throws Exception
	 *             - If the maze doesn't have a rectangular border of Xs, throw
	 *             exception.
	 */
	public static void readFromFile(String file) throws Exception {
		try {
			// Set up our buffered reader with the provided file name.
			mazeReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		try {
			// Read and determine the dimensions of our maze based on the first
			// line.
			String firstLine = mazeReader.readLine();
			Scanner scanner = new Scanner(firstLine);
			dimensions = new int[2];
			for (int index = 0; scanner.hasNext(); index++) {
				dimensions[index] = scanner.nextInt();
			}

			maze = new int[dimensions[0]][dimensions[1]];
		} catch (IOException e) {
			System.out.println("First line not set up correctly.");
			System.exit(0);
		}

		try {
			int position = 0;
			for (int row = 0; row < dimensions[0]; row++) {
				for (int col = 0; col < dimensions[1]; col++) {
					char letter = (char) mazeReader.read();

					// If the boundaries are not Xs, the file is illegal and we
					// throw an exception.
					if ((row == 0 || row == dimensions[0] - 1 || col == 0 || col == dimensions[1] - 1) && letter != 'X')
						throw new Exception("Illegal File Format");

					if (letter == ' ') {
						maze[row][col] = position;
						position++;
					} else if (letter == 'X') {
						maze[row][col] = -1;
					} else if (letter == 'S') {
						start = position;
						maze[row][col] = position;
						position++;
					} else if (letter == 'G') {
						finish = position;
						maze[row][col] = position;
						position++;
					}
				}
				// Skip new line at the end of each row.
				mazeReader.skip(1);
			}
		} catch (IOException e) {
			System.out.println("Failed to read from file.");
			System.exit(0);
		}
	}

}
