package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockBestProfitTest {
    StockBestProfit stockBestProfit = new StockBestProfit();

    @Test
    public void shouldGetBestPrice() {
        int bestProfit = stockBestProfit.getBestProfit(new int[]{1, 2, 3, 0, 2});

        assertEquals(3, bestProfit);
    }

    @Test
    public void shouldGetBestPrice1() {
        int bestProfit = stockBestProfit.getBestProfit(new int[]{1});

        assertEquals(0, bestProfit);
    }

    @Test
    public void shouldGetBestPrice2DP() {
        int bestProfit = stockBestProfit.getBestProfitDP(new int[]{48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15, 11, 94});

        assertEquals(428, bestProfit);
    }

    @Test
    public void shouldGetBestPriceDP() {
        int bestProfit = stockBestProfit.getBestProfitDP(new int[]{1, 2, 3, 0, 2});

        assertEquals(3, bestProfit);
    }

    @Test
    public void shouldGetBestPrice1DP() {
        int bestProfit = stockBestProfit.getBestProfitDP(new int[]{1});

        assertEquals(0, bestProfit);
    }

    @Test
    public void shouldGetBestPriceDP3() {
        int bestProfit = stockBestProfit.getBestProfitDP(new int[]{2, 1, 4});

        assertEquals(3, bestProfit);
    }
}
