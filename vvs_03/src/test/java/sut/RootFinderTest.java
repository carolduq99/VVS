package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Software Verification and Validation
 * 
 * Master of Science in Computer Engineering
 * University of Lisbon
 * Faculty of Sciences
 * Department of Informatics
 * 
 * @author Diogo Poças (JUnit 5 conversion)
 * @version $Id: RootFinderTest.java 284 2023-03-03 $
 */

public class RootFinderTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStream() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	public void restoreStream() {
	    System.setOut(System.out);
	}
	
	@Test
	public void testRootFinderNoArgs() {
		String[] s = {};
		String expected = "1 solutions\nx=-1.000000\n";
		RootFinder.main(s);
		assertEquals(expected, outContent.toString(), "roots of x^2+2x+1");
	}
	
	@Test
	public void testRootFinderZeroRoots() {
		String[] s = {"1","0","1"};
		String expected = "0 solutions\n";
		RootFinder.main(s);
		assertEquals(expected, outContent.toString(), "roots of x^2+1");
	}
	
	@Test
	public void testRootFinderOneRoot() {
		String[] s = {"1","0","0"};
		String expected = "1 solutions\nx=-0.000000\n";
		RootFinder.main(s);
		assertEquals(expected, outContent.toString(), "roots of x^2");
	}
	
	@Test
	public void testRootFinderTwoRoots() {
		String[] s = {"1","0","-1"};
		String expected = "2 solutions\nx=-1.000000 or x=1.000000\n";
		RootFinder.main(s);
		assertEquals(expected, outContent.toString(), "roots of x^2-1");
	}
}
