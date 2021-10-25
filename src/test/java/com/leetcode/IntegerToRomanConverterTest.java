package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanConverterTest {
    private IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();

    @Test
    public void shouldConvertIntToRoman() {
        String romanNumber = integerToRomanConverter.intToRoman(100);

        assertEquals("C", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman1() {
        String romanNumber = integerToRomanConverter.intToRoman(100);

        assertEquals("C", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman2() {
        String romanNumber = integerToRomanConverter.intToRoman(3);

        assertEquals("III", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman3() {
        String romanNumber = integerToRomanConverter.intToRoman(4);

        assertEquals("IV", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman4() {
        String romanNumber = integerToRomanConverter.intToRoman(9);

        assertEquals("IX", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman5() {
        String romanNumber = integerToRomanConverter.intToRoman(58);

        assertEquals("LVIII", romanNumber);
    }

    @Test
    public void shouldConvertIntToRoman6() {
        String romanNumber = integerToRomanConverter.intToRoman(1994);

        assertEquals("MCMXCIV", romanNumber);
    }
}
