package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieMapTest {
    @Test
    public void shouldReturnFalseWithEmptyTrie() {
        var word = "pat";
        TrieMap trieMap = new TrieMap();

        assertFalse(trieMap.search(word));
    }

    @Test
    public void shouldAddWord() {
        var word = "pat";
        TrieMap trieMap = new TrieMap();
        trieMap.add(word);

        assertTrue(trieMap.search(word));
    }

    @Test
    public void shouldAddWords() {
        var word1 = "pat";
        var word2 = "patter";
        TrieMap trieMap = new TrieMap();
        trieMap.add(word1);
        trieMap.add(word2);

        assertTrue(trieMap.search(word1));
    }

    // Limitation of TDD: Cannot account for intended side effects.
    @Test
    public void shouldNotPassIncompleteWords() {
        var word1 = "pat";
        var word2 = "patter";
        TrieMap trieMap = new TrieMap();
        trieMap.add(word1);
        trieMap.add(word2);

        assertFalse(trieMap.search(word2.substring(0, word2.length() - 2)));
    }

    @Test
    public void shouldNotPass() {
        var word1 = "pat";
        var word2 = "patter";
        TrieMap trieMap = new TrieMap();
        trieMap.add(word1);
        trieMap.add(word2);

        assertFalse(trieMap.search("pattern"));
    }

    @Test
    public void shouldAddOneLetterWord() {
        var word = "p";
        TrieMap trieMap = new TrieMap();
        trieMap.add(word);

        assertTrue(trieMap.search(word));
    }
}
