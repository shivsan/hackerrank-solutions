package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CoinChange {
    private int noOfWays = 0;
    private int[] coinDenominations;
    private List<int[]> successfulResults = new ArrayList<>();

    public int getCoinChangeWays(int[] coinDenominations, int change) {
        this.coinDenominations = coinDenominations;
        findNoOfWays1(new int[coinDenominations.length], 0, change);

        return noOfWays;
    }

    private void findNoOfWays1(int[] coinDenominationCoefficients, int currentIndex, int change) {
        if (currentIndex >= coinDenominations.length)
            return;

        if (change == 0) {
            successfulResults.add(coinDenominationCoefficients.clone());
            noOfWays++;
            return;
        }

        if (change < 0) {
            return;
        }

        for (int i = 0; change >= 0; i++) {
            findNoOfWays1(coinDenominationCoefficients, currentIndex + 1, change);
            change -= coinDenominations[currentIndex];
            coinDenominationCoefficients[currentIndex]++;
        }
    }

    private int totalChange(int[] coinDenominationCoefficients) {
        final var noOfDenominations = coinDenominations.length;
        return IntStream.range(0, noOfDenominations).map(i -> coinDenominations[i] * coinDenominationCoefficients[i]).sum();
    }
}
