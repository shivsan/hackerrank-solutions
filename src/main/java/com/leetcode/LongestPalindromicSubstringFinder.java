package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestPalindromicSubstringFinder {
    public String longestPalindrome(String s) {
        String largestPalindromeSubStringWithCentre = getLargestPalindromeSubStringWithCentre(s);
        String largestPalindromeSubStringWithoutCentre = getLargestPalindromeSubStringWithoutCentre(s);
        return largestPalindromeSubStringWithCentre.length() > largestPalindromeSubStringWithoutCentre.length()
                ? largestPalindromeSubStringWithCentre : largestPalindromeSubStringWithoutCentre;
    }

    private String getLargestPalindromeSubStringWithCentre(String s) {
        List<Integer> palindromicSubstringIndexCentres = new LinkedList();
        palindromicSubstringIndexCentres.addAll(IntStream.range(1, s.length() - 1).boxed().collect(Collectors.toList()));
        int largestPalindromeIndex = 0;
        int largestPalindromeOneDirectionalWidth = 0;

        for (int oneDirectionalWidth = 1; oneDirectionalWidth < Math.ceil(s.length() / 2D); oneDirectionalWidth++) {
            for (int i = 0; i < palindromicSubstringIndexCentres.size(); i++) {
                while (i < palindromicSubstringIndexCentres.size() &&
                        !checkIfPalindromeEnlargens(s, oneDirectionalWidth, palindromicSubstringIndexCentres.get(i))) {
                    palindromicSubstringIndexCentres.remove(i);
                }
            }

            if (palindromicSubstringIndexCentres.size() > 0) {
                largestPalindromeIndex = palindromicSubstringIndexCentres.get(0);
                largestPalindromeOneDirectionalWidth = oneDirectionalWidth;
            }
        }

        return s.substring(largestPalindromeIndex - largestPalindromeOneDirectionalWidth, largestPalindromeIndex + largestPalindromeOneDirectionalWidth + 1);
    }

    private String getLargestPalindromeSubStringWithoutCentre(String s) {
        List<CentricPair> palindromicSubstringIndexCentres = new LinkedList();
        palindromicSubstringIndexCentres.addAll(
                IntStream
                        .range(0, s.length() - 1)
                        .boxed()
                        .map(i -> new CentricPair(i, i + 1))
                        .collect(Collectors.toList()));
        CentricPair largestPalindromeIndex = null;
        int largestPalindromeOneDirectionalWidth = 0;

        for (int oneDirectionalWidth = 0; oneDirectionalWidth < Math.ceil(s.length() / 2D); oneDirectionalWidth++) {
            for (int i = 0; i < palindromicSubstringIndexCentres.size(); i++) {
                while (i < palindromicSubstringIndexCentres.size() &&
                        !checkIfPalindromeEnlargens(s, oneDirectionalWidth, palindromicSubstringIndexCentres.get(i))) {
                    palindromicSubstringIndexCentres.remove(i);
                }
            }

            if (palindromicSubstringIndexCentres.size() > 0) {
                largestPalindromeIndex = palindromicSubstringIndexCentres.get(0);
                largestPalindromeOneDirectionalWidth = oneDirectionalWidth;
            }
        }

        if (largestPalindromeIndex == null)
            return "";

        return s.substring(largestPalindromeIndex.leftIndex - largestPalindromeOneDirectionalWidth, largestPalindromeIndex.rightIndex + largestPalindromeOneDirectionalWidth + 1);
    }

    private boolean checkIfPalindromeEnlargens(String s, int width, int index) {
        int boundaryIncrement = width;
        int rightEnlargenedIndex = index + boundaryIncrement;
        int leftEnlargenedIndex = index - boundaryIncrement;

        if (leftEnlargenedIndex < 0 || rightEnlargenedIndex >= s.length())
            return false;

        return s.charAt(leftEnlargenedIndex) == s.charAt(rightEnlargenedIndex);
    }

    private boolean checkIfPalindromeEnlargens(String s, int width, CentricPair index) {
        int boundaryIncrement = width;
        int rightEnlargenedIndex = index.rightIndex + boundaryIncrement;
        int leftEnlargenedIndex = index.leftIndex - boundaryIncrement;

        if (leftEnlargenedIndex < 0 || rightEnlargenedIndex >= s.length())
            return false;

        return s.charAt(leftEnlargenedIndex) == s.charAt(rightEnlargenedIndex);
    }

    private class CentricPair {
        int leftIndex;
        int rightIndex;

        public CentricPair(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
}

