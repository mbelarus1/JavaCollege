import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	// Test method for a positive  number
	@Test
	public void testComputePositive() {
		float a = 10.0f;
		assertTrue("Positive Number", Math.abs(Math.sqrt(a) - Newton.Compute(a)) < 1E-5);
		
	}
	
	// Test method for a negative number
	@Test
	public void testComputeNegative() {
		float a = -10.0f;
		assertEquals(Float.NaN, Newton.Compute(a));
	}
	// Test method with Zero
	@Test
	public void testComputeZero() {
		float a = 0;
		assertEquals(0, Newton.Compute(a));
	}
	
	// Test method for a large number
	@Test
	public void testComputeLargeNum() {
		float a =  3.4028235E+38F;
		assertTrue("Postive number not equals to NaN,",!Float.isNaN(Newton.Compute(a)));
	}
	
	// Test method for a potential edge case done by a malicious programmer
	@Test
	public void testMaliciousActivity() {
		float a =  666F;
		assertTrue("Malicious number", Newton.Compute(a) != 0F);
	}
	
	
}