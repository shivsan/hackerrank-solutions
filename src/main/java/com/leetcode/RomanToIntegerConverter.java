package com.leetcode;

import java.util.*;

public class RomanToIntegerConverter {

    public static void main(String[] args) {
        int[] a = {25, 2, 3, 57, 38, 41};
        int[] res = solution(a);
        System.out.println(Arrays.toString(res));
    }

    static int[] solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            while (x > 0) {
                int t = x % 10;
                x = x / 10;
                if (map.containsKey(t)) {
                    int val = map.get(t) + 1;
                    map.remove(t);
                    map.put(t, val);
                    if (val > max) {
                        max = val;
                    }
                } else {
                    map.put(t, 1);
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            if (map.containsKey(i) && max == map.get(i)) result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private LinkedHashMap<Character, Integer> denominations = new LinkedHashMap<>();

    public RomanToIntegerConverter() {
        denominations.put('M', 1000);
        denominations.put('D', 500);
        denominations.put('C', 100);
        denominations.put('L', 50);
        denominations.put('X', 10);
        denominations.put('V', 5);
        denominations.put('I', 1);
    }

    public int convert(String romanNumber) {
        if (romanNumber == "")
            return 0;

        int number = 0;

        for (int i = 0; i < romanNumber.length() - 1; i++) {
            if (denominations.get(romanNumber.charAt(i)) < denominations.get(romanNumber.charAt(i + 1))) {
                number -= denominations.get(romanNumber.charAt(i));
            } else {
                number += denominations.get(romanNumber.charAt(i));
            }
        }

        return number + denominations.get(romanNumber.charAt(romanNumber.length() - 1));
    }

    public int solution(String beginWord, String endWord, String[] wordList1) {
        int wordLength = beginWord.length();
        List<String> wordList = Arrays.asList(wordList1);
        Map<String, List<String>> allCombinationDict = new HashMap<>();

        for (String s : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String newWord = s.substring(0, i) + '*' + s.substring(i + 1, wordLength);
                List<String> transformations = allCombinationDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(s);
                allCombinationDict.put(newWord, transformations);
            }
        }

        Queue<Integer> qLevel = new LinkedList<>();
        Queue<String> qWord = new LinkedList<>();
        qLevel.add(1);
        qWord.add(beginWord);

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!qLevel.isEmpty()) {
            Integer level = qLevel.remove();
            String word = qWord.remove();

            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLength);

                for (String adjacentWord : allCombinationDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        qLevel.add(level + 1);
                        qWord.add(adjacentWord);
                    }
                }
            }
        }

        return 0;
    }
}
