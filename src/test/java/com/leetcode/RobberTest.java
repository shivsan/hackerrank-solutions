package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobberTest {
    private Robber robber = new Robber();

    @Test
    public void shouldFindMaxRobbableAmount() {
        int maxRobbed = robber.rob(new int[]{2, 7, 9, 3, 1});

        assertEquals(12, maxRobbed);
    }
}
