package com.leetcode;

import java.util.List;

public class ItemMatcher {
    public class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            return (int) items.stream()
                    .filter(item -> match(item.get(0), item.get(1), item.get(2), ruleKey, ruleValue))
                    .count();
        }

        private boolean match(String type, String color, String name, String ruleKey, String ruleValue) {
            switch (ruleKey) {
                case "type":
                    return type.equals(ruleValue);
                case "name":
                    return name.equals(ruleValue);
                case "color":
                    return color.equals(ruleValue);
            }
            return false;
        }
    }
}
