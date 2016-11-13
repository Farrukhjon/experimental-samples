package org.farrukh.examples.jmokit.mocking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

public class MockedAnnotInActionWhenIsolatingChildFromItsParentTest {

    /**
     * SUT
     */
    Child child;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testingChildInstanceWithoutIsolatingFromItsParentInstance() throws Exception {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Do not call me!");
        child = new Child("Ali");
    }

    @Test
    public void testingChildInstanceWithIsolatingFromItsParentInstance(@Mocked Parent parent) throws Exception {
        child = new Child("Ali");
        String name = child.getName();
        Assert.assertEquals(name, "Ali");
    }

    /**
     * 
     * Something internal mocking up?
     */
    @Test
    public void testingChildInstanceWithIsolatingFromItsParentInstanceUsinMockUp() throws Exception {

        new MockUp<Parent>() {
            @Mock
            public void $init(final String name) {
                throw new IllegalStateException("Never call me!");
            }
        };

        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("Never call me!");

        child = new Child("Ali");
    }

}
