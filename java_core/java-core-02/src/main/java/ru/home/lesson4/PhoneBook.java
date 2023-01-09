package ru.home.lesson4;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<Integer>> phones;

    public PhoneBook() {
        this.phones = new HashMap<>();
    }

    public void add(String name, Integer phone) {
        if (!phones.containsKey(name)) {
            phones.put(name, new HashSet<>());
        }
        phones.get(name).add(phone);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Bob", 1);
        phoneBook.add("Jack", 2);
        phoneBook.add("Bob", 1);
        phoneBook.add("Bob", 2);
        phoneBook.add("Steve", 2345);

        for (Map.Entry<String, Set<Integer>> entry : phoneBook.phones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
