package org.example;
import java.util.Scanner;

public class Lesson_7_junit_5 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 1. Факториал
            System.out.println("\n=== Вычисление факториала ===");
            System.out.print("Введите число: ");
            int factorialInput = scanner.nextInt();
            System.out.println(factorialInput + "! = " + FactorialCalculator.calculate(factorialInput));

            // 2. Площадь треугольника
            System.out.println("\n=== Площадь треугольника ===");
            System.out.print("Введите основание: ");
            double base = scanner.nextDouble();
            System.out.print("Введите высоту: ");
            double height = scanner.nextDouble();
            System.out.printf("Площадь: %.2f\n", TriangleArea.calculate(base, height));

            // 3. Арифметические операции
            System.out.println("\n=== Арифметические операции ===");

            System.out.print("Введите первое число: ");
            int a = scanner.nextInt();
            System.out.print("Введите второе число: ");
            int b = scanner.nextInt();
            System.out.println(ArithmeticOperations.performOperations(a, b));

            // 4. Сравнение чисел
            System.out.println("\n=== Сравнение чисел ===");
            System.out.print("Введите первое число: ");
            int x = scanner.nextInt();
            System.out.print("Введите второе число: ");
            int y = scanner.nextInt();
            System.out.println(NumberComparator.compare(x, y));

            scanner.close();
}
    }
