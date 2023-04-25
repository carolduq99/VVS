package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;
public class LongestPrefixOf_EPC_PPC {

	
//	//EDGE-PAIR-COVERAGE
	@Test
	public void edgePairCoverage() throws FileNotFoundException{
		Scanner sc = new Scanner(new File("data/someWords.txt"));
		TST<Integer> tst = new TST<>();
		assertEquals("", tst.longestPrefixOf("a"));
		
		int i=0;
		while(sc.hasNextLine()) {
			String[] keys = sc.nextLine().split(" ");
			for(String key : keys)
				tst.put(key, ++i);
		}
		
		assertThrows(IllegalArgumentException.class, () -> tst.longestPrefixOf(null)); 
		assertNull(tst.longestPrefixOf("")); 
		assertEquals("she", tst.longestPrefixOf("shell"));  
		assertEquals("by", tst.longestPrefixOf("bycicle"));  
		assertEquals("the", tst.longestPrefixOf("then"));
		assertEquals("", tst.longestPrefixOf("a"));
		assertEquals("", tst.longestPrefixOf("z"));
		
	}
	
	
//	//PRIME-PATH-COVERAGE
	@Test
	public void primePathCoverage() throws FileNotFoundException{
		Scanner sc = new Scanner(new File("data/someWords.txt"));
		TST<Integer> tst0 = new TST<>();
		assertEquals("", tst0.longestPrefixOf("a"));
		
		TST<Integer> tst1 = new TST<>();
		tst1.put("a", 0);
		assertEquals("a", tst1.longestPrefixOf("a"));
		

		TST<Integer> tst2 = new TST<>();
		
		int k=0;
		while(sc.hasNextLine()) {
			String[] keys = sc.nextLine().split(" ");
			for(String key : keys)
				tst2.put(key, ++k);
		}
		tst2.put("see", ++k);
		tst2.put("they", ++k);
		tst2.put("z", ++k);
		
		assertThrows(IllegalArgumentException.class, () -> tst2.longestPrefixOf(null)); 
		assertNull(tst2.longestPrefixOf("")); 
		assertEquals("sea", tst2.longestPrefixOf("seashell"));
		
		assertEquals("", tst2.longestPrefixOf("uva"));
		
		assertEquals("she", tst2.longestPrefixOf("shell"));
		
		assertEquals("", tst2.longestPrefixOf("ana"));
		
		assertEquals("see", tst2.longestPrefixOf("seen"));
		
		assertEquals("they", tst2.longestPrefixOf("they"));
		
		assertEquals("she", tst2.longestPrefixOf("shea"));
		
		assertEquals("she", tst2.longestPrefixOf("shes"));
		
		assertEquals("", tst2.longestPrefixOf("shop"));
				
//		
	}
	
}
