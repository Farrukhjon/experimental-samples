package org.farrukh.examples.junit;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Farrukhjon on 02-Oct-15.
 */
public class BeforeAnnotationDemo {

    int count = 0;

    @Before
    public void setup() {
        int result = ++count;
        System.out.println("count property is: " + result);
    }

    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }

    @Test
    public void test3() {

    }
}
