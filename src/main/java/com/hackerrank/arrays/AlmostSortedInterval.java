package com.hackerrank.arrays;

import java.util.ArrayDeque;

public class AlmostSortedInterval {
    static int solve(int[] arr) {
        int window = 1; // Skipping the case of a single element during computation and adding it to the answer
        int noOfAlmostSortedIntervals = arr.length;

        while (window < arr.length) {
            IntervalMaxQueue intervalMaxQueue = new IntervalMaxQueue();
            IntervalMinQueue intervalMinQueue = new IntervalMinQueue();

            prepWindow(arr, 0, window - 1, intervalMaxQueue, intervalMinQueue);

            for (int endIndex = window, startIndex = endIndex - window; endIndex < arr.length; endIndex++, startIndex++) {
                // Add element moving into the window
                intervalMaxQueue.addElement(arr[endIndex]);
                intervalMinQueue.addElement(arr[endIndex]);

                if (checkIfAlmostSortedInterval(intervalMaxQueue, intervalMinQueue, arr, startIndex, endIndex))
                    noOfAlmostSortedIntervals++;

                // Remove element moving out of the window
                if (intervalMaxQueue.getLargest() == arr[startIndex])
                    intervalMaxQueue.removeLargestElement();

                if (intervalMinQueue.getSmallest() == arr[startIndex])
                    intervalMinQueue.removeSmallestElement();
            }

            window++;
        }

        return noOfAlmostSortedIntervals;
    }

    private static void prepWindow(int[] arr, int startIndex, int endIndex, IntervalMaxQueue intervalMaxQueue, IntervalMinQueue intervalMinQueue) {
        for (int i = startIndex; i <= endIndex; i++) {
            intervalMaxQueue.addElement(arr[i]);
            intervalMinQueue.addElement(arr[i]);
        }
    }

    private static boolean checkIfAlmostSortedInterval(IntervalMaxQueue intervalMaxQueue,
                                                       IntervalMinQueue intervalMinQueue,
                                                       int[] arr,
                                                       int startIndex,
                                                       int endIndex) {
        return intervalMaxQueue.getLargest() == arr[endIndex] &&
                intervalMinQueue.getSmallest() == arr[startIndex];
    }
}

class IntervalMinQueue {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    void addElement(int element) {
        removeLargerElementsFromTheRear(element);

        queue.addLast(element);
    }

    Integer getSmallest() {
        return queue.peekFirst();
    }

    void removeSmallestElement() {
        if (queue.peekFirst() != null)
            queue.removeFirst();
    }

    private void removeLargerElementsFromTheRear(int element) {
        while (queue.peekLast() != null && queue.peekLast() > element) {
            queue.removeLast();
        }
    }
}

class IntervalMaxQueue {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    void addElement(int element) {
        removeSmallerElementsFromTheRear(element);

        queue.addLast(element);
    }

    Integer getLargest() {
        return queue.peekFirst();
    }

    void removeLargestElement() {
        if (queue.peekFirst() != null)
            queue.removeFirst();
    }

    private void removeSmallerElementsFromTheRear(int element) {
        while (queue.peekLast() != null && queue.peekLast() < element) {
            queue.removeLast();
        }
    }
}
