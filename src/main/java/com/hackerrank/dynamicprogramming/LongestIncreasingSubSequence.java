package com.hackerrank.dynamicprogramming;

import java.util.stream.IntStream;

public class LongestIncreasingSubSequence {
    public int[] max;

    public int get(int[] sequence) {
        max = new int[sequence.length];
        max[0] = 1;
        return maxOfArray(IntStream.range(0, sequence.length).map(i -> findMax(sequence, i)));
    }

    private int findMax(int[] arr, int i) {
        if (max[i] != 0)
            return max[i];

        return max[i] = 1 + maxOfArray(IntStream.range(0, i).filter(k -> arr[k] < arr[i]).map(k -> findMax(arr, k)));
    }

    private int maxOfArray(IntStream array) {
        return array.max().orElse(0);
    }
}
