package com.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContainerWithMostWaterTest {
    private ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    public void shouldGetLargestArea() {
        int[] walls = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int area = containerWithMostWater.getAreaWallsWithMostWater(walls);

        assertEquals(49, area);
    }
}
