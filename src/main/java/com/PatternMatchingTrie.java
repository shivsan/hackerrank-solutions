package com;

import java.util.Arrays;
import java.util.HashMap;

public class PatternMatchingTrie {
    private final HashMap<Character, PatternMatchingTrie> nodes = new HashMap<>();
    private Character prefixCharacter;
    private char endLine = '\n';
    private char rootCharacter = '\0';

    public PatternMatchingTrie(Character prefixCharacter) {
        this.prefixCharacter = prefixCharacter;
    }

    public PatternMatchingTrie() {
        this.prefixCharacter = rootCharacter;
    }

    public void add(String key) {
        if (key.length() == 0) {
            nodes.putIfAbsent(endLine, null);
            return;
        }

        char childKey = key.charAt(0);
        nodes.putIfAbsent(childKey, new PatternMatchingTrie(childKey));
        var child = nodes.get(childKey);
        child.add(key.substring(1));
    }

    public void add(String... keys) {
        Arrays.stream(keys).forEach(this::add);
    }

    public boolean search(String key) {
        if (nodes.isEmpty())
            return false;

        if (key.length() == 0)
            return nodes.containsKey(endLine);

        var characterToSearch = key.charAt(0);
        if (characterToSearch == '.') {
            if (key.length() == 1)
                return nodes.entrySet().stream().anyMatch(child -> child.getValue().search(""));

            return nodes.entrySet().stream().anyMatch(child -> child.getValue().search(key.substring(1)));
        }

        var child = nodes.get(characterToSearch);
        if (child == null)
            return false;

        return child.search(key.substring(1));
    }
}
