package sut;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;
public class InputStatePartition {

	
	//INPUT STATE PARTITION BASE CHOICE
	@Test
	public void t1BaseChoice() throws FileNotFoundException {
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);
		tst.put("shells", 2);
		tst.put(null, null);
	}
	
	
	@Test
	public void t2() throws FileNotFoundException {
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);
		tst.put("shells", 2);
		tst.put(null, null);
		
		
		
	}
	
}
