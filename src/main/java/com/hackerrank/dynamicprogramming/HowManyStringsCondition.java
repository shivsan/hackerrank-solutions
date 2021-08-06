package com.hackerrank.dynamicprogramming;

public class HowManyStringsCondition {
    private int maxContiguousA = 1;
    private int nB = 1;
    int noOfWays = 0;

    public int countNoOfStrings(int n) {
        countNoOfStrings("", 0, n);

        return noOfWays;
    }

    public void countNoOfStrings(String string, int i, int n) {
        if (i == n) {
            noOfWays++;
            System.out.println(string);
            return;
        }

        // Conditionally add a
        if (!string.contains("aa")) {
            string += 'a';
            countNoOfStrings(string, i + 1, n);
            string = string.substring(0, string.length() - 1);
        }

        // Conditionally add b
        if (!string.contains("b")) {
            string += 'b';
            countNoOfStrings(string, i + 1, n);
            string = string.substring(0, string.length() - 1);
        }

        // Add c
        string += 'c';
        countNoOfStrings(string, i + 1, n);
//        string = string.substring(0, string.length() - 1);
    }
}
