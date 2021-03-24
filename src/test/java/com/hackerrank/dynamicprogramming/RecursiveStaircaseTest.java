package com.hackerrank.dynamicprogramming;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RecursiveStaircaseTest extends TestCase {
    @Test
    public void findNumberOfStairs() {
        assertEquals(RecursiveStaircase.findNumberOfWaysToClimbStaircase(1), 1);
        assertEquals(RecursiveStaircase.findNumberOfWaysToClimbStaircase(3), 4);
        assertEquals(RecursiveStaircase.findNumberOfWaysToClimbStaircase(7), 44);
    }
}
