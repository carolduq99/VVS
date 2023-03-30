package sut;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TSTTest {

	@Test
    public void testPut_KeyNull() {
        TST<Integer> tst = new TST<>();
        assertThrows(IllegalArgumentException.class, () -> tst.put(null, 0));  
    }
	
	@Test
	public void testPut_NotContainsKey() {
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		assertEquals(1, tst.size());
	}
	
	@Test
	public void testPut_ContainsKey() {
		TST<Integer> tst = new TST<>();
		tst.put("k1", 0);
		tst.put("k1", 3);
		assertEquals(3, tst.get("k1").intValue());
	}
	
}
