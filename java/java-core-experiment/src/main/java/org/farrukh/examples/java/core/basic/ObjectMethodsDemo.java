package org.farrukh.examples.java.core.basic;

public class ObjectMethodsDemo implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectMethodsDemo obj1 = new ObjectMethodsDemo();

        Object clonedObj1 = obj1.clone();

        boolean isTrueRef = clonedObj1 == obj1;

        boolean isTheInstanceOfTheSameClass = clonedObj1.getClass() == obj1.getClass();

        System.out.printf("%s\n", isTrueRef);

        System.out.printf("%s\n", isTheInstanceOfTheSameClass);

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());

        System.out.println(o1.equals(o2.equals(o3)));


    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
