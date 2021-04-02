package com.hackerrank.arrays;

import junit.framework.TestCase;
import org.junit.Test;

public class AlmostSortedIntervalTest extends TestCase {

    @Test
    public void testAlmostSorted() {
        long noOfAlmostSortedIntervals = AlmostSortedInterval.solve(new int[]{3, 1, 2, 5, 4});

        assertEquals(8, noOfAlmostSortedIntervals);
    }

    @Test
    public void testGetLargestElement() {
        IntervalMaxQueue intervalMaxQueue = new IntervalMaxQueue();
        intervalMaxQueue.addElement(4);
        intervalMaxQueue.addElement(3);
        intervalMaxQueue.addElement(2);
        intervalMaxQueue.addElement(1);

        assertEquals(4, intervalMaxQueue.getLargest().intValue());
    }

    @Test
    public void testRemoveLargestElementWhenALargerElementIsAdded() {
        IntervalMaxQueue intervalMaxQueue = new IntervalMaxQueue();
        intervalMaxQueue.addElement(4);

        intervalMaxQueue.addElement(5);

        assertEquals(5, intervalMaxQueue.getLargest().intValue());
    }

    @Test
    public void testRemoveLargestElement() {
        IntervalMaxQueue intervalMaxQueue = new IntervalMaxQueue();
        intervalMaxQueue.addElement(5);
        intervalMaxQueue.addElement(4);

        intervalMaxQueue.removeLargestElement();

        assertEquals(4, intervalMaxQueue.getLargest().intValue());
    }

    @Test
    public void testRemoveLargestElementWhenThereAreNoElements() {
        IntervalMaxQueue intervalMaxQueue = new IntervalMaxQueue();

        intervalMaxQueue.removeLargestElement();
    }
}
