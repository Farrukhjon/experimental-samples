package org.farrukh.examples.jmokit.mocking.mocked;

public class ClassUnderTest {
    
    private C c;
    
    public ClassUnderTest(C c) {
        this.c = c;
    }

    public String greeting() {
        return c.sayHello() + " world!";
    }
    
}
