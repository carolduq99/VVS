package generator;

import java.util.ArrayList;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.TST;


public class TSTGenerator extends Generator<TST<Integer>>{

	private static final int NUM_KEYS = 15;
	private static final int MAX_LEN = 10;
    private static final int ASCII_FIRST = 97;
    private static final int ASCII_LAST = 122;
	
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TSTGenerator() {
		 super((Class<TST<Integer>>) (Class) TST.class);
	}


	@Override
	public TST<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
		
		TST<Integer> genTrie = new TST<>();
		
		int numKeys = random.nextInt(NUM_KEYS);
		int cont = 0;
		while(cont != numKeys) {
			int string_len = random.nextInt(MAX_LEN);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < string_len; i++) {
				sb.append((char) random.nextInt(ASCII_FIRST, ASCII_LAST));
			}
			int val = random.nextInt(100);
			if( sb.toString().length() > 0 && !genTrie.contains(sb.toString())) {
				cont++;
				genTrie.put(sb.toString(), val);
			}
		}
		
		return genTrie;
	}

}
