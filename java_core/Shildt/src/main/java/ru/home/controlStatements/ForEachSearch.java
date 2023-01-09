package ru.home.controlStatements;

public class ForEachSearch {
    public static void main(String[] args) {

        int[] nums = {6, 8, 3, 7, 5, 6, 1, 4};
        int val = 5;
        boolean isFound = false;

        for (int x : nums) {
            if (x == val) {
                isFound = true;
                break;
            }
        }
        if (isFound) System.out.println("value is founded");
    }
}
