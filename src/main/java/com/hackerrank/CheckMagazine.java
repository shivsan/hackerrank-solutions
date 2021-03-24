package com.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class CheckMagazine {

    public class Solution {

        // Complete the checkMagazine function below.
        public void checkMagazine(String[] magazine, String[] note) {
            HashMap<String, Integer> hs = new HashMap<>();

            for (String word : magazine) {
                if (hs.containsKey(word))
                    hs.put(word, hs.get(word) + 1);
                else
                    hs.put(word, 1);
            }

            for (String word : magazine) {
                if (hs.containsKey(word) && hs.get(word) > 0)
                    hs.put(word, hs.get(word) - 1);
                else {
                    System.out.println("NO");
                    return;
                }
            }

        }
    }
}
