package org.farrukh.examples.jmokit;

import org.junit.Assert;
import org.junit.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;

/**
 * Unit test for simple App.
 */
public class SystemUnderTestsTest {

    @Tested
    SystemUnderTests sut;
    
    @Injectable
    Collaborator2 collaborator2;

    @Test
    public void testMethod1(@Mocked final Collaborator1 collaborator1) {
        new Expectations() {
            {
                collaborator1.doSomething();
                times = 1;
            }
        };

        SystemUnderTests appUnderTests = new SystemUnderTests(collaborator1);
        appUnderTests.method1();
    }


    @Test
    public void test2() throws Exception {
        new Expectations() {
            {
                collaborator2.returnSomething();
                result = 6;
            }
        };

        int method2 = sut.multiplyByTwo();

        new Verifications() {
            {
                collaborator2.returnSomething(); times = 1;
                Assert.assertEquals(12, method2);

            }
        };
    }
}
