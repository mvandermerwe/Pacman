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
	
	public static void solveMaze(String inputFileName, String outputFileName) {
		readFromFile(inputFileName);
		
		Graph mazeGraph = new Graph();
		
		for(int row = 0; row < dimensions[0]; row++) {
			for(int col = 0; col < dimensions[1]; col++) {
				if(maze[row][col] != -1) {
					mazeGraph.addVertex(maze[row][col]);
				}
			}
		}
		
		for(int row = 1; row < dimensions[0]-1; row++) {
			for(int col = 1; col < dimensions[1]-1; col++) {
				if(maze[row][col] != -1) {
					if(maze[row+1][col] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row+1][col]);
					}
					if(maze[row-1][col] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row-1][col]);
					}
					if(maze[row][col+1] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row][col+1]);
					}
					if(maze[row][col-1] != -1) {
						mazeGraph.addEdge(maze[row][col], maze[row][col-1]);
					}
				}
			}
		}
		System.out.println(mazeGraph.toString());
		
		BreadthFirstSearch search = new BreadthFirstSearch(mazeGraph, start, finish);
		Integer[] path = search.breadthFirstSearch();
		System.out.println(Arrays.toString(path));
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
			
			maze = new int[dimensions[0]][dimensions[1]];
		} catch (IOException e) {
			System.out.println("Line broke cause of something");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			int position = 0;
			for(int row = 0; row < dimensions[0]; row++) {
				for(int col = 0; col < dimensions[1]; col++) {
					char letter = (char) mazeReader.read();
					if(letter == ' ') {
						maze[row][col] = position;
						position++;
					}else if(letter == 'X') {
						maze[row][col] = -1;
					}else if(letter == 'S') {
						start = position;
						maze[row][col] = position;
						position++;
					}else if(letter == 'G') {
						finish = position;
						maze[row][col] = position;
						position++;
					}
				}
				mazeReader.skip(1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
