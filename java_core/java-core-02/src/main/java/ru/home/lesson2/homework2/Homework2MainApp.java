package ru.home.lesson2.homework2;

public class Homework2MainApp {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

//        try {
        System.out.println("Array conversation succeeded. Sum of elements: " + arrayDataConvertAndSum(arr));
//        } catch (MyArraySizeException | MyArrayDataException e) {
//            e.printStackTrace();
//        }
    }

    public static int arrayDataConvertAndSum(String[][] arr) {
        if (arr.length != 4) throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }

}
