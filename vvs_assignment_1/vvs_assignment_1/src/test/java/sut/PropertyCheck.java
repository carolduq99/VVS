package sut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import generator.TSTGenerator;
@RunWith(JUnitQuickcheck.class)
public class PropertyCheck {

	@Property(trials=30)
	public void insertOrderTest(@From(TSTGenerator.class) TST<Integer> st1){


		TST<Integer> st2 = shuffle(st1);
		assertEquals(st1, st2);
		assertTrue(st1.equals(st2));

	}

	private TST<Integer> shuffle(TST<Integer> t) {
		if (t.size() == 0)
			return t;

		ArrayList<Tuple> pares = new ArrayList<>();

		for (String k : t.keys()) {
			pares.add(new Tuple(k, t.get(k)));
		}

		Collections.shuffle(pares);

		TST<Integer> shuffled = new TST<>();
		for (Tuple tuple : pares) {
			shuffled.put(tuple.x, tuple.y);
		}


		return shuffled;
	}

	@Property(trials=30)
	public void deletionTest(@From(TSTGenerator.class) TST<Integer> st1){
		for (String k : st1.keys()) {
			st1.delete(k);
		}
		assertEquals(0, st1.size());
	}

	@Property(trials=30)
	public void insertDeleteTest(@From(TSTGenerator.class) TST<Integer> st1){
		
		TST<Integer> st2 = st1;
		st2.put("zzz", 1);
		st2.delete("zzz");
		assertEquals(st1, st2);
	}
	
	
	@Property(trials=30)
	public void selectStricterPrefix(@From(TSTGenerator.class) TST<Integer> st1){
		
		List<String> keys1 = (List<String>) st1.keysWithPrefix("ab");
		List<String> keys2 = (List<String>) st1.keysWithPrefix("a");
		assertTrue(keys2.containsAll(keys1));
		
	}


	private class Tuple {
		public String x;
		public int y;

		public Tuple(String x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}



