package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatternMatchingTrieTest {
    @Test
    public void shouldReturnFalseWithEmptyTrie() {
        var word = "pat";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();

        assertFalse(patternMatchingTrie.search(word));
    }

    @Test
    public void shouldAddWord() {
        var word = "pat";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word);

        assertTrue(patternMatchingTrie.search(word));
    }

    @Test
    public void shouldAddWords() {
        var word1 = "pat";
        var word2 = "patter";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word1);
        patternMatchingTrie.add(word2);

        assertTrue(patternMatchingTrie.search(word1));
    }

    // Limitation of TDD: Cannot account for intended side effects.
    @Test
    public void shouldNotPassIncompleteWords() {
        var word1 = "pat";
        var word2 = "patter";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word1);
        patternMatchingTrie.add(word2);

        assertFalse(patternMatchingTrie.search(word2.substring(0, word2.length() - 2)));
    }

    @Test
    public void shouldAddOneLetterWord() {
        var word = "p";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word);

        assertTrue(patternMatchingTrie.search(word));
    }

    @Test
    public void shouldMatchPatternInEnding() {
        var word = "pat";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word);

        assertTrue(patternMatchingTrie.search("pa."));
        assertTrue(patternMatchingTrie.search(".at"));
        assertTrue(patternMatchingTrie.search("p.t"));
    }

    @Test
    public void shouldMatchMultiplePattern() {
        var word = "pat";
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add(word);

        assertTrue(patternMatchingTrie.search("p.."));
        assertTrue(patternMatchingTrie.search(".a."));
        assertTrue(patternMatchingTrie.search("..t"));
        assertTrue(patternMatchingTrie.search("..."));
    }

    @Test
    public void shouldNotMatch() {
        PatternMatchingTrie patternMatchingTrie = new PatternMatchingTrie();
        patternMatchingTrie.add("pan", "pat", "mat");

        assertFalse(patternMatchingTrie.search("p..r"));
        assertFalse(patternMatchingTrie.search("p.r"));
        assertFalse(patternMatchingTrie.search("o.."));
        assertFalse(patternMatchingTrie.search("o.."));
    }
}
