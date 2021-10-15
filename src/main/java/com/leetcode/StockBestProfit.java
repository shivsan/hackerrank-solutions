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
}
