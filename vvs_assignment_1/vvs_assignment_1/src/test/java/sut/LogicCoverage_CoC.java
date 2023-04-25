package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;

public class LogicCoverage_CoC {
	
	@Test
	public void queryNull(){
		TST<Integer> tst = new TST<>();
		tst.put("shells", 0);
		assertThrows(IllegalArgumentException.class, () -> tst.longestPrefixOf(null));  
	}
	
	@Test
	public void queryLengthZero(){
		TST<Integer> tst = new TST<>();
		tst.put("shells", 0);
		assertNull(tst.longestPrefixOf(""));
	}
	
	@Test
	public void emptyTrie(){
		TST<Integer> tst = new TST<>();
		assertNull(tst.longestPrefixOf(""));
	}

	@Test
	public void normalQuery(){
		TST<Integer> tst = new TST<>();
		tst.put("shells", 1);
		assertEquals("shells", tst.longestPrefixOf("shells"));
		assertEquals("", tst.longestPrefixOf("shell"));
		
		TST<Integer> tst2 = new TST<>();
		tst2.put("sea", 1);
		tst2.put("shore", 2);
		assertEquals("", tst2.longestPrefixOf("shells"));
		
	}





}
