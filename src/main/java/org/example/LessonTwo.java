package org.example;

// 1.
public class LessonTwo {
    // Поля класса
    private final String name;
    private final String productionDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final double price;
    private final boolean isReserved;

    // Конструктор класса
    public LessonTwo(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации о товаре
    public void displayInfo() {
        System.out.println();
        System.out.println("Информация о товаре:");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " ₽");
        System.out.println("Статус бронирования: " + (isReserved ? "Забронирован" : "Доступен"));
        System.out.println();
    }
    // 2.
    public static void main(String[] args) {
        LessonTwo [] productsArray = new LessonTwo [5];

        productsArray[0] = new LessonTwo ("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new LessonTwo ("iPhone 16 Pro", "15.03.2025",
                "Apple Inc.", "USA", 6499, false);
        productsArray[2] = new LessonTwo ("Xiaomi Mi 15", "10.01.2025",
                "Xiaomi Corporation", "China", 3999, true);
        productsArray[3] = new LessonTwo ("OnePlus 12T", "05.04.2025",
                "OnePlus Technology", "China", 4599, false);
        productsArray[4] = new LessonTwo ("Google Pixel 9", "20.03.2025",
                "Google LLC", "USA", 5299, true);

        for (LessonTwo  product : productsArray) {
            product.displayInfo();
        }
    }
}
    // 3.
    class Park {
    private final String parkName;
    private final Attraction[] attractions;

    // Внутренний класс для хранения информации об аттракционах
    public class Attraction {
        private final String name;
        private final String workingHours;
        private final double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("-----------------------------");
        }
    }
    // Конструктор парка
    public Park(String parkName, Attraction[] attractions) {
        this.parkName = parkName;
        this.attractions = attractions;
    }

    // Метод для вывода информации о парке и его аттракционах
    public void displayParkInfo() {
        System.out.println("Парк: " + parkName);
        System.out.println("Список аттракционов:");
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
        }
    }
}