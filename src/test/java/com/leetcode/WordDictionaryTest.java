package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WordDictionaryTest {
    @Test
    public void shouldFindNormalWord() {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("pat");

        boolean result = wordDictionary.search("pat");

        assertTrue(result);
    }

    @Test
    public void shouldFindPatternedWord() {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("pat");

        assertTrue(wordDictionary.search("p.t"));
        assertTrue(wordDictionary.search(".at"));
        assertTrue(wordDictionary.search("pa."));
        assertTrue(wordDictionary.search("p.."));
        assertTrue(wordDictionary.search("..t"));
        assertTrue(wordDictionary.search(".a."));
        assertTrue(wordDictionary.search("..."));
    }

    @Test
    public void shouldFindPatternedWord2() {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("pat");
        wordDictionary.addWord("cat");

        assertTrue(wordDictionary.search("p.t"));
        assertTrue(wordDictionary.search(".at"));
        assertTrue(wordDictionary.search("pa."));
        assertTrue(wordDictionary.search("p.."));
        assertTrue(wordDictionary.search("..t"));
        assertTrue(wordDictionary.search(".a."));
        assertTrue(wordDictionary.search("..."));
    }
}
