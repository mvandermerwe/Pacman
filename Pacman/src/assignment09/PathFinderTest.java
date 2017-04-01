/**
 * 
 */
package assignment09;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrew Haas
 *
 */
public class PathFinderTest {
	
	
	@Test
	public void testReadFromFile() {
		try{
			PathFinder.readFromFile("mazes/tinyMaze.txt");
		}catch(Exception e){
			fail("Should have found the file");
		}
	}
	
	@Test
	public void testSolveMaze() {
		try{
		PathFinder.solveMaze("mazes/tinyMaze.txt", "mazes/Solved.txt");
		}
		catch(Exception e){
			fail("Should have found the file");
		}
	}

}
