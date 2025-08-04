package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TriangleAreaTestNG {

    @Test
    public void testAreaWithPositiveNumbers() {
        assertEquals(TriangleArea1.calculate(5, 4), 10.0);
    }

    @Test
    public void testAreaWithDecimalNumbers() {
        assertEquals(TriangleArea1.calculate(2.5, 3), 3.75);
    }

    @Test
    public void testAreaWithZeroHeight() {
        assertEquals(TriangleArea1.calculate(10, 0), 0.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeBase() {
        TriangleArea1.calculate(-5, 4);
    }
}
