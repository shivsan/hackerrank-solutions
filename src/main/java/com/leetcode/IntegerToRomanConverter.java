package com.leetcode;

import java.util.LinkedHashMap;

public class IntegerToRomanConverter {
    private LinkedHashMap<String, Integer> denominations = new LinkedHashMap<>();
    private LinkedHashMap<String, String> thresholds = new LinkedHashMap<>();

    public IntegerToRomanConverter() {
        denominations.put("M", 1000);
        denominations.put("D", 500);
        denominations.put("C", 100);
        denominations.put("L", 50);
        denominations.put("X", 10);
        denominations.put("V", 5);
        denominations.put("I", 1);

        thresholds.put("M", "C");
        thresholds.put("D", "C");
        thresholds.put("C", "X");
        thresholds.put("L", "X");
        thresholds.put("X", "I");
        thresholds.put("V", "I");
    }

    public String intToRoman(int number) {
        if (number == 0)
            return "";

        for (String denomination : denominations.keySet()) {
            if (isNumberGreaterThanDenomination(number, denomination)) {
                int remainingNumber = number - denominations.get(denomination);
                return denomination + intToRoman(remainingNumber);
            }

            if (isNumberWithinNegativeThresholdOfDenomination(number, denomination)) {
                String thresholdDenomination = thresholds.get(denomination);
                Integer thresholdDenominationValue = denominations.get(thresholdDenomination);
                Integer denominationValue = denominations.get(denomination);
                return thresholdDenomination + denomination + intToRoman(number - (denominationValue - thresholdDenominationValue));
            }
        }

        return "";
    }

    private boolean isNumberGreaterThanDenomination(int number, String denomination) {
        return number >= denominations.get(denomination);
    }

    private boolean isNumberWithinNegativeThresholdOfDenomination(int number, String denomination) {
        int threshold = denominations.get(thresholds.get(denomination));
        int denominationValue = denominations.get(denomination);

        return number >= (denominationValue - threshold);
    }
}
