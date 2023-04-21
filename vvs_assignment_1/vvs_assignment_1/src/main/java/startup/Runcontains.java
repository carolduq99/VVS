package startup;
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
public class Runcontains {

	public static void main(String[] args) {
		String palavra = "[0,2,4,5,7,9,11,4,5,6,4,5,7,9,11,4,5,6,4,5,7,8,4,5,7,9,10,11,4,12]";
		String primesLong = "[0,1] [0,2,3] [0,2,4,5,13] [0,2,4,5,6,7] [0,2,4,5,6,8,10,11,12] [0,2,4,5,6,8,10,12] [0,2,4,5,6,8,9] [5,6,7,5] [5,6,8,10,11,12,5] [5,6,8,10,12,5] [5,6,8,9,5] [6,7,5,13] [6,7,5,6] [6,8,10,11,12,5,13] [6,8,10,11,12,5,6] [6,8,10,12,5,13] [6,8,10,12,5,6] [6,8,9,5,13] [6,8,9,5,6] [7,5,6,7] [7,5,6,8,10,11,12] [7,5,6,8,10,12] [7,5,6,8,9] [8,10,11,12,5,6,7] [8,10,11,12,5,6,8] [8,10,12,5,6,7] [8,10,12,5,6,8] [8,9,5,6,7] [8,9,5,6,8] [9,5,6,8,10,11,12] [9,5,6,8,10,12] [9,5,6,8,9] [10,11,12,5,6,8,10] [10,11,12,5,6,8,9] [10,12,5,6,8,10] [10,12,5,6,8,9] [11,12,5,6,8,10,11] [12,5,6,8,10,11,12] [12,5,6,8,10,12]";
		String [] primes = primesLong.split(" ");
//		for (String string : primes) {
//			System.out.println(string);
//		}
		for (int i = 0; i < primes.length; i++) {
			primes[i]=primes[i].replace("[", "").replace("]", "");
		}
           // System.out.println(primes.length);
        
//		for(String p: primes) {
//            if(palavra.contains(p)) System.out.println(p);
//        }
		
		
		String [] testPaths= {"0,2,4,5,13",
            	"0,2,4,5,6,8,10,11,12,5,13",
				"0,1",
				"0,2,3",
				"0,2,4,5,6,8,10,12,5,6,7,5,6,8,10,12,5,6,7,5,6,8,10,11,12,5,13",
				"0,2,4,5,6,8,9,5,6,8,9,5,6,7,5,13",
				"0,2,4,5,6,8,10,12,5,6,8,10,12,5,6,8,10,11,12,5,6,8,10,12,5,6,8,10,12,5,13",
				"0,2,4,5,6,7,5,6,7,5,13",
				"0,2,4,5,6,8,10,12,5,6,7,5,6,8,10,12,5,6,7,5,6,8,9,5,6,8,10,11,12,5,13",
				"0,2,4,5,6,8,9,5,6,8,10,12,5,6,8,10,12,5,6,8,10,11,12,5,6,8,10,11,12,5,13",
				"0,2,4,5,6,8,10,12,5,6,8,10,12,5,6,8,10,11,12,5,6,7,5,13",
				"0,2,4,5,6,8,10,12,5,6,8,10,12,5,6,8,10,11,12,5,6,8,9,5,13",
				"0,2,4,5,6,8,10,12,5,6,8,10,12,5,6,8,9,5,6,8,10,12,5,6,7,5,13"};
		
		//String [] testPaths= {"0,2,4,12, 0,2,4,5,7,9,10,11,4,12, 0,1, 0,2,3,0, 2,4,5,7,9,11,4,5,6,4,5,7,9,11,4,5,6,4,5,7,9,10,11,4,12, 0,2,4,5,7,8,4,5,7,8,4,5,6,4,12,0,2,4,5,7,9,11,4,5,7,9,11,4,5,7,9,10,11,4,5,7,9,11,4,5,7,9,11,4,12, 0,2,4,5,6,4,5,6,4,12,0,2,4,5,7,9,11,4,5,6,4,5,7,9,11,4,5,6,4,5,7,8,4,5,7,9,10,11,4,12,0,2,4,5,7,8,4,5,7,9,11,4,5,7,9,11,4,5,7,9,10,11,4,5,7,9,10,11,4,12,0,2,4,5,7,8,4,5,7,8,4,5,6,4,12,0,2,4,5,7,9,11,4,5,7,9,11,4,5,7,9,10,11,4,5,6,4,12,0,2,4,5,7,9,11,4,5,7,9,11,4,5,7,9,10,11,4,5,7,8,4,12,0,2,4,5,7,9,11,4,5,7,9,11,4,5,7,8,4,5,7,9,11,4,5,6,4,12,"};

		for(String p: verificaPaths(primes, testPaths)) {
            //System.out.println(p);
		} 
		
	}
	
	//devolve os paths que nao foram percorridos
		//primes = {"1,2,3","4,5,6"}
		public static ArrayList<String> verificaPaths(String[] primes, String[] testPaths) {
			ArrayList<String> primeList = new ArrayList<>(Arrays.asList(primes));
			ArrayList<String> ret =new ArrayList<>(Arrays.asList(primes));
			int i = 1;
			for (String test : testPaths) {
				System.out.println("*******************" + i);
				for (String prime : primeList) {
					if(test.contains(prime)) {
						System.out.println(prime);
						//ret.remove(prime);
					}
					
				}
				i++;
			}
			return ret;
		}
}