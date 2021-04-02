package com.hackerrank.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class MaxArraySum {
    static int maxSubsetSum(int[] arr) {
        int[] state = new int[arr.length];

        if (arr.length == 0)
            return 0;

        if (arr.length == 1)
            return max(arr[0], 0);
        else
            state[0] = max(arr[0], 0);

        if (arr.length >= 2)
            state[1] = max(arr[1], 0);

        if (arr.length >= 3)
            state[2] = max(arr[2], 0) + state[0];

        for (int i = 3; i < arr.length; i++) {
            state[i] = max(arr[i], 0) + max(state[i - 2], state[i - 3]);
        }

        return max(state[arr.length - 1], state[arr.length - 2]);
    }

    static int maxSubsetSumRecursion(int[] arr) {
        if (arr.length <= 2)
            return max(arr);

        memo = new HashMap<>();

        return max(maxSubsetSumRecursiveFunction(arr, arr.length - 1)
                , maxSubsetSumRecursiveFunction(arr, arr.length - 2));
    }

    static HashMap<Integer, Integer> memo = new HashMap<>();

    static int maxSubsetSumRecursiveFunction(int[] arr, int i) {
        if (i < 0)
            return 0;

        if (memo.containsKey(i))
            return memo.get(i);

        int result = max(arr[i], 0) +
                max(
                        maxSubsetSumRecursiveFunction(arr, i - 2),
                        maxSubsetSumRecursiveFunction(arr, i - 3));
        memo.put(i, result);

        return result;
    }

    static int max(int... numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }

}
