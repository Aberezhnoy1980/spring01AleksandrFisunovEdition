package ru.home.controlStatements;

public class ForEach2 {

    public static void main(String[] args) {
        int sum = 0;
        int[][] nums = new int[3][5];

        for (int i = 0; i < nums.length; i++) {
//            System.out.print(i + " ");
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (i + 1) * (j + 1);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.toString(nums));

        for (int[] x : nums) {
            for (int y : x) {
//                System.out.println("value is " + y);
                System.out.print("value is " + y + " | ");
                sum += y;
            }
            System.out.println();
        }
        System.out.println("sum is " + sum);
    }
}
