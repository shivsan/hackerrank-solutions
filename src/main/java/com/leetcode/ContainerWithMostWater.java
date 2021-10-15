package com.leetcode;

public class ContainerWithMostWater {
    public int getAreaWallsWithMostWater(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = getArea(height[i], height[j], i, j);
                maxArea = Integer.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int getArea(int wall1Height, int wall2Height, int wall1Position, int wall2Position) {
        return (wall2Position - wall1Position) * Integer.min(wall1Height, wall2Height);
    }
}
