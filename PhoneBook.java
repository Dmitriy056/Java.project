import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "Иванов", "111-111-111");
        addContact(phoneBook, "Петров", "222-222-222");
        addContact(phoneBook, "Сидоров", "333-333-333");
        addContact(phoneBook, "Иванов", "444-444-444");
        addContact(phoneBook, "Петров", "555-555-555");

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод контактов
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }
}
