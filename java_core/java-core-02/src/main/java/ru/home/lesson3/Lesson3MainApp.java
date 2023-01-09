package ru.home.lesson3;

import ru.home.lesson3.homework3.Homework3MainApp;

import java.util.*;

public class Lesson3MainApp {
    public static void main(String[] args) {
        System.out.println("List: lesson tips");
//        int [] arr = new int[5];
//        System.out.println(Arrays.toString(arr));
//        arr[0] = 10;
//        arr[4] = 20;
//        System.out.println(Arrays.toString(arr));
//
//        int[] temp = new int[arr.length * 2];
//        System.arraycopy(arr, 0, temp, 5, arr.length);
//        arr = temp;
//        System.out.println(Arrays.toString(arr));

        ArrayList<String> al = new ArrayList<>();
        System.out.println(al.size());
        for (int i = 0; i < 10; i++) {
            al.add("A");
        }
        al.add("A");
        al.add("B");
        al.add(0, "C");
        al.add(1, "D");
        al.add("E");
        al.add("G");
        al.add("G");
        al.add("G");
        al.add("G");
        al.add("G");
        al.add("G");
        System.out.println(al);
        al.remove("G");
        al.trimToSize();
        System.out.println(al + " " + al.size());

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(7);
        integerArrayList.add(6);
        integerArrayList.add(5);
        integerArrayList.add(4);
        integerArrayList.add(3);
        integerArrayList.add(2);
        System.out.println(integerArrayList);
        integerArrayList.remove(2);
        integerArrayList.remove((Integer) 2);
        System.out.println(integerArrayList);

        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("A", "A", "A", "B", "C"));
        while (stringArrayList.remove("A")) ;
        System.out.println(stringArrayList.contains("B") ? "true" : "false");
//        String b = !stringArrayList.contains("B") ? "false" : "true";
//        System.out.println(b);
        stringArrayList.addAll(2, new ArrayList<>(Arrays.asList("D", "E", "F")));
        stringArrayList.add(0, "A");
        stringArrayList.set(0, "1");
        System.out.println(stringArrayList);

        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("F");
        stringLinkedList.add("F");
        stringLinkedList.add("E");
        stringLinkedList.add("E");
        stringLinkedList.add("D");
        stringLinkedList.add("D");
        stringLinkedList.add("C");
        stringLinkedList.add("C");
        stringLinkedList.add("B");
        stringLinkedList.add("B");
        stringLinkedList.add("A");
        stringLinkedList.add("A");
        stringLinkedList.add(0, "G");
        stringLinkedList.add(3, "H");
        stringLinkedList.add(5, "I");
        stringLinkedList.add(7, "J");
        System.out.println(stringLinkedList.get(2) + " <- get method for index 2");
//        stringLinkedList.
        System.out.println(stringLinkedList + " <- keep the order and values of adding elements");
        TreeSet<String> stringTreeSet = new TreeSet<>(stringLinkedList);
        System.out.println(stringTreeSet + " <- reformat the list by removing duplicates and sorting in descending order using a TreeSet collection");

        System.out.println("\n\nHashMap: lesson tips");
        Map<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("Russia", "Moscow");
        stringHashMap.put("Germany", "Berlin");
        stringHashMap.put("France", "Paris");
        stringHashMap.put("Norway", "Oslo");
        System.out.println(stringHashMap.get("Norway") + " <- find by key \"Norway\"");
        stringHashMap.put("France", "Paris2");
        System.out.println(stringHashMap + " <- overwrite value when adding element with already existing key");
        System.out.println(stringHashMap.getOrDefault("Rusia", "Unknown") + " <- if the key is not found, the defined default value is used");

        Map<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put("F", "A");
        stringLinkedHashMap.put("E", "B");
        stringLinkedHashMap.put("D", "C");
        stringLinkedHashMap.put("C", "D");
        stringLinkedHashMap.put("B", "E");
        stringLinkedHashMap.put("A", "F");

        System.out.println(stringLinkedHashMap);
        Map<String, String> stringTreeMap = new TreeMap<>(stringLinkedHashMap);
        System.out.println(stringTreeMap);

        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("A");
        stringHashSet.add("A");
        stringHashSet.add("A");
        stringHashSet.add("B");
        stringHashSet.add("B");
        stringHashSet.add("B");
        stringHashSet.add("C");
        stringHashSet.add("C");
        stringHashSet.add("C");
        System.out.println((stringHashSet.contains("B") ? "true" : "false") + " <- return true if the collection contains a defined element");
        System.out.println(stringHashSet.size() + " <- returns the size of the collection, based on the calculation of unique records");

        Set<Box> treeSet = new TreeSet<>((box, anotherBox) -> box.size - anotherBox.size);
        treeSet.add(new Box(10));
        treeSet.add(new Box(1));
        treeSet.add(new Box(6));
        treeSet.add(new Box(4));

        System.out.println(treeSet + " <- provide the constructor with the the \"Comparator\" functional interface and overriding the \"compare\" method to sort Box instances in descending order of size");

        Set<AnotherBox> anotherTreeSet = new TreeSet<>();
        anotherTreeSet.add(new AnotherBox(10));
        anotherTreeSet.add(new AnotherBox(1));
        anotherTreeSet.add(new AnotherBox(6));
        anotherTreeSet.add(new AnotherBox(4));

        System.out.println(anotherTreeSet + " <- implements \"Comparable\" interface and overriding the \"compareTo\" method to sort \"Box\" instances in descending order of size in \"Box\" class");

        Set<String> stringTreeSet1 = new TreeSet<>((str, anotherStr) -> str.length() - anotherStr.length());
        stringTreeSet1.add("AAAAAAAAA");
        stringTreeSet1.add("BBBB");
        stringTreeSet1.add("DDD");
        stringTreeSet1.add("ZZZZZZ");
        System.out.println(stringTreeSet1 + " <- one more example compare using \"TreeSet\" constructor");

    }

    public static class AnotherBox implements Comparable<AnotherBox> {
        int size;

        public AnotherBox(int size) {
            this.size = size;
        }

        @Override
        public int compareTo(AnotherBox anotherBox) {
            return Integer.compare(this.size, anotherBox.size);
//                return this.size - box.size;
        }

        @Override
        public String toString() {
            return "anotherBox size: " + size;
        }
    }

    public static class Box {
        int size;

        public Box(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Box size: " + size;
        }
    }
}
