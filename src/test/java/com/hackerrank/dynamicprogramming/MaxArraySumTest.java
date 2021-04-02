package com.hackerrank.dynamicprogramming;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxArraySumTest extends TestCase {

    @Test
    public void testMaxArraySum() {
        assertEquals(15, MaxArraySum.maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
        assertEquals(11, MaxArraySum.maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
    }

    @Test
    public void testMaxArraySumRecursive() {
        assertEquals(15, MaxArraySum.maxSubsetSumRecursion(new int[]{3, 5, -7, 8, 10}));
        assertEquals(11, MaxArraySum.maxSubsetSumRecursion(new int[]{2, 1, 5, 8, 4}));
    }
}
