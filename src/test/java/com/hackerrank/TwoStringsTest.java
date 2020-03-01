package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TwoStringsTest {

    private TwoStrings twoStrings;

    @Before
    public void init() {

        twoStrings = new TwoStrings();

    }

    @Test
    public void checkIfTwoStringsHaveCommonSubString() {
        final var string1 = "aaaaa";
        final var string2 = "bbbbbba";

        String hasSubString = twoStrings.checkIfStringsHaveSubStrings(string1, string2);

        assertEquals(hasSubString, "YES");
    }

    @Test
    public void checkIfTwoStringsHaveNoSubString() {
        final var string1 = "aaaaa";
        final var string2 = "bbbbbb";

        String hasSubString = twoStrings.checkIfStringsHaveSubStrings(string1, string2);

        assertEquals(hasSubString, "NO");
    }
}
