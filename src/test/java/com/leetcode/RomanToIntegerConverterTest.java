package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static com.leetcode.RomanToIntegerConverter.solution;
import static org.junit.Assert.*;

public class RomanToIntegerConverterTest {
    @Test
    public void name() {
        int[] a = {98};
        int[] res = solution(a);

        System.out.println(res);
    }

    @Test
    public void name2() {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("cog");

        int solution = new RomanToIntegerConverter().solution("hit", "cog", wordList);

        System.out.println(solution);
    }
}
