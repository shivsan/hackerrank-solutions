package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

    @Test
    public void getLongestIncreasingSubsequence() {
        String s1 = "ahcead";
        String s2 = "acaed";

        String longestCommonSubsequence = this.longestCommonSubsequence.getLongestCommonSubsequence(s1, s2);
        assertEquals("acad", longestCommonSubsequence);
    }

    @Test
    public void getEmpty() {
        String s1 = "eeeeee";
        String s2 = "uuuuuuuu";

        String longestCommonSubsequence = this.longestCommonSubsequence.getLongestCommonSubsequence(s1, s2);
        assertEquals("", longestCommonSubsequence);
    }

    @Test
    public void getEmptyForEmpty() {
        String s1 = "";
        String s2 = "";

        String longestCommonSubsequence = this.longestCommonSubsequence.getLongestCommonSubsequence(s1, s2);
        assertEquals("", longestCommonSubsequence);
    }
}
