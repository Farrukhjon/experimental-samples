package org.farrukh.examples.maven;

import org.farrukh.examples.maven.category.SlowTests;
import org.junit.experimental.categories.Category;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@Category(SlowTests.class)
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
