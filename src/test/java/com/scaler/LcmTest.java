package com.scaler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LcmTest {
    @Test
    public void shouldGetLcm() {
        assertEquals(10, new Lcm().getLcm(5, 10));
    }
}
