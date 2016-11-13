package org.farrukh.examples.jmokit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class SystemUnderTests {
    
    private static final Logger logger = LoggerFactory.getLogger(SystemUnderTests.class);

    private Collaborator1 collaborator1;

    private Collaborator2 collaborator2;

    private int callCount = 0;

    public SystemUnderTests(Collaborator1 collaborator1) {
        this.collaborator1 = collaborator1;
    }

    public SystemUnderTests(Collaborator2 collaborator2) {
        this.collaborator2 = collaborator2;
    }

    public void method1() {
        this.collaborator1.doSomething();
        this.callCount++;
        logger.info("Method method1 is called");
    }

    public int multiplyByTwo() {
        logger.info("Method multiplyByTwo is called");
        return 2 * this.collaborator2.returnSomething();
    }

    public int getCallCount() {
        return callCount;
    }

}
