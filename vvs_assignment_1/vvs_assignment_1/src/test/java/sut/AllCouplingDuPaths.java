package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;

public class AllCouplingDuPaths {
	
	@Test
	public void queryNull(){
		TST<Integer> tst = new TST<>();
		
		tst.put("ola", 1);
		tst.put("oo", 2);
		tst.put("ab", 3);
		assertEquals(3, tst.size());
	}
	





}
