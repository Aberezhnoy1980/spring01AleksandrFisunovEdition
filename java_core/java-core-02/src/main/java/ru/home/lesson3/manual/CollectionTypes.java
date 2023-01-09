package ru.home.lesson3.manual;

import java.util.*;

public class CollectionTypes {
    public static void main(String[] args) {
        System.out.println("ArrayList basic operations");
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add(1, "A0");
        System.out.println(arrayList);
        arrayList.remove("E");
        arrayList.remove(2);
        System.out.println(arrayList);

        System.out.println("\nConvert a ArrayList collection to a simple array");
        String[] arr = new ArrayList<>(Arrays.asList("1", "2", "3")).toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

        System.out.println("\nLinkedList basic operations");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("C");
        linkedList.addLast("Z");
        linkedList.addFirst("A");
        linkedList.add(1, "A2");
        System.out.println("1. linkedList: " + linkedList);
        linkedList.remove("F");
        linkedList.remove(2);
        System.out.println("2. linkedList: " + linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("3. linkedList: " + linkedList);
        String val = linkedList.get(2);
        linkedList.set(2, val + " changed");
        System.out.println("4. linkedList: " + linkedList);

        System.out.println("\nHashMap basic operations");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Russia", "Moscow");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");
//        System.out.println(hm);
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        hm.put("Germany", "Berlin2");
        System.out.println("New Germany Entry: " + hm.get("Germany"));

        System.out.println("\nSet basic operations");
        Set<String> set = new HashSet<>();
        set.add("Alfa");
        set.add("Beta");
        set.add("Alfa");
        set.add("Ata");
        set.add("Gamma");
        set.add("Epsilon");
        set.add("Omega");
        set.add("Gamma");
        System.out.println(set);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Beta");
        linkedHashSet.add("Alfa");
        linkedHashSet.add("Ata");
        linkedHashSet.add("Gamma");
        linkedHashSet.add("Epsilon");
        linkedHashSet.add("Omega");
        System.out.println(linkedHashSet);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("D");
        System.out.println(treeSet);

        System.out.println("\nIterators");
        List<String> stringList = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A", "B", "C", "B"));
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("A")) {
                iterator.remove();
            }
        }
        System.out.println(stringList);

        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A", "B", "C", "B"));
        ListIterator<String> listIterator = stringArrayList.listIterator();
        while (listIterator.hasNext()) {
            String s = listIterator.next();
//            if (s.equals("A")) {
//                listIterator.remove();
//            }
            listIterator.set("X");
        }
        listIterator.add("newA");
        System.out.println(stringArrayList);

        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("Barsic", 5),
                new Cat("Mursik", 3),
                new Cat("Pushok", 1)
        ));
        System.out.println(cats);
        Collections.sort(cats);
        System.out.println(cats);
    }
}




