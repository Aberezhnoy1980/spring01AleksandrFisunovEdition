package ru.home.lesson3.homework3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phones;

    public PhoneBook() {
        this.phones = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (!phones.containsKey(name)) {
            phones.put(name, new HashSet<>());
        }
        phones.get(name).add(phone);
    }
}
