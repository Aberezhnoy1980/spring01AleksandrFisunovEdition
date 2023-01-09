package ru.home.controlStatements;

public class ForCommaUsage {
    public static void main(String[] args) {

        // Sample
        int a, b;

        b = 4;

        for (a = 1;  a < b; a++) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            b--;
        }

        int c, d;

        for (c = 1, d = 4; c < d; c++, d--) {
            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }
    }
}
