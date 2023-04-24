package generator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import sut.TST;

@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorTest {

	@Property(trials = 10)
	public void testTrie(@From(TSTGenerator.class) TST<Integer> trie) {
		if(trie.size()==0) {
			System.out.println("Empty trie");
		}else {
			for (String key : trie.keys()) {
				System.out.println(key + " " + trie.get(key));
			}
		}
		System.out.println( "*************");
	}
	

}
