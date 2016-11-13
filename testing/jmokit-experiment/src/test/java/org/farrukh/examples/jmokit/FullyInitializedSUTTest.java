package org.farrukh.examples.jmokit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import mockit.Tested;
import mockit.Verifications;

/**
 * Unit test for simple App.
 */
public class FullyInitializedSUTTest {

    @Tested(fullyInitialized = true)
    SystemUnderTests sut;

    @Ignore
    @Test
    public void test2() throws Exception {

        int method2 = sut.multiplyByTwo();

        new Verifications() {
            {
                assertEquals(12, method2);

            }
        };
    }
}
