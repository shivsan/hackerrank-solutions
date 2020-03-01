package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CoinChangeTest {

    private CoinChange coinChange;

    @Before
    public void init() {
        coinChange = new CoinChange();
    }

    @Test
    public void getNumberOfWaysToGetChangeForCoin() {
        final int[] coinDenominations = {1, 2, 3, 8};
        final var change = 3;

        int result = coinChange.getCoinChangeWays(coinDenominations, change);

        assertEquals(result, 3);
    }
}
