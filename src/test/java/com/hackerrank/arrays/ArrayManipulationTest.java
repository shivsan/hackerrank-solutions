package com.hackerrank.arrays;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArrayManipulationTest extends TestCase {

    @Test
    public void testArrayManipulation() {
        long maxElement = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        new int[]{1, 5, 3},
                        new int[]{4, 8, 7},
                        new int[]{6, 9, 1}
                });

        assertEquals(10, maxElement);
    }

    @Test
    public void testArrayManipulation1() {
        long maxElement = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        new int[]{1, 2, 100},
                        new int[]{2, 5, 100},
                        new int[]{3, 4, 100}
                });

        assertEquals(200, maxElement);
    }

    @Test
    public void testArrayManipulation2() {
        long maxElement = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        new int[]{2, 5, 8},
                        new int[]{3, 5, 7},
                        new int[]{1, 8, 1},
                        new int[]{5, 9, 15}
                });

        assertEquals(31, maxElement);
    }

    @Test
    public void testWorkWhenAIsEqualToB() {
        long maxElement = ArrayManipulation.arrayManipulation(4,
                new int[][]{
                        new int[]{2, 3, 603},
                        new int[]{1, 1, 286},
                        new int[]{4, 4, 882}
                });

        assertEquals(882, maxElement);
    }

    @Test
    public void testBigTestCase() throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get("./src/test/java/com/hackerrank/arrays/Big test case"), StandardCharsets.UTF_8);
        int[][] queries = new int[30000][];

        for (int i = 0; i < lines.size(); i++) {
            String[] abk = lines.get(i).split(" ");
            int a = Integer.parseInt(abk[0]);
            int b = Integer.parseInt(abk[1]);
            int k = Integer.parseInt(abk[2]);
            queries[i] = new int[]{a, b, k};
        }

        long maxElement = ArrayManipulation.arrayManipulation(4000, queries);

        assertEquals(7515267971l, maxElement);
    }
}
