package ru.home.java1;

public class HomeWork1 {
    public static void main(String[] args) {
        int intValue = 1;
        byte byteValue = 1;
        short shortValue = 2;
        long longValue = 2L;
        double doubleValue = 2.4d;
        float floatValue = 2.8f;
        boolean booleanValue = true;

        calculate(1, 2, 4, 2);
        System.out.println("check if (i + f) is between 10 to 20: " + isTheSumInTheRange(5, 6));
        isNegativeOrPositive(-4);
        System.out.println("check if the number is negative: " + isTheNumberNegative(3));
        halloName("Bob");

    }

    public static float calculate(float a, float b, float c, float d) {
        float res = a * (b + (c / d));
        System.out.println("calculate a * (b + (c / d): " + res);
        return res;
    }

    public static boolean isTheSumInTheRange(int i, int f) {
        int sum = i + f;
        return sum <= 20 && sum >= 10;
    }

    public static void isNegativeOrPositive(int j) {
        if (j >= 0) {
            System.out.println("check the number: positive or negative: " + j + " положительное число");
        }
        else System.out.println("check the number: positive or negative: " + j + " отрицательное число");
    }

    public static boolean isTheNumberNegative(int h) {
        return h < 0;
    }

    public static void halloName(String name) {
        System.out.println("Hallo, " + name);
    }

}
