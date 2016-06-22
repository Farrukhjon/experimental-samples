package junit.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculate extends Calculate {

	@Test
	public void testFactorial() {
		assertEquals(3628800, factorial(10));
	}

}
