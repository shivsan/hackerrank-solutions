package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RepeatedIntegerTest {

    private RepeatedInteger repeatedInteger;

    @Before
    public void init() {
        repeatedInteger = new RepeatedInteger();
    }

    @Test
    public void getRepeatedInteger() {
        final int[] arrayWithRepeatedInteger = {1, 2, 3, 1, 4, 5, 6, 7};

        final int result = repeatedInteger.getRepeatedInteger(arrayWithRepeatedInteger);

        assertEquals(result, 1);
    }
}