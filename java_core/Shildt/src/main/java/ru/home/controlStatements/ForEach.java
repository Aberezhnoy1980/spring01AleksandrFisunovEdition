package ru.home.controlStatements;

public class ForEach {

    public static void main(String[] args) {

        int sum = 0;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int x : nums) {
            System.out.println("value is " + x);
            sum += x;
        }
        System.out.println("sum is " + sum);

        sum = 0;

        for (int x : nums) {
            System.out.println("value is " + x);
            sum += x;
            if (x == 5) break;
        }
        System.out.println("sum of first five elements is " + sum);
    }
}
