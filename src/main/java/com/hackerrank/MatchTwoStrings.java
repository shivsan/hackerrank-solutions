package com.hackerrank;

public class MatchTwoStrings {
    static String abbreviation(String a, String b) {
        String a1 = a.toUpperCase();
        int ai = 0, bi = 0;

        for (; bi < b.length(); bi++) {
            for (; ai < a1.length(); ai++) {
                if (a1.charAt(ai) == b.charAt(bi)) {
                    break;
                }
            }

            if (ai == a1.length() && bi < b.length())
                return "NO";
            ai++;
        }

        if (ai < a1.length() && !(a.substring(ai).toLowerCase().equals(a.substring(ai))))
            return "NO";

        return "YES";
    }
}
