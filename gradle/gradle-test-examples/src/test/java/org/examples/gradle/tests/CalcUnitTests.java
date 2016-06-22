package org.examples.gradle.tests;

import junit.framework.TestCase;

import org.junit.Test;

public class CalcUnitTests extends TestCase {

	@Test
	public void testAddMethod(){
		assertEquals(1+1, 2);
	}
}
