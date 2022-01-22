package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrieNode {
    private List<TrieNode> children = new ArrayList<>();
    private char prefixChar = '\0';
    private String prefix = "";

    public char getPrefixChar() {
        return prefixChar;
    }

    public TrieNode(String prefix, char prefixChar) {
        this.prefix = prefix;
        this.prefixChar = prefixChar;
    }

    public void add(String key) {
        if (key.length() == 1)
            return;

        char newPrefixChar = key.charAt(1);
        String newPrefix = prefix + newPrefixChar;

        if (children.stream().filter(c -> c.getPrefixChar() == newPrefixChar).findFirst().isPresent()) {
            children.stream().filter(c -> c.getPrefixChar() == newPrefixChar).findFirst().get().add(key.substring(1));
        } else {
            TrieNode childTrie = new TrieNode(newPrefix, newPrefixChar);
            children.add(childTrie);
            childTrie.add(key.substring(1));
        }
    }

    public boolean search(String key) {
        if (key.charAt(0) != prefixChar)
            return false;

        if (key.length() == 1 && (key.equals(prefixChar + "")))
            return true;

        char newPrefixChar = key.charAt(1);
        Optional<TrieNode> child = children.stream().filter(c -> c.getPrefixChar() == newPrefixChar).findFirst();
        if (child.isEmpty())
            return false;

        return child.get().search(key.substring(1));
    }
}

class Trie {
    private List<TrieNode> roots = new ArrayList<>();

    public Trie() {
        for (int i = 0; i < 26; i++) {
            char prefix = (char) ('a' + i);
            this.roots.add(new TrieNode("" + prefix, prefix));
        }
    }

    public void add(String key) {
        roots.stream().filter(n -> n.getPrefixChar() == key.charAt(0)).findFirst().get().add(key);
    }

    public boolean search(String key) {
        if (key == "")
            return false;

        return roots.stream().filter(n -> n.getPrefixChar() == key.charAt(0)).findFirst().get().search(key);
    }
}
