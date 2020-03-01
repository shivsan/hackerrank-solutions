package com.hackerrank;

public class TwoStrings {
    public String checkIfStringsHaveSubStrings(String s1, String s2) {
        boolean[] alphabets = new boolean[26];

        s1.chars().forEach(s -> alphabets[s - 97] = true);

        return s2.chars().filter(s -> alphabets[s - 97]).count() > 0 ? "YES" : "NO";
    }
}
