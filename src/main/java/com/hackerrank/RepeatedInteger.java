package com.hackerrank;

import java.util.HashSet;

public class RepeatedInteger {
    public int getRepeatedInteger(int[] arrayWithRepeatedInteger) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arrayWithRepeatedInteger) {
            if (hashSet.contains(i)) {
                return i;
            }

            hashSet.add(i);
        }

        return -1;
    }
}
