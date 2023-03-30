package sut;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TSTTest {
	
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
	
}
