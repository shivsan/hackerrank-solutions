package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockBestProfitTest {
    @Test
    public void shouldGetBestPrice() {
        int bestProfit = new StockBestProfit().getBestProfit(new int[]{1, 2, 3, 0, 2});

        assertEquals(3, bestProfit);
    }

    @Test
    public void shouldGetBestPrice1() {
        int bestProfit = new StockBestProfit().getBestProfit(new int[]{1});

        assertEquals(0, bestProfit);
    }
}
