package org.example;

/*public class LessoneOne {   public static void printThreeWords() {
    System.out.println("Orange");
    System.out.println("Banana");
    System.out.println("Apple");
}

    public static void main(String[] args) {
        printThreeWords();
    }
} */


public class LessoneOne {
    public static void checkSumSign() {
        int a = 15;
        int b = -10;

        int sum = a + b;

        // Проверка суммы и вывод результата
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void main(String[] args) {
        checkSumSign();
    }
}
