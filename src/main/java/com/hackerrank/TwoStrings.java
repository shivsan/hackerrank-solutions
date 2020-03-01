package com.hackerrank;

public class TwoStrings {
    public String checkIfStringsHaveSubStrings(String s1, String s2) {
        boolean[] alphabets = new boolean[26];
        for (char c : s1.toCharArray()) {
            alphabets[c-97] = true;
        }

        for(char d: s2.toCharArray()){
            if(alphabets[d-97]) return "YES";
        }

        return "NO";
    }
}
