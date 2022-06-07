package com.scaler;

public class Lcm {
    public int getLcm(int a, int b) {
        int aMultiplier = a;
        int bMultiplier = b;

        while (aMultiplier != bMultiplier) {
            if (aMultiplier < bMultiplier) {
                aMultiplier += a;
            } else {
                bMultiplier += b;
            }
        }

        return aMultiplier;
    }
}
