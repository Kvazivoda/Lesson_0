package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NumberComparatorTestNG {

    @Test
    public void testFirstGreater() {
        assertEquals(NumberComparator1.compare(5, 3), "5 > 3");
    }

    @Test
    public void testSecondGreater() {
        assertEquals(NumberComparator1.compare(2, 4), "2 < 4");
    }

    @Test
    public void testEqualNumbers() {
        assertEquals(NumberComparator1.compare(7, 7), "7 == 7");
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(NumberComparator1.compare(-3, -5), "-3 > -5");
    }
}