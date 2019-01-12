package org.farrukh.experiments.java.concurrent.collections.map;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CollectionsTest {

    @Test(expected = UnsupportedOperationException.class)
    public void createEmptyImmutableCollections() {
        //given:
        List<Object> emptyImmutableList = Collections.emptyList(); // Type Unsafe (Raw) version is: Collections.EMPTY_LIST

        Set<Object> emptyImmutableSet = Collections.emptySet(); // Type Unsafe (Raw) version is: Collections.EMPTY_SET

        //when:
        emptyImmutableList.add(new Object());
        emptyImmutableSet.add(new Object());
    }
}
