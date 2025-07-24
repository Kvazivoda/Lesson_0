package org.example;

public class LessonFour {
    // Задание 1
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        private final int row;
        private final int col;

        public MyArrayDataException(String message, int row, int col) {
            super(message);
            this.row = row;
            this.col = col;
        }

        @Override
        public String getMessage() {
            return super.getMessage() + " в ячейке [" + row + "][" + col + "]";
        }
    }

    /**
     * Метод для обработки двумерного массива
     * @param matrix Двумерный строковый массив 4x4
     * @return Сумма элементов массива
     * @throws MyArraySizeException Если размер массива не 4x4
     * @throws MyArrayDataException Если элемент не может быть преобразован в число
     */
    public static int processArray(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        // Проверка на null
        if (matrix == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }

        // Проверка размера массива
        if (matrix.length != 4) {
            throw new MyArraySizeException(
                    String.format("Массив должен иметь 4 строки. Получено: %d строк", matrix.length)
            );
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Строка %d должна содержать 4 элемента. Получено: %s",
                                i,
                                matrix[i] == null ? "null" : matrix[i].length + " элементов")
                );
            }
        }

        int sum = 0;

        // Задание 2
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Невозможно преобразовать в число: '%s'",
                                    matrix[i][j] == null ? "null" : matrix[i][j]),
                            i, j
                    );
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Пример корректного массива
        String[][] correctMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример массива с ошибкой данных
        String[][] dataErrorMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "fifteen", "16"}  // Ошибка в [3][2]
        };

        // Пример массива неправильного размера
        String[][] sizeErrorMatrix = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        // Пример null массива
        String[][] nullMatrix = null;

        // Пример массива с null строкой
        String[][] nullRowMatrix = {
                {"1", "2", "3", "4"},
                null,
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Задание 3
        try {
            System.out.println("1. Сумма корректного массива: " + processArray(correctMatrix));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("1. Ошибка: " + e.getMessage());
        }

        // Демонстрация обработки ошибки данных
        try {
            System.out.println("2. Сумма массива с ошибкой данных: " + processArray(dataErrorMatrix));
        } catch (MyArraySizeException e) {
            System.out.println("2. Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("2. Ошибка данных: " + e.getMessage());
        }

        // Демонстрация обработки ошибки размера
        try {
            System.out.println("3. Сумма массива неправильного размера: " + processArray(sizeErrorMatrix));
        } catch (MyArraySizeException e) {
            System.out.println("3. Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("3. Ошибка данных: " + e.getMessage());
        }

        // Демонстрация обработки null массива
        try {
            System.out.println("4. Сумма null массива: " + processArray(nullMatrix));
        } catch (MyArraySizeException e) {
            System.out.println("4. Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("4. Ошибка данных: " + e.getMessage());
        }

        // Демонстрация обработки массива с null строкой
        try {
            System.out.println("5. Сумма массива с null строкой: " + processArray(nullRowMatrix));
        } catch (MyArraySizeException e) {
            System.out.println("5. Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("5. Ошибка данных: " + e.getMessage());
        }

        // Задание 4
        try {
            System.out.println("\n6. Генерация ArrayIndexOutOfBoundsException:");
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);  // Выход за границы массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("6. Поймано исключение: " + e);
            System.out.println("6. Сообщение: " + e.getMessage());
            System.out.println("6. Стек вызовов:");
            e.printStackTrace();
        }
    }
}