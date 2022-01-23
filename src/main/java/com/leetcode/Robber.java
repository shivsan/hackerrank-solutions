package com.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class Robber {
    public int rob(int[] nums) {
        int[] max = new int[nums.length];

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Integer.max(nums[0], nums[1]);

        if (nums.length == 3)
            return Integer.max(nums[0] + nums[2], nums[1]);

        max[0] = nums[0];
        max[1] = nums[1];
        max[2] = Integer.max(nums[0] + nums[2], nums[1]);

        for(int i = 3; i < nums.length; i++) {
            max[i] = nums[i] + Integer.max(max[i-2], max[i-3]);
        }

        return Arrays.stream(max).max().getAsInt();
    }
}
