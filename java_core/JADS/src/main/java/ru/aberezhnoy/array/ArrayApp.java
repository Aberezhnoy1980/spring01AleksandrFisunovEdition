package ru.aberezhnoy.array;

public class ArrayApp {
    public static void main(String[] args) {
        ArrayOps intArr = MyArray
                .createArrayBuilder()
                .setIntArray(10)
                .setArraySize(10)
                .build();

        intArr.insertInUnsortedArray(5);
        intArr.insertInUnsortedArray(4);
        intArr.insertInUnsortedArray(7);
        intArr.insertInUnsortedArray(1);
        intArr.insertInUnsortedArray(9);
        intArr.insertInUnsortedArray(8);
        intArr.insertInUnsortedArray(2);
        intArr.insertInUnsortedArray(6);
        intArr.insertInUnsortedArray(3);
        intArr.insertInUnsortedArray(3);

        intArr.display();

//        intArr.sortBubble();

//        intArr.sortSelect();

        intArr.sortInsert();

        intArr.display();

        intArr.delete(2);

        intArr.display();

        intArr.arrayLengthCut(1);

        intArr.display();

        int search = 12;
        if (intArr.lineFind(search)) {
            intArr.delete(search);
            System.out.println("Element  " + search + " removed. New array:");
            intArr.display();
        } else System.out.println("Element not found");

        System.out.println(intArr.BinaryFindInSortedArray(4));

        intArr.insertInSortedArray(2);

        intArr.display();

    }
}
