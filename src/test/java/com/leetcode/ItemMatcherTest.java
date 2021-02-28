package com.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ItemMatcherTest {
    public ItemMatcher.Solution itemMatcher = new ItemMatcher().new Solution();

    @Test
    public void shouldMatch() {
        List<List<String>> items = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add("phone");
                add("blue");
                add("pixel");
            }});
            add(new ArrayList<>() {{
                add("computer");
                add("silver");
                add("lenovo");
            }});
            add(new ArrayList<>() {{
                add("phone");
                add("gold");
                add("iphone");
            }});
        }};

        int noOfMatches = itemMatcher.countMatches(items, "type", "phone");

        assertEquals(2, noOfMatches);

        noOfMatches = itemMatcher.countMatches(items, "color", "silver");

        assertEquals(1, noOfMatches);


    }
}
