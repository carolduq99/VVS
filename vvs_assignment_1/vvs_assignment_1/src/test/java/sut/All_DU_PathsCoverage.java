package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;
public class All_DU_PathsCoverage {

	
	//ALL_DU PATHS-COVERAGE
	@Test
	public void edgePairCoverage() throws FileNotFoundException {
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
		tst2.put("z", ++k);
		tst2.put("ba", ++k);
		
		System.out.println("******************");
		assertThrows(IllegalArgumentException.class, () -> tst2.longestPrefixOf(null)); 
		System.out.println("******************");
		assertNull(tst2.longestPrefixOf("")); 
		System.out.println("******************shell");
		assertEquals("she", tst2.longestPrefixOf("shell")); 
		System.out.println("******************then");
		assertEquals("the", tst2.longestPrefixOf("then")); 
		System.out.println("******************seas");
		assertEquals("sea", tst2.longestPrefixOf("seas"));
		System.out.println("******************ana");
		assertEquals("", tst2.longestPrefixOf("ana"));
		System.out.println("******************shes");
		assertEquals("she", tst2.longestPrefixOf("shes"));
		System.out.println("******************uva");
		assertEquals("", tst2.longestPrefixOf("uva"));
		System.out.println("******************z");
		assertEquals("z", tst2.longestPrefixOf("z"));
		System.out.println("******************bx");
		assertEquals("", tst2.longestPrefixOf("bx"));
	}
	
}
