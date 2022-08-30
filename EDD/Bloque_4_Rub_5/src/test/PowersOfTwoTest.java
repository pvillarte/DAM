package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.PowersOfTwo;

class PowersOfTwoTest {

	@Test
	void testTwoToThePowerOfZero() {
		assertEquals("1", PowersOfTwo.twoToThePowerOfN(0));
	}
	
	@Test
	void testTwoToThePowerOfThreeWithoutAccount() {
		assertEquals("8", PowersOfTwo.twoToThePowerOfN(3));
	}
	
	@Test
	void testTwoToThePowerOfSixWithoutAccount() {
		assertEquals("64", PowersOfTwo.twoToThePowerOfN(6));
	}

}
