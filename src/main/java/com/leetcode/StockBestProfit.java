package com.leetcode;

import java.util.Arrays;

public class StockBestProfit {
    public int getBestProfit(int[] stockPrices) {
        return getBestProfit(stockPrices, 0, false, false, 0);
    }

    private int getBestProfit(int[] stockPrices,
                              int day,
                              boolean boughtPrevious,
                              boolean soldPreviousDay,
                              int profit) {
        if (day > stockPrices.length - 1)
            return profit;

        int profitPass = profit;
        int profitUnsold = profit;
        int profitSold = profit;
        int profitBought = profit;

        profitPass = getBestProfit(stockPrices,
                day + 1,
                boughtPrevious,
                false,
                profit);

        if (soldPreviousDay)
            profitSold = getBestProfit(stockPrices,
                    day + 1,
                    false,
                    false,
                    profit);

        if (boughtPrevious)
            profitSold = getBestProfit(stockPrices,
                    day + 1,
                    false,
                    true,
                    profit += stockPrices[day]);

        if (!(soldPreviousDay || boughtPrevious))
            profitBought = getBestProfit(stockPrices,
                    day + 1,
                    true,
                    false,
                    profit -= stockPrices[day]);

        return Arrays.asList(profitPass, profitSold, profitBought, profitUnsold)
                .stream()
                .sorted((integer, anotherInteger) -> -integer.compareTo(anotherInteger))
                .findFirst()
                .get();
    }

    public int getBestProfitDP(int[] stockPrices) {
        int boughtState[] = new int[stockPrices.length];
        int soldState[] = new int[stockPrices.length];
        int cooledState[] = new int[stockPrices.length];
        boughtState[0] = -stockPrices[0];
        soldState[0] = 0;
        cooledState[0] = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            boughtState[i] = Integer.max(boughtState[i - 1], cooledState[i - 1] - stockPrices[i]);
            soldState[i] = boughtState[i - 1] += stockPrices[i];
            cooledState[i] = Integer.max(cooledState[i - 1], soldState[i - 1]);
        }

        return Integer.max(soldState[soldState.length - 1], cooledState[cooledState.length - 1]);
    }
}
