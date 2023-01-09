package ru.home.lesson3.homework3;

import java.util.*;

public class Homework3MainApp {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String[] words = {"Apple", "Apple", "Orange", "Pear", "Kiwi", "Mandarin",
                "Banana", "Pineapple", "Watermelon", "Grapefruit", "Apple",
                "Orange", "Pear", "Kiwi", "Mandarin", "Banana", "Pineapple",
                "Watermelon", "Lemon", "Lemon", "Lemon"};

        Map<String, Integer> uniqWords1 = new HashMap<>(words.length);
        for (String s : List.of(words))
            uniqWords1.put(s, uniqWords1.containsKey(s) ? uniqWords1.get(s) + 1 : 1);
        for(String s : uniqWords1.keySet())
            System.out.println(s + " : " + uniqWords1.get(s));


        Map<String, Integer> uniqWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = List.of(words).get(i);
            if (!uniqWords.containsKey(key)) {
                uniqWords.put(key, 1);
            } else uniqWords.put(key, uniqWords.get(key) + 1);
        }

        for (Map.Entry<String, Integer> entry : uniqWords.entrySet()) {
            System.out.println(entry.getKey() + " repeats: " + entry.getValue() + " times");
        }
//        System.out.print(uniqWords);
        System.out.println("\n" + uniqWordsCount(words));
//        uniqWordsCount(words);

        System.out.println("Task 2");
        PhoneBook.addRecord(98676698998L, "Peterson");
        PhoneBook.addRecord(91827987791L, "Peterson");
        PhoneBook.addRecord(98786876782L, "Nelson");
        PhoneBook.addRecord(94563456723L, "Madison");
        PhoneBook.addRecord(96725376564L, "Jackson");
        PhoneBook.addRecord(98656753655L, "Jackson");
        PhoneBook.addRecord(91235624526L, "Franklin");
        PhoneBook.addRecord(95464646217L, "Jefferson");
        PhoneBook.addRecord(93654776538L, "Jefferson");
        PhoneBook.addRecord(92146576629L, "Madison");
        PhoneBook.PrintPhoneBook();
        PhoneBook.getNumber("peterson");
    }

    public static Map<String, Integer> uniqWordsCount(String[] words) {
        Map<String, Integer> wordsCheck = new HashMap<>();
        for (String uniqWords : new HashSet<>(List.of(words))) {
            int counter = 0;
            for (String commonWords : words) {
                if (uniqWords.equals(commonWords)) {
                    counter++;
                    wordsCheck.put(commonWords, counter);
                }
            }
//            if (counter > 0) {
//                System.out.println("String \"" + uniqWords + "\" repeats " + counter + " times");
//            }
        }
        return wordsCheck;
    }

    public static class PhoneBook {
        private static HashMap<Long, String> phoneBook = new HashMap<>();

        public static void addRecord(Long phoneNumber, String name) {
            phoneBook.put(phoneNumber, name);
        }

        public static void PrintPhoneBook() {
            for (Map.Entry<Long, String> r : phoneBook.entrySet()) {
                System.out.println(r.getValue() + ": " + r.getKey());
            }
        }

        public static List<Long> getNumber(String name) {
            List<Long> result = new ArrayList<>();
            phoneBook.forEach((key, value) -> {
                if (name.equalsIgnoreCase(value)) {
                    result.add(key);
                    for (Long number : result) {
                        System.out.println(name + " phone number is: " + number);
                    }
                }
            });
            if (result.size() == 0) {
                System.out.println("record not exist");
            } return result;
        }
    }
}
