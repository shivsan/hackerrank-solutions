package com.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// Question: https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int noOfWays(int highestStep) {
        Queue<Integer> currentStairForSameNumberOfSteps = new ArrayDeque<>();
        int noOfWays = 0;

        if (highestStep == 0 || highestStep == 1)
            return highestStep;

        currentStairForSameNumberOfSteps.add(1);
        currentStairForSameNumberOfSteps.add(2);

        while (!currentStairForSameNumberOfSteps.isEmpty()) {
            int currentStair = currentStairForSameNumberOfSteps.remove();

            if (currentStair > highestStep)
                continue;

            if (currentStair == highestStep)
                noOfWays++;

            currentStairForSameNumberOfSteps.add(currentStair + 1);
            currentStairForSameNumberOfSteps.add(currentStair + 2);
        }

        return noOfWays;
    }

    public int noOfWaysDP(int highestStep) {
        if (highestStep == 0 || highestStep == 1)
            return highestStep;

        int noOfWaysLowestStep = 1;
        int noOfWaysMidStep = 2; // Assume second step
        int noOfWaysCurrentStep = 2;

        for (int i = 3; i <= highestStep; i++) {
            noOfWaysCurrentStep = noOfWaysLowestStep + noOfWaysMidStep;
            noOfWaysLowestStep = noOfWaysMidStep;
            noOfWaysMidStep = noOfWaysCurrentStep;
        }

        return noOfWaysCurrentStep;
    }

    public int noOfWaysDPTopDown(int highestStep) {
        if (highestStep <= 2)
            return highestStep;

        if (memo.containsKey(highestStep))
            return memo.get(highestStep);

        return noOfWaysDPTopDown(highestStep - 1) + noOfWaysDPTopDown(highestStep - 2);
    }
}
