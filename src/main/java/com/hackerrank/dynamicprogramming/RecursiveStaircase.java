package com.hackerrank.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class RecursiveStaircase {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int findNumberOfWaysToClimbStaircase(int n) {
        if (n == 3)
            return 4;

        if (n <= 2)
            return n;

        if (memo.containsKey(n))
            return memo.get(n);

        int result = findNumberOfWaysToClimbStaircase(n - 1) + findNumberOfWaysToClimbStaircase(n - 2) + findNumberOfWaysToClimbStaircase(n - 3);
        memo.put(n, result);

        return result;
    }
}
