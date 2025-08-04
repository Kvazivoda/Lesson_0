package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ArithmeticOperationsTestNG {

    @Test
    public void testAddition() {
        String result = ArithmeticOperations1.performOperations(5, 3);
        assertTrue(result.contains("5 + 3 = 8"));
    }

    @Test
    public void testSubtraction() {
        String result = ArithmeticOperations1.performOperations(10, 4);
        assertTrue(result.contains("10 - 4 = 6"));
    }

    @Test
    public void testMultiplication() {
        String result = ArithmeticOperations1.performOperations(7, 6);
        assertTrue(result.contains("7 * 6 = 42"));
    }

    @Test
    public void testDivision() {
        String result = ArithmeticOperations1.performOperations(10, 2);
        assertTrue(result.contains("10 / 2 = 5.0"));
    }

    @Test
    public void testDivisionByZero() {
        String result = ArithmeticOperations1.performOperations(5, 0);
        assertTrue(result.contains("Деление на ноль невозможно!"));
    }
}
