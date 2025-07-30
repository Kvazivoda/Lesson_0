package org.example;
import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    // Геттеры
    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public List<Integer> getGrades() { return new ArrayList<>(grades); }

    // Сеттер для курса
    public void setCourse(int course) { this.course = course; }

    // Вычисление среднего балла
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ")";
    }
}

