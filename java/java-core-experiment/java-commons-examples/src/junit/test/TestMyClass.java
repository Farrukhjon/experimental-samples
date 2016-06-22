package junit.test;

import junit.framework.TestCase;
import junit.main.MyClass;

public class TestMyClass extends TestCase {

	public void testMultyValues() {
		MyClass m = new MyClass();
		assertEquals("Result", 50.0, m.multyValues(5, 10));
	}

	public void testHello() {
		MyClass m = new MyClass();
		assertEquals("Hello", m.say("Hello"));
	}
}
