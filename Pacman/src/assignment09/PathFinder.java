/**
 * 
 */
package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	private static char[][] maze;
	private static int[] dimensions;
	private static BufferedReader mazeReader;
	
	private static int start;
	private static int finish;
	
	public static void solveMaze(String inputFileName, String outputFileName) {
		readFromFile(inputFileName);
		
		Graph mazeGraph = new Graph();
		int position = 0;
		for(int row = 0; row < dimensions[0]; row++) {
			for(int col = 0; col < dimensions[1]; col++) {
				if(maze[row][col] != 'X') {
					mazeGraph.addVertex(position);
					if(maze[row][col] == 'S') {
						start = position;
					}else if(maze[row][col] == 'G') {
						finish = position;
					}
					position++;
				}
			}
		}
		
		position = 0;
		for(int row = 0; row < dimensions[0]; row++) {
			for(int col = 0; col < dimensions[1]; col++) {
				if(maze[row][col] != 'X') {
					if(maze[row+1][col] != 'X') {
						mazeGraph.addEdge(position, node2);
					}
					position++;
				}
			}
		}
		System.out.println(mazeGraph.toString());
		
		BreadthFirstSearch search = new BreadthFirstSearch(mazeGraph, start, finish);
		Integer[] path = search.breadthFirstSearch();
		System.out.println(path.toString());
	}
	
	public static void readFromFile(String file){
		try {
			mazeReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			String firstLine = mazeReader.readLine();
			Scanner scanner = new Scanner(firstLine);
			dimensions = new int[2];
			for(int index = 0; scanner.hasNext(); index++) {
				dimensions[index] = scanner.nextInt();
			}
			
			maze = new char[dimensions[0]][dimensions[1]];
		} catch (IOException e) {
			System.out.println("Line broke cause of something");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			for(int row = 0; row < dimensions[0]; row++) {
				mazeReader.read(maze[row]);
				mazeReader.skip(1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
