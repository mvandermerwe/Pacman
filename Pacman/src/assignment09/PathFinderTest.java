/**
 * I pledge that the work done here was my own and that I have learned how to write
this program (such that I could throw it out and restart and finish it in a timely
manner).  I am not turning in any work that I cannot understand, describe, or
recreate.  Any sources (e.g., web sites) other than the lecture that I used to
help write the code are cited in my work.  When working with a partner, I have
contributed an equal share and understand all the submitted work.  Further, I have
helped write all the code assigned as pair-programming and reviewed all code that
was written separately.
	                      (Mark Van der Merwe, Andrew Haas)
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
