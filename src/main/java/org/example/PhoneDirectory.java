package org.example;
import java.util.*;

public class PhoneDirectory {
    private final Map<String, List<String>> directory = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        // Если фамилии нет в справочнике - создаем новую запись
        directory.putIfAbsent(surname, new ArrayList<>());

        // Добавляем номер к существующей фамилии
        directory.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        // Возвращаем номера или пустой список, если фамилии нет
        return directory.getOrDefault(surname, Collections.emptyList());
    }
}
