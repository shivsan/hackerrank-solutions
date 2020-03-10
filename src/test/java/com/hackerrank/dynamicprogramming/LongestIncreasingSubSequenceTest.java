package com.hackerrank.dynamicprogramming;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LongestIncreasingSubSequenceTest {

    public LongestIncreasingSubSequence longestIncreasingSubSequence;

    @Before
    public void init() {
        longestIncreasingSubSequence = new LongestIncreasingSubSequence();
    }

    @Test
    public void getLongestIncreasingSubSequenceSize() {
        final var sequence = new int[]{10, 22, 11, 12, 40, 13, 14, 50};

        final var longestIncreasingSubSequenceSize = this.longestIncreasingSubSequence.get(sequence);

        assertEquals(longestIncreasingSubSequenceSize, 6);
    }

    @Test
    public void getLongestIncreasingSubSequenceSizeWithLastElementNotPartOfTheBiggestSubSequence() {
        final var sequence = new int[]{10, 22, 11, 12, 40, 13, 14, 50,1};

        final var longestIncreasingSubSequenceSize = this.longestIncreasingSubSequence.get(sequence);

        assertEquals(longestIncreasingSubSequenceSize, 6);
    }
}