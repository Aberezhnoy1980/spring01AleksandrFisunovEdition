package ru.aberezhnoy;

import java.util.Scanner;

public class Homework1App {
    public static void main(String[] args) {

        System.out.println("Task 1: raising a number to a power");
//        raisingNumberToPower();
        raisingNumberToPower(2,4);

//        System.out.println("Task 2: exponentiation (using the evenness property of the degree");
//        raisingNumberToPowerUsingEvenness();
//
//        System.out.println("Task 3: get the sum of all numbers in series from 0 to 100");
//        System.out.println(getSumFrom0To100());

    }

//    private static void raisingNumberToPower() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("please, input a base number");
//        int base = sc.nextInt();
//        System.out.println("please, input a power");
//        int pow = sc.nextInt();
//        System.out.println("Result is: " + (int) Math.pow(base, pow));
//    }

    private static void raisingNumberToPower(int base, int pow) {
        int result = 1;
        if (pow > 0) {
            for (int i = pow; i > 0; i--) {
                result *= base;
            }
        }
        System.out.println("Result is: " + result);
    }

    private static void raisingNumberToPowerUsingEvenness() {
        int count = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("please, input a base number");
        int base = sc.nextInt();
        System.out.println("please, input a power");
        int pow = sc.nextInt();
        if (pow % 2 == 0) {
            pow /= 2;
            base *= base;
        } else {
            pow--;
            count *= base;
        }
        System.out.println("Result is: " + (int) Math.pow(base, pow) * count);
    }

    private static int getSumFrom0To100() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
