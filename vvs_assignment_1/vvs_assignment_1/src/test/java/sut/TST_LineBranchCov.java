package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;

public class TST_LineBranchCov {

	@Test
	public void testSize() {
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		tst.put("k2", 1);
		tst.put("k3", 2);
		tst.put("k4", 3);
		assertEquals(4, tst.size());
	}

	@Test
	public void testContains_KeyNull(){
		TST<Integer> tst = new TST<>();
		assertThrows(IllegalArgumentException.class, () -> tst.contains(null));  
	}

	@Test
	public void testNotContains_KeyNotNull(){
		TST<Integer> tst = new TST<>();
		assertEquals(false,tst.contains("k"));
	}

	@Test
	public void testContains_KeyNotNull(){
		TST<Integer> tst = new TST<>();
		tst.put("k", 0);
		assertEquals(true,tst.contains("k"));
	}


	@Test
	public void testGet_KeyNull() {
		TST<Integer> tst = new TST<>();
		assertThrows(IllegalArgumentException.class, () -> tst.get(null));  
	}

	@Test
	public void testGet_KeyLengthZero() {
		TST<Integer> tst = new TST<>();
		assertThrows(IllegalArgumentException.class, () -> tst.get(""));  
	}

	@Test
	public void testGet_KeyDontExist() {
		TST<Integer> tst = new TST<>();
		tst.put("k1",0);
		assertNull(tst.get("k2"));
	}

	@Test
	public void testGet_KeyExist() {
		TST<Integer> tst = new TST<>();
		tst.put("k1",0);
		tst.put("k2",1);
		assertEquals(1,tst.get("k2").intValue());
	}




	@Test
	public void testPut_KeyNull(){
		TST<Integer> tst = new TST<>();
		assertThrows(IllegalArgumentException.class, () -> tst.put(null, 0));  
	}

	@Test
	public void testPut_NotContainsKey(){
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		assertEquals(1, tst.size());
	}

	@Test
	public void testPut_ContainsKey(){
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		tst.put("k1", 3);
		assertEquals(3, tst.get("k1").intValue());
	}

	
	
	
	@Test
	public void testLPO_QueryNull(){
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		assertThrows(IllegalArgumentException.class, () -> tst.longestPrefixOf(null));  
	}
	
	@Test
	public void testLPO_EmptyTrie(){
		TST<Integer> tst = new TST<>();
		assertEquals("", tst.longestPrefixOf("a"));
		}

	@Test
	public void testLPO_QueryLengthZero(){
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		assertNull(tst.longestPrefixOf(""));
	}


	@Test
	public void testLPO_QueryFindsPrefix(){
		TST<Integer> tst = new TST<>();
		tst.put("shells", 1);
		tst.put("she", 2);
		tst.put("mar", 3);
		assertEquals("shells", tst.longestPrefixOf("shellsort"));
		assertEquals("she", tst.longestPrefixOf("shell"));
		
	}

	@Test
	public void  testLPO_NoMatch() {
		TST<Integer> tst = new TST<>();
		tst.put("sea", 1);
		tst.put("shore", 2);
		assertEquals("", tst.longestPrefixOf("shells"));
	}

	@Test
	public void testKeys() {
		TST<Integer> tst = new TST<>();
		tst.put("sea", 1);
		tst.put("shore", 2);
		tst.put("she", 3);
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("sea");
		expected.add("she");
		expected.add("shore");
		
		ArrayList<String> atual = new ArrayList<>();
		for(String k : tst.keys()) {
			atual.add(k);
		}
		assertEquals(expected, atual);

	}
	
	@Test
	public void testKWP_nullPrefix() {
		TST<Integer> tst = new TST<>();
		assertThrows(IllegalArgumentException.class, () -> tst.keysWithPrefix(null));  
	}
	
	@Test
	public void testKWP_prefixDontExist() {
		TST<Integer> tst = new TST<>();
		tst.put("sea", 1);
		tst.put("shore", 2);
		tst.put("she", 3);
		Queue<String> queue = new LinkedList<>();
		assertEquals(queue , tst.keysWithPrefix("a"));  
	}
	
	@Test
	public void testKWP_prefixExist() {
		TST<Integer> tst = new TST<>();
		tst.put("sea", 1);
		tst.put("shore", 2);
		tst.put("she", 3);
		
		/*PARA VAL != NULL*/
		ArrayList<String> expected = new ArrayList<>();
		expected.add("she");
		
		ArrayList<String> atual = new ArrayList<>();
		for(String k : tst.keysWithPrefix("she")) {
			atual.add(k); 
		}
		assertEquals(expected ,atual);  
		
		
		/*PARA VAL = NULL*/
		ArrayList<String> expected2 = new ArrayList<>();
		expected.add("she");
		expected.add("shore");
		
		ArrayList<String> atual2 = new ArrayList<>();
		for(String k : tst.keysWithPrefix("sh")) {
			atual.add(k); 
		}
		assertEquals(expected2 ,atual2);  
	}
	
	@Test
	public void testKeysThaMatch() {
		TST<Integer> tst = new TST<>();
		tst.put("sells", 1);
		tst.put("by", 2);
		tst.put("shore", 3);
		tst.put("sea", 4);
		tst.put("ana", 4);
		
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("sells");
		expected.add("shore");
		expected.add("by");
		expected.add("ana");
		
		ArrayList<String> atual = new ArrayList<>();
		for(String k : tst.keysThatMatch("s....")) {
			atual.add(k); 
		}
		
		for(String k : tst.keysThatMatch(".y")) {
			atual.add(k); 
		}
		
		for(String k : tst.keysThatMatch("a.a")) {
			atual.add(k); 
		}
		
		

		assertEquals(expected, atual);

	}

	
	


}
