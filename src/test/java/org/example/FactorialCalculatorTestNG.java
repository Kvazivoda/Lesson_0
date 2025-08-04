package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator1.calculate(0), 1L);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator1.calculate(1), 1L);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(FactorialCalculator1.calculate(5), 120L);
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(FactorialCalculator1.calculate(10), 3628800L);
    }
}
