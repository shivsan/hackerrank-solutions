package com.leetcode;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RomanToIntegerTest {
    private RomanToIntegerConverter romanToIntegerConverter = new RomanToIntegerConverter();

    @Test
    @Parameters({"III, 3", "IV, 4", "IX, 9", "MCMXCIV, 1994", "LVIII, 58"})
    public void shouldGetInteger(String romanNumber, int expectedNumber) {
        int convertedInteger = romanToIntegerConverter.convert(romanNumber);

        assertEquals(expectedNumber, convertedInteger);
    }
}
