package org.farrukh.examples.jmokit.mocking;

import org.junit.Test;

import mockit.Mocked;
import mockit.Verifications;

public class MockAllInstancesUsingMockedAnnotTest {

    @Test
    public void testName(@Mocked Collaborator collaborator) throws Exception {
        SUT sut = new SUT();

        sut.calc();
        
        new Verifications() {
            {
                collaborator.add(anyInt, anyInt); times = 2;
            }
        };
        
    }

}

    class SUT {

        Collaborator collaborator1;
        Collaborator collaborator2;

        public SUT() {
            collaborator1 = new Collaborator();
            collaborator2 = new Collaborator();
        }

        public void calc() {
            collaborator1.add(2, 3);
            collaborator2.add(3, 4);
        }

    }

class Collaborator {

    int add(int x, int y) {
        return x + y;
    }

}
