package org.example;

public class TriangleArea1 {
    public static double calculate(double base, double height) {
        if (base < 0) {
            throw new IllegalArgumentException("Base cannot be negative");
        }
        return 0.5 * base * height;
    }
}
