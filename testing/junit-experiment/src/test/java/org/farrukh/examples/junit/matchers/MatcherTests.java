package org.farrukh.examples.junit.matchers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Farrukhjon on 02-Oct-15.
 */
public class MatcherTests {

    @Test
    public void exerciseAssertThatMethod() {
        int x = 3;
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4);

        assertThat(x, is(3));
        assertThat(3, is(not(4)));
        assertThat(5, equalTo(numbers.size()));
    }
}
