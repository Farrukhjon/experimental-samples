package org.farrukh.examples.jmokit;

/**
 * Hello world!
 *
 */
public class SystemUnderTests {
    
    private Collaborator1 collaborator1;

    private Collaborator2 collaborator2;
    
    private int callCount = 0;
    
    public SystemUnderTests(Collaborator1 collaborator1) {
        this.collaborator1 = collaborator1;
    }
    
    public SystemUnderTests(Collaborator2 collaborator2) {
        super();
        this.collaborator2 = collaborator2;
    }



    public void method1() {
        this.collaborator1.doSomething();
        this.callCount++;
    }
    
    public int multiplyByTwo() {
        return 2 * this.collaborator2.returnSomething();
    }

    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int getCallCount() {
        return callCount;
    }
}
