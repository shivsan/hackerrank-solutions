package com.hackerrank.arrays;

import java.util.Arrays;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        Arrays.fill(arr, 0);

        // Populate with boundaries
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];

            arr[a] += k;
            if (b < arr.length - 1)
                arr[b + 1] -= k;
        }

        // Calculate as we move
        long runningIncrementer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            runningIncrementer += arr[i];
            arr[i] = runningIncrementer;
        }

        return Arrays.stream(arr).max().getAsLong();
    }
}
