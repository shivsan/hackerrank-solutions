package com.leetcode;

import java.util.HashMap;

public class LongestCommonSubsequence {
    private String longestString = "";
    private int recCount = 0;

    private class Memoise {
        private String longestSofar;
        private int s1i;
        private int s2i;

        Memoise(int s1i, int s2i, String longestSofar) {
            this.s1i = s1i;
            this.s2i = s2i;
            this.longestSofar = longestSofar;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;

            Memoise obj = (Memoise) o;


            return false;
        }

        @Override
        public int hashCode() {
            int result = longestSofar != null ? longestSofar.hashCode() : 0;
            result = 31 * result + s1i;
            result = 31 * result + s2i;
            return result;
        }
    }

    public String getLongestCommonSubsequence(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty())
            return ""; // Because empty strings cannot be indexed. Being able to index the string is a pre-condition.

        getLongestCommonSubsequence(s1, s2, 0, 0, "");
        System.out.println("recCount = " + recCount);
        return longestString;
    }

    private void getLongestCommonSubsequence(String s1, String s2, int s1i, int s2i, String longestSoFar) {
        recCount++;

        if (s1i == s1.length() || s2i == s2.length()) { // Index is past the string edge
            if (longestSoFar.length() > longestString.length()) {
                longestString = longestSoFar;
            }
            return;
        }

        if (s1.charAt(s1i) == s2.charAt(s2i)) {
            longestSoFar += s2.charAt(s2i);
            getLongestCommonSubsequence(s1, s2, s1i + 1, s2i + 1, longestSoFar);
        } else {
            getLongestCommonSubsequence(s1, s2, s1i + 1, s2i, longestSoFar);
            getLongestCommonSubsequence(s1, s2, s1i, s2i + 1, longestSoFar);
        }
    }
}
