package com.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class TwoStrings {
    public String checkIfStringsHaveSubStrings(String s1, String s2) {
        boolean[] alphabets = new boolean[26];

        s1.chars().forEach(s -> alphabets[s - 97] = true);

        return s2.chars().filter(s -> alphabets[s - 97]).count() > 0 ? "YES" : "NO";
    }

    private String output() {
        Arrays.sort(new String[1], String::compareTo);
        return "";
    }
}

class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}