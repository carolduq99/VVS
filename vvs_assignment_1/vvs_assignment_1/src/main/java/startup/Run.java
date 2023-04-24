package startup;

import java.io.*;
import java.util.*;

import sut.TST;

public class Run {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("data/someWords.txt"));
			
		TST<Integer> st = new TST<>();
		
		int i=0;
		while(sc.hasNextLine()) {
			String[] keys = sc.nextLine().split(" ");
			for(String key : keys)
				st.put(key, ++i);
		}
		
		
		
		for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
		System.out.println(st.size());
		
		st.put("she", null);
		for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
		System.out.println(st.size() + "\n TESTE:");
		
		TST<Integer> st1 = new TST<>();
		st1.put("a", 3);
		st1.put("b", 2);
		st1.put("c", 1);
		System.out.println(st1.size());
		for (String k : st1.keys()) {
			System.out.println(k + st1.get(k));
		}
		//st1.delete("a");
		for (String k : st1.keys()) {
			System.out.println(k + st1.get(k));
		}
		
		TST<Integer> st2 = new TST<>();
		
		st2.put("b", 2);
		st2.put("a", 1);
		for (String k : st2.keys()) {
			//System.out.println(k + st2.get(k));
		}
		System.out.println("IGUAL?: " + st1.equals(st2));
		
		

		
		
		System.out.println("longestPrefixOf(\"shellsort\"):");
		System.out.println(st.longestPrefixOf("shellsort"));
		
		System.out.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
        	System.out.println(s);
        
        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
        	System.out.println(s);
		
		sc.close();
		
		TST<Integer> st4 = new TST<>();
		st4.put("bna", 1);
		st4.put("bnas", 2);
		st4.put("bcd", 3);
		System.out.println("*********************");
		System.out.println(st4.toString()); 
		
		st4.delete("bnas");
		System.out.println("*********************");
		System.out.println(st4.toString()); 
		
		for (String k : st4.keys()) {
			System.out.println(k + st4.get(k));
		}
		
	}

}
