package ru.home.lesson4;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AndroidPhoneBook {
    class Entry {
        private String name;
        private Set<String> phones;

        public Entry(String name) {
            this.name = name;
            this.phones = new HashSet<String>();
        }

        public String getName() {
            return name;
        }
    }

    private List<Entry> entries;

    public Set<String> findByName(String name) {
        for (Entry entry : entries) {
            if (entry.getName().equals(name)) {
                return entry.phones;
            }
        }
        return Collections.emptySet();
    }
}







