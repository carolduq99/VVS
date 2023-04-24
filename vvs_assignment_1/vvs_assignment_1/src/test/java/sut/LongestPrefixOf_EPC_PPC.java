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
		System.out.println("******************");
		
		int i=0;
		while(sc.hasNextLine()) {
			String[] keys = sc.nextLine().split(" ");
			for(String key : keys)
				tst.put(key, ++i);
		}
		
		assertThrows(IllegalArgumentException.class, () -> tst.longestPrefixOf(null)); 
		System.out.println("******************");
		assertNull(tst.longestPrefixOf("")); 
		System.out.println("******************shell");
		assertEquals("she", tst.longestPrefixOf("shell"));  
		System.out.println("******************bycicle");
		assertEquals("by", tst.longestPrefixOf("bycicle"));    
		System.out.println("******************then");
		assertEquals("the", tst.longestPrefixOf("then"));
		System.out.println("******************a");
		assertEquals("", tst.longestPrefixOf("a"));
		System.out.println("******************z");
		assertEquals("", tst.longestPrefixOf("z"));
		
	}
	
	
//	//PRIME-PATH-COVERAGE
	@Test
	public void primePathCoverage() throws FileNotFoundException{
		Scanner sc = new Scanner(new File("data/someWords.txt"));
		TST<Integer> tst0 = new TST<>();
		assertEquals("", tst0.longestPrefixOf("a"));
		System.out.println("******************");
		
		TST<Integer> tst1 = new TST<>();
		tst1.put("a", 0);
		System.out.println("******************ONLYONE");
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
		
		System.out.println("******************");
		assertThrows(IllegalArgumentException.class, () -> tst2.longestPrefixOf(null)); 
		System.out.println("******************");
		assertNull(tst2.longestPrefixOf("")); 
		System.out.println("******************seashell");
		assertEquals("sea", tst2.longestPrefixOf("seashell"));
		
		System.out.println("******************uva"); 
		assertEquals("", tst2.longestPrefixOf("uva"));
		
		System.out.println("******************shell");
		assertEquals("she", tst2.longestPrefixOf("shell"));
		
		System.out.println("******************ana");
		assertEquals("", tst2.longestPrefixOf("ana"));
		
		System.out.println("******************seen");
		assertEquals("see", tst2.longestPrefixOf("seen"));
		
		System.out.println("******************they");
		assertEquals("they", tst2.longestPrefixOf("they"));
		
		System.out.println("******************shea");
		assertEquals("she", tst2.longestPrefixOf("shea"));
		
		System.out.println("******************shes");
		assertEquals("she", tst2.longestPrefixOf("shes"));
		
		System.out.println("******************shop");
		assertEquals("", tst2.longestPrefixOf("shop"));
				
//		
	}
	
}
