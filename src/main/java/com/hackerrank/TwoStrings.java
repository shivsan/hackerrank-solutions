package com.hackerrank;

public class TwoStrings {
    public String checkIfStringsHaveSubStrings(String string1, String string2) {
        int[] arr1 = new int[26], arr2 = new int[26];

        for (char ch : string1.toCharArray()) {
            arr1[ch - 97]++;
        }

        for (char ch : string2.toCharArray()) {
            arr2[ch - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] > 0 && arr2[i] > 0)
                return "YES";
        }

        return "NO";
    }
}
