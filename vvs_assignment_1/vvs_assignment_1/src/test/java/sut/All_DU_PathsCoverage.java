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
		tst2.put("z", ++k);
		tst2.put("ba", ++k);
		
		assertThrows(IllegalArgumentException.class, () -> tst2.longestPrefixOf(null)); 
	
		assertNull(tst2.longestPrefixOf("")); 
	
		assertEquals("she", tst2.longestPrefixOf("shell")); 

		assertEquals("the", tst2.longestPrefixOf("then")); 

		assertEquals("sea", tst2.longestPrefixOf("seas"));

		assertEquals("", tst2.longestPrefixOf("ana"));
	
		assertEquals("she", tst2.longestPrefixOf("shes"));

		assertEquals("", tst2.longestPrefixOf("uva"));
	
		assertEquals("z", tst2.longestPrefixOf("z"));

		assertEquals("", tst2.longestPrefixOf("bx"));
	}
	
}
