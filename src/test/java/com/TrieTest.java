package com;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    @Test
    public void shouldInsertWord() {
        Trie trie = new Trie();
        trie.add("add");
        trie.add("ads");

        assertTrue(trie.search("ads"));
        assertTrue(trie.search("add"));
        assertFalse(trie.search("adn"));
    }
}
