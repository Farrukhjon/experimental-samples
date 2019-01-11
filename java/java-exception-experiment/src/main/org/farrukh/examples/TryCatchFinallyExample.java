package org.farrukh.examples;

/**
 * Created by Farrukhjon on 22-Sep-15.
 */
public class TryCatchFinallyExample {

    public static void main(String[] args) {
        TryCatchFinallyExample example = new TryCatchFinallyExample();
        double result = example.aMethod();
        System.out.println(result);
    }

    public double aMethod() {
        double result = 0;
        try {
            result = 1 / 0;
        } catch (Throwable e) {
            throw new RuntimeException("Custom runtime exception catch block");
        } finally {
            //throw new RuntimeException("Custom runtime exception from finally block");
            return result = 1;
        }
    }
}
