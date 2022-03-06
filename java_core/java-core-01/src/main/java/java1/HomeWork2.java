package java1;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {

        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        System.out.println("fill the array using method arguments: " + "\n" + Arrays.toString(fillArrayFromArgs(8, 1)));
        System.out.println();
        findMinAndMaxValue(5);
        System.out.println();
        checkTheBalance(5);
        System.out.println();
        System.out.println(chekTheBalanceTwo(new int[]{1, 2, 3, 2, 2, 2}));
        System.out.println();

        int[] array = {1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        }
        System.out.println("change array's value from 1 to 0 and from 0 to 1:" + "\n" + Arrays.toString(array));
        System.out.println();

        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println("fill the array with values from 1 to 100:" + "\n" + Arrays.toString(arr2));
        System.out.println();

        int[] arr5 = new int[8];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = i * 3;
        }
        System.out.println("fill the array with values from 0 to 21: " + "\n" + Arrays.toString(arr5));
        System.out.println();

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println("Double the array's value if it's less than 6:" + "\n" + Arrays.toString(arr3));
        System.out.println();

        int[][] arr4 = new int[3][3];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j) arr4[i][j] = 1;
                arr4[arr4[j].length - 1 - j][j] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        System.out.println("another way to change array's value from 1 to 0 and from 0 to 1:" + "\n" + Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        arr[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = i;
        }
        System.out.println("another way to fill the array with value from 1 to 100" + "\n" + Arrays.toString(arr));
    }

    public static int[] fillArrayFromArgs(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void findMinAndMaxValue(int len) {
        int[] arr = new int[len];
        int min = 100;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("fill the array and find max and min value:" + "\n" + "in array " + Arrays.toString(arr) + " min = " + min + ", " + "max = " + max);
    }

    public static void checkTheBalance(int len) {
        int[] arr = new int[len];
        int arraySum = 0;
        int sumLeftPart = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            arraySum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            sumLeftPart += arr[i];

            if (sumLeftPart * 2 == arraySum) {
                System.out.println("there is a balance in this array: " + Arrays.toString(arr));
            }
        }
        System.out.println("there is no balance in this array: " + Arrays.toString(arr));
    }

    public static boolean chekTheBalanceTwo(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int leftPart = 0;
        for (int i = 0; i < arr.length; i++) {
            leftPart = leftPart + arr[i];
            if (leftPart * 2 == sum) {
                return true;
            }
            else if (leftPart * 2 > sum) {
                return false;
            }
        }
        return false;
    }
}