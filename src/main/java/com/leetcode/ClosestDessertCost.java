package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestDessertCost {
    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            baseCosts = Arrays.stream(baseCosts).sorted().toArray();
            toppingCosts = Arrays.stream(toppingCosts).sorted().toArray();

            List<List<Integer>> memo = new ArrayList<>();
            Arrays.stream(baseCosts).forEach(b -> memo.add(new ArrayList<>()));

            var b = memo.get(0);

            for (var t : toppingCosts) {
                var cost = getCost(baseCosts[0], t, 0);
                if (!addIfLimitNotReached(b, target, cost))
                    break;
                cost = getCost(baseCosts[0], t, 1);
                if (!addIfLimitNotReached(b, target, cost))
                    break;
                cost = getCost(baseCosts[0], t, 2);
                if (!addIfLimitNotReached(b, target, cost))
                    break;
            }

            for (int i = 1; i < baseCosts.length - 1; i++) {
                for (int j = 1; j < toppingCosts.length - 1; j++) {
                    var cost = memo.get(i - 1).get(j) - baseCosts[i - 1] + baseCosts[i];

                    if (!addIfLimitNotReached(b, target, cost))
                        break;
                }
            }

            var closestCost = baseCosts[0];

            for (int i = 0; i < memo.size() - 1; i++) {
                if (Math.abs(memo.get(i).get(memo.size() - 1) - target) < Math.abs(closestCost - target)) {
                    closestCost = memo.get(i).get(memo.size() - 1);
                }
            }

            return closestCost;
        }

        private int getCost(int bi, int ti, int tiCount) {
            return bi + ti * tiCount;
        }

        private boolean addIfLimitNotReached(List<Integer> costs, int target, int value) {
            if (costs.get(costs.size() - 1) > target)
                return false;
            costs.add(value);
            return true;
        }
    }
}
