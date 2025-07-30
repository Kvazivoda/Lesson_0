package org.example;

import java.util.*;

public class LessonFive {
        public static void main(String[] args) {
            // Создание коллекции студентов
            List<Student> students = new ArrayList<>();
            students.add(new Student("Иван", "Гр-101", 1, Arrays.asList(4, 5, 3, 4)));
            students.add(new Student("Мария", "Гр-102", 2, Arrays.asList(5, 5, 5, 5)));
            students.add(new Student("Петр", "Гр-201", 1, Arrays.asList(2, 3, 2, 2)));
            students.add(new Student("Анна", "Гр-202", 3, Arrays.asList(3, 4, 3, 4)));
            students.add(new Student("Дмитрий", "Гр-301", 4, Arrays.asList(5, 4, 5, 4)));

            System.out.println("=== Исходный список студентов ===");
            students.forEach(System.out::println);

            // Удаление неуспевающих студентов
            removeUnderperformingStudents(students);
            System.out.println("\n=== После отчисления неуспевающих ===");
            students.forEach(System.out::println);

            // Перевод студентов на следующий курс
            promoteStudents(students);
            System.out.println("\n=== После перевода на следующий курс ===");
            students.forEach(System.out::println);

            // Вывод студентов 2 курса
            System.out.println("\n=== Студенты 2 курса ===");
            printStudents(new HashSet<>(students), 2);
        }

        public static void removeUnderperformingStudents(Collection<Student> students) {
            students.removeIf(student -> student.getAverageGrade() < 3.0);
        }

        public static void promoteStudents(Collection<Student> students) {
            for (Student student : students) {
                if (student.getAverageGrade() >= 3.0) {
                    student.setCourse(student.getCourse() + 1);
                }
            }
        }

        public static void printStudents(Set<Student> students, int course) {
            students.stream()
                    .filter(student -> student.getCourse() == course)
                    .map(Student::getName)
                    .forEach(System.out::println);

            PhoneDirectory phoneBook = new PhoneDirectory();

            // Добавляем записи
            phoneBook.add("Иванов", "+7(999)111-22-33");
            phoneBook.add("Петров", "+7(999)444-55-66");
            phoneBook.add("Иванов", "+7(999)777-88-99");  // Второй номер для Иванова

            // Поиск номеров
            System.out.println("Иванов: " + phoneBook.get("Иванов"));
            System.out.println("Петров: " + phoneBook.get("Петров"));
            System.out.println("Сидоров: " + phoneBook.get("Сидоров"));  // Несуществующая фамилия
        }
}



