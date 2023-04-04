package sut;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.*;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import generators.SmallIntegerListGenerator;

/**
 * Property-based testing (PBT) with JUnit QuickCheck
 * 
 * A property is a proposition that must be true at a given context
 * Operations over types must follow a given set of properties (eg, + must be commutative)
 * 
 * Check:
 *    http://blog.xebia.com/property-based-testing-java-junit-quickcheck-part-1-basics/
 *    http://blog.xebia.com/property-based-testing-java-junit-quickcheck-part-2-generators/
 *    
 * @author jpn
 */

@RunWith(JUnitQuickcheck.class)
public class PrimeFactorsCheck {

//	@Before
//	public void setUp() {
//	}

	@Property
	public void testProductFactorEqualsOriginal(@InRange(min="2", max="10000") int n) {
		List<Integer> factors = PrimeFactors.factor(n);
		int result = 1;
		for(int i : factors) {
			result *= i;
		}
		assertEquals(n, result);
	}
	
	@Property
	public void testAllFactorPrime(@InRange(min="2", max="10000") int n) {
		List<Integer> factors = PrimeFactors.factor(n);
		for(int p : factors) {
			assertTrue(PrimeFactors.isPrime(p));
		}
	}
	
	@Property
	public void testEvenNumberHasFactorTwo(@InRange(min="2", max="10000") int n) {
		assumeTrue(n%2 == 0);
		
		
	}

}
