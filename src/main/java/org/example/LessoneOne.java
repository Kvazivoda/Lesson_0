package org.example;
import java.util.Arrays;

public class LessoneOne {
    // 1. Метод для вывода трех слов
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Метод для проверки суммы
    public static void checkSumSign() {
        int a = 15;
        int b = -10;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Новый метод для определения цвета
    public static void printColor() {
        int value = 42;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    // 4. Новый метод для сравнения чисел
    public static void compareNumbers() {
        int a = 25;
        int b = 17;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    // 5. Новый метод true and false
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    // 6. Новый метод число
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
    // 7. Новый метод отрицательный false
        public static boolean isNegative(int number) {
            return number < 0;
        }
    // 8. Новый метод вывод строк
    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
    // 9. Новый метод високосный год
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;  // Каждый 400-й год - високосный
        } else if (year % 100 == 0) {
            return false; // Каждый 100-й год - не високосный (исключение)
        } else {
            return year % 4 == 0; // Остальные: каждый 4-й год - високосный
        }
    }
    // 10. Новый метод массив замена
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // 11. Новый метод массив сотка
    public static void fillArray1To100(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
    // 12. Новый метод числа меньше 6*2
    public static void multiplyLessThan6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
    }
    // 13. Заполнение диагоналей матрицы
    public static void fillDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    // 14. Создание массива с одинаковыми значениями
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    // Главный метод
    public static void main(String[] args) {
        printThreeWords(); // Вызов 1 метода
        checkSumSign();    // Вызов 2 метода
        printColor();      // Вызов 3 метода
        compareNumbers();  // Вызов 4 метода
        System.out.println(isSumInRange(10, 11)); // Вызов 5 метода
        checkNumber(0); // Вызов 6 метода
        System.out.println(isNegative(-5)); // Вызов 7 метода
        printStringMultipleTimes("Moon", 3); // Вызов 8 метода
        System.out.println(isLeapYear(2000)); // Вызов 9 метода
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(array1); // Вызов 10 метода
        printArray(array1); // Вызов 10 метода
        int[] array2 = new int[100];
        fillArray1To100(array2); // Вызов 11 метода
        printArray(array2); // Вызов 11 метода
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThan6(array3); // Вызов 12 метода
        printArray(array3); // Вызов 12 метода
        int[][] matrix = new int[5][5];
        fillDiagonals(matrix); // Вызов 13 метода
        printMatrix(matrix); // Вызов 13 метода
        int[] array4 = createArray(5, 10);
        printArray(array4); // Вызов 14 метода
    }
}
