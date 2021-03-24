package com.hackerrank.collections;

import junit.framework.TestCase;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountTripletsTest extends TestCase {
    public void testName() {
        List<Long> arr = Arrays.stream(new Long[]{1L, 4l, 16l, 6l, 24l, 64l, 96l}).collect(Collectors.toList());

        assertThat(CountTriplets.Solution.countTriplets(arr, 4), is(3));
    }
}
