package com.student;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testCalculateBaseBillFirst100() {
        assertEquals(150.00, App.calculateBaseBill(100), 0.001);
    }

    @Test
    public void testCalculateBaseBillTwoHundredFifty() {
        assertEquals(600.00, App.calculateBaseBill(250), 0.001);
    }

    @Test
    public void testCalculateTax() {
        assertEquals(27.00, App.calculateTax(150.00), 0.001);
    }

    @Test
    public void testCalculateFinalBill() {
        assertEquals(177.00, App.calculateFinalBill(100), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeUnitsThrowsException() {
        App.calculateBaseBill(-10);
    }
}
