package org.example;

public class lessonThree {
    //1 задание
    // Базовый класс Животное
    static class Animal {
        private final String name;
        private static int animalCount = 0;

        public Animal(String name) {
            this.name = name;
            animalCount++;
        }

        public void run(int distance) {
            System.out.println(name + " бежит " + distance + " м.");
        }

        public void swim(int distance) {
            System.out.println(name + " плывет " + distance + " м.");
        }

        public static int getAnimalCount() {
            return animalCount;
        }

        public String getName() {
            return name;
        }
    }

    // Класс Собака
    static class Dog extends Animal {
        private static int dogCount = 0;
        private final int MAX_RUN = 500;
        private final int MAX_SWIM = 10;

        public Dog(String name) {
            super(name);
            dogCount++;
        }

        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN) {
                super.run(distance);
            } else {
                System.out.println(getName() + " не может пробежать больше " + MAX_RUN + " м.");
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= MAX_SWIM) {
                super.swim(distance);
            } else {
                System.out.println(getName() + " не может проплыть больше " + MAX_SWIM + " м.");
            }
        }

        public static int getDogCount() {
            return dogCount;
        }
    }

    // Класс Кот
    static class Cat extends Animal {
        private static int catCount = 0;
        private final int MAX_RUN = 200;
        private boolean isFull = false;

        public Cat(String name) {
            super(name);
            catCount++;
        }

        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN) {
                super.run(distance);
            } else {
                System.out.println(getName() + " не может пробежать больше " + MAX_RUN + " м.");
            }
        }

        @Override
        public void swim(int distance) {
            System.out.println(getName() + " не умеет плавать!");
        }

        public void eat(Bowl bowl, int amount) {
            if (bowl.decreaseFood(amount)) {
                isFull = true;
                System.out.println(getName() + " поел(а) и теперь сыт(а)!");
            }
        }

        public boolean isFull() {
            return isFull;
        }

        public static int getCatCount() {
            return catCount;
        }
    }

    // Класс Миска
    static class Bowl {
        private int foodAmount;

        public Bowl(int foodAmount) {
            this.foodAmount = foodAmount;
        }

        public void addFood(int amount) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " ед. еды. Теперь там: " + foodAmount);
        }

        public boolean decreaseFood(int amount) {
            if (foodAmount >= amount) {
                foodAmount -= amount;
                System.out.println("Из миски съели " + amount + " ед. еды. Осталось: " + foodAmount);
                return true;
            }
            System.out.println("В миске недостаточно еды! Требуется: " + amount + ", доступно: " + foodAmount);
            return false;
        }
    }
    //2 задание
    interface Shape {
        double getArea();
        double getPerimeter();
        String getFillColor();
        String getBorderColor();

        default String getInfo() {
            return String.format("Площадь: %.2f | Периметр: %.2f | Цвет: %s | Граница: %s",
                    getArea(), getPerimeter(), getFillColor(), getBorderColor());
        }
    }

    // Абстрактный класс для общих свойств
    static abstract class AbstractShape implements Shape {
        protected final String fillColor;
        protected final String borderColor;

        public AbstractShape(String fillColor, String borderColor) {
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Класс Круг
    static class Circle extends AbstractShape {
        private final double radius;

        public Circle(double radius, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    // Класс Прямоугольник
    static class Rectangle extends AbstractShape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
    }

    // Класс Треугольник
    static class Triangle extends AbstractShape {
        private final double sideA;
        private final double sideB;
        private final double sideC;

        public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double getArea() {
            double s = getPerimeter() / 2;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }

        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC;
        }
    }

    public static void main(String[] args) {
        // Создаем животных
        Dog bobik = new Dog("Бобик");
        Cat murzik = new Cat("Мурзик");
        Cat barsik = new Cat("Барсик");

        // Тестируем бег и плавание
        bobik.run(600);  // Превышение лимита
        bobik.swim(5);   // Успешное плавание
        murzik.run(150); // Успешный бег
        murzik.swim(1);  // Кот не умеет плавать

        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        // Работа с миской
        Bowl bowl = new Bowl(30);
        Cat[] cats = {murzik, barsik, new Cat("Васька")};

        System.out.println("\nКормление котов:");
        for (Cat cat : cats) {
            cat.eat(bowl, 15);  // Каждый кот пытается съесть 15 ед.
        }

        System.out.println("\nСостояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        // Добавляем еду и кормим снова
        System.out.println();
        bowl.addFood(20);
        barsik.eat(bowl, 15);
        System.out.println(barsik.getName() + ": " + (barsik.isFull() ? "сыт" : "голоден"));

        System.out.println("\n===== Геометрические фигуры =====");

        // Создаем фигуры
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Белый");
        Shape triangle = new Triangle(3, 4, 5, "Зеленый", "Желтый");

        // Выводим информацию о фигурах
        System.out.println("Круг: " + circle.getInfo());
        System.out.println("Прямоугольник: " + rectangle.getInfo());
        System.out.println("Треугольник: " + triangle.getInfo());
    }
}
