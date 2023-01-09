package ru.home.lesson4;

import java.util.*;
import java.util.function.Predicate;

public class MainApp {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("B");
        set.add("C");

        for (String s : set) {
//            System.out.println(s);
        }

        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");

        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        List<String> list = new ArrayList<>(Arrays.asList("B", "D", "A", "C"));
        for (String s : list) {
//            System.out.println(s);
        }

        Set<String> stringSet = new HashSet<>(Arrays.asList("B", "D", "A", "C"));
        for (String s : stringSet) {
//            System.out.println(s);
        }
        //        while (setIterator.hasNext()) {
//            String s = setIterator.next();
//            if (s.equals("B")) {
//                setIterator.remove();
//            }
//        }
        set.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });

        Map<String, String> phones = new HashMap<>();
        phones.put("Bob", "1");
        phones.put("Jack", "2");
        phones.put("Bob", "3");

        for (Map.Entry<String, String> e : phones.entrySet()) {
//            System.out.println(e.getKey() + " : " + e.getValue());
        }

        List<String> list1 = new ArrayList<>(Arrays.asList("A", "A", "B", "B", "A"));
        for (var i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals("A")) {
                list1.remove(i);
            }
        }
        Collections.sort(list1, Comparator.reverseOrder());
        System.out.println(list1.size());

        List<String> list2 = new ArrayList<>(Arrays.asList("A", "A", "B", "B", "A"));
        for (var i = list2.size() - 1; i >= 0; i--) {
            if (list2.get(i).equals("A")) {
                list2.remove(i);
            }
        }
        System.out.println(list2.size());

//        List<String> list3 = new ArrayList<>(Arrays.asList("A", "A", "B", "B", "A"));
//        for (String s : list3) {
//            if (s.equals("A")) list3.remove(s);
//        }
//        System.out.println(list3.size()); // Exception

        List<String> list4 = new ArrayList<>(Arrays.asList("A", "A", "B", "B", "A"));
        Iterator<String> iterator = list4.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals(("A"))) {
                iterator.remove();
            }
        }
        System.out.println(list4.size());

    }
}
