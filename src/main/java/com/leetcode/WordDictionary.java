package com.leetcode;

import java.util.HashSet;
import java.util.Set;

// Question: https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class WordDictionary {
    private Set<String> dict = new HashSet<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
        // Add word with matcher - all combos
        for (int i = 1; i <= word.length(); i++) {
            addPatternedWord(word, i);
        }
        dict.add(word);
    }

    private void addPatternedWord(String word, int noOfRemainingMatchers) {
        addPatternedWord(word, "", 0, word.length(), noOfRemainingMatchers);
    }

    private void addPatternedWord(String word, String wordSoFar, int wordLengthSoFar, int noOfMatchers, int noOfRemainingMatchers) {
        if (noOfRemainingMatchers == 0) {
            dict.add(wordSoFar + word.substring(wordLengthSoFar));
        }

        if (wordLengthSoFar == word.length())
            return;

        if (dict.contains(wordSoFar + word.substring(wordLengthSoFar)))
            return;

        char nextLetter = word.charAt(wordLengthSoFar);
        char matcher = '.';

        addPatternedWord(word, wordSoFar + nextLetter, wordLengthSoFar + 1, noOfMatchers, noOfRemainingMatchers);

        addPatternedWord(word, wordSoFar + matcher, wordLengthSoFar + 1, noOfMatchers, noOfRemainingMatchers - 1);
    }

    public boolean search(String word) {
        return dict.contains(word);
    }
}
