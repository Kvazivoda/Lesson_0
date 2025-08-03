package org.example;

public class ArithmeticOperations {
    public static String performOperations(int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        result.append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n");
        result.append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");

        if (b != 0) {
            result.append(a).append(" / ").append(b).append(" = ").append((double) a / b);
        } else {
            result.append("Деление на ноль невозможно!");
        }

        return result.toString();
    }
}



