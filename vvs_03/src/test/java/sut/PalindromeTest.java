package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static sut.Palindrome.isPalindrome;

/**
 * Software Verification and Validation
 * 
 * Master of Science in Computer Engineering
 * University of Lisbon
 * Faculty of Sciences
 * Department of Informatics
 * 
 * @author Diogo Poças (JUnit 5 conversion)
 * @version $Id: PalindromeTest.java 284 2023-03-03 $
 */

public class PalindromeTest {

	@Test
	public void testPalindromeAB() {
		String s = "ab";
		assertFalse(isPalindrome(s), "ab is not a palindrome");
	}
	
	@Test
	public void testPalindromeNull() {
		String s = null;
		assertThrows(NullPointerException.class, () -> {
			isPalindrome(s);
	    });
	}
	
	@Test
	public void testPalindromeA() {
		String s = "a";
		assertTrue(isPalindrome(s), "a is a palindrome");
	}
	
	@Test
	public void testPalindromeABCA() {
		String s = "abca";
		assertFalse(isPalindrome(s), "abca is not a palindrome");
	}
	
	@Test
	public void testPalindromeABBA() {
		String s = "abba";
		assertTrue(isPalindrome(s), "abba is a palindrome");
	}
}
