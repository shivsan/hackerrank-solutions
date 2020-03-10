package com.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MatchTwoStringsTest {

    @Test
    public void shouldMatchStrings() {

        String result = MatchTwoStrings.abbreviation("daBcd", "ABC");

        assertEquals(result, "YES");
    }

    @Test
    public void shouldNotMatchStrings() {

        String result = MatchTwoStrings.abbreviation("beFgH", "EFG");

        assertEquals(result, "NO");
    }

}