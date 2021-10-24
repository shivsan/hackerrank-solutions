package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstringFinderTest {
    private LongestPalindromicSubstringFinder longestPalindromicSubstringFinder = new LongestPalindromicSubstringFinder();

    @Test
    public void shouldGetLongestPalindromicSubstring1() {
        String longestPalindrome = longestPalindromicSubstringFinder.longestPalindrome("babad");

        assertEquals("bab", longestPalindrome);
    }

    @Test
    public void shouldGetLongestPalindromicSubstring2() {
        String longestPalindrome = longestPalindromicSubstringFinder.longestPalindrome("cbbd");

        assertEquals("bb", longestPalindrome);
    }

    @Test
    public void shouldGetLongestPalindromicSubstring3() {
        String longestPalindrome = longestPalindromicSubstringFinder.longestPalindrome("a");

        assertEquals("a", longestPalindrome);
    }

    @Test
    public void shouldGetLongestPalindromicSubstring4() {
        String longestPalindrome = longestPalindromicSubstringFinder.longestPalindrome("ac");

        assertEquals("a", longestPalindrome);
    }

    @Test
    public void shouldGetLongestPalindromicSubstring5() {
        String longestPalindrome = longestPalindromicSubstringFinder.longestPalindrome("ccc");

        assertEquals("ccc", longestPalindrome);
    }
}
