package sut;

import org.junit.jupiter.api.Test;
public class InputStatePartition {

	//INPUT STATE PARTITION BASE CHOICE
	@Test
	public void t1BaseChoice() { 
		TST<Integer> tst = new TST<>();
		tst.put("ola", 1);

		tst.put("olga", 2); //t1 base choice
	}


	@Test
	public void t2() { 
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);
		tst.put("sells", 2);

		tst.put("she", 3); //t2
	}


	@Test
	public void t3() { 
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);
		tst.put("sells", 2);

		tst.put("shells", 3); //t3
	}

	@Test
	public void t4() { 
		TST<Integer> tst = new TST<>();
		tst.put("she", 1); //t4
	}

	@Test
	public void t5() { 
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);

		tst.put("by", 2); //t5
	}

	@Test
	public void t6() { 
		TST<Integer> tst = new TST<>();
		tst.put("she", 1);

		tst.put("ze", 2);  //t6
	}


}
