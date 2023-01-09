package ru.aberezhnoy.homework02;

public class ListApp {
    public static void main(String[] args) {
        MyList<String> arr = new MyArrayList<>();
        //MyArrayList <String> arr = new MyArrayList<>();
        System.out.println(arr.isEmpty());
        System.out.println("Утверждение 'Список содержит букву А' = " + arr.contains("A"));
        arr.add("A");//0--
        arr.add("B");//1    0
        arr.add("C");//2 --
        arr.add("D");//3    1
        arr.add("E");//4    2
        arr.add("F");//5    3
        arr.add("G");//6    4
        arr.add("H");//7   5
        arr.add("I");//8  6
        arr.add("J");//9  7
        arr.add("K");//10  8
        arr.add("L");//11  9
        arr.add("M");//12--
        arr.delete(2);
        arr.deleteFirst();
        arr.deleteLast();
        arr.set(0, "X");
        System.out.println(arr.size());
        // System.out.println(arr.capacity());
        System.out.println(arr.get(5));
        //System.out.println(arr.get(10));
        System.out.println(arr.isEmpty());
        System.out.println(arr);
        System.out.println("Утверждение 'список содержит букву K' = " + arr.contains("K"));
        System.out.println("Утверждение 'список содержит букву O' = " + arr.contains("O"));
        System.out.println("*********************************************");


        MyList<String> linkedArr = new MyLinkedList<>();
        System.out.println(linkedArr.isEmpty());
        linkedArr.add("A");//0  0
        linkedArr.add("B");//1  1
        linkedArr.add("C");//2  2
        linkedArr.add("D");//3  --
        linkedArr.add("E");//4  3
        linkedArr.add("F");//5  4
        linkedArr.add("G");//6  5
        linkedArr.add("H");//7  6
        System.out.println(linkedArr.size());
        linkedArr.delete(3);
        linkedArr.set(0, "Y");
        System.out.println(linkedArr.size());
        System.out.println(linkedArr.isEmpty());
        System.out.println(linkedArr.get(3));
        System.out.println(linkedArr.get(6));
        //System.out.println(linkedArr.get(7));
        System.out.println(linkedArr);
        System.out.println("Утверждение 'список содержит букву B' = " + linkedArr.contains("B"));
        System.out.println("Утверждение 'список содержит букву K' = " + linkedArr.contains("K"));

    }
}
