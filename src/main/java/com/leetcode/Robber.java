package com.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class Robber {
    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Integer.max(nums[0], nums[1]);

        if (nums.length == 3)
            return Integer.max(nums[0] + nums[2], nums[1]);
        int maxHouse = 0;
        int maxHouseMinusOne = 0;
        int maxHouseMinusTwo = 0;
        int maxHouseMinusThree = 0;

        maxHouseMinusThree = nums[0];
        maxHouseMinusTwo = nums[1];
        maxHouseMinusOne = Integer.max(maxHouseMinusThree + nums[2], maxHouseMinusTwo);
        maxHouse = nums[3] + Integer.max(maxHouseMinusThree, maxHouseMinusTwo);

        for(int i = 4; i < nums.length; i++) {
            maxHouseMinusThree = maxHouseMinusTwo;
            maxHouseMinusTwo = maxHouseMinusOne;
            maxHouseMinusOne = maxHouse;
            maxHouse = nums[i] + Integer.max(maxHouseMinusThree, maxHouseMinusTwo);
        }

        return Integer.max(maxHouse, maxHouseMinusOne);
    }
}
