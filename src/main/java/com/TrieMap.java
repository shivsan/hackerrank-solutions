package com;

import java.util.HashMap;

public class TrieMap {
    private final HashMap<Character, TrieMap> nodes = new HashMap<>();
    private Character prefixCharacter;
    private char endLine = '\n';
    private char rootCharacter = '\0';

    public TrieMap(Character prefixCharacter) {
        this.prefixCharacter = prefixCharacter;
    }

    public TrieMap() {
        this.prefixCharacter = rootCharacter;
    }

    public void add(String key) {
        if (key.length() == 0) {
            nodes.putIfAbsent(endLine, null);
            return;
        }

        char childKey = key.charAt(0);
        nodes.putIfAbsent(childKey, new TrieMap(childKey));
        var child = nodes.get(childKey);
        child.add(key.substring(1));
    }

    public boolean search(String key) {
        if (nodes.isEmpty())
            return false;

        if (key.length() == 0)
            return nodes.containsKey(endLine);

        return nodes.get(key.charAt(0)).search(key.substring(1));
    }
}
