package sut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
@RunWith(JUnitQuickcheck.class)
public class PropertyCheck {

	@Property(trials=20)
	public void insertOrderTest(){
		TST<Integer> st1 = new TST<>();
		st1.put("a", 1);
		st1.put("b", 2);
		st1.put("c", 3);
		
		TST<Integer> st2 = new TST<>();
		st2.put("b", 2);
		st2.put("c", 3);
		st2.put("a", 1);
		
		assertEquals(st1, st2);
		assertTrue(st1.equals(st2));
		
	}
	
	private TST<Integer> shuffle(TST<Integer> t) {
		// convert to List
		ArrayList<Tuple> pares = new ArrayList<>();
		
		for (String k : t.keys()) {
			pares.add(new Tuple(k, t.get(k)));
		}
		
		for (Tuple tuple : pares) {
			
		}
		
		Collections.shuffle(pares);
		
		
		// reconvert to int[]
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	
	//@Property(trials=20)
	//public void insertOrderTest(){
	private class Tuple {
	    public String x;
	    public int y;

	    public Tuple(String x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    @Override
	    public String toString() {
	        return "(" + x + ", " + y + ")";
	    }
	}
}
	
	

