package ru.home.controlStatements;

public class DoWhile {
    public static void main(String[] args) {
        int n = 10;

        do {
            System.out.println("tact " + n);
            n--;
        } while (n > 0);

        int m = 10;

        do {
            System.out.println("tact " + m);
        } while (--m > 0);
    }
}
