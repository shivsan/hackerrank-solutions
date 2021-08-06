package com.hackerrank.dynamicprogramming;

import junit.framework.TestCase;

public class HowManyStringsConditionTest extends TestCase {
    public void testName() {
        assertEquals(8, new HowManyStringsCondition().countNoOfStrings(2));
        assertEquals(19, new HowManyStringsCondition().countNoOfStrings(3));
    }
}
