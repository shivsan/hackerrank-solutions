package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {
    @Test
    public void shouldComputeAllNumberOfWaysToClimbStairs() {
        int highestStep = 35;
        int noOfWays = new ClimbingStairs().noOfWays(highestStep);

        assertEquals(14930352, noOfWays);
    }

    @Test
    public void shouldComputeAllNumberOfWaysToClimbStairsDP() {
        int highestStep = 35;
        int noOfWays = new ClimbingStairs().noOfWaysDP(highestStep);

        assertEquals(14930352, noOfWays);
    }

    @Test
    public void shouldComputeAllNumberOfWaysToClimbStairsDPTopDown() {
        int highestStep = 35;
        int noOfWays = new ClimbingStairs().noOfWaysDPTopDown(highestStep);

        assertEquals(14930352, noOfWays);
    }
}
