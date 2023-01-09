package ru.home.controlStatements;

public class BreakLoop {
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 100; i++) {
            if (i == 10) break;
            System.out.println("i is " + i);
        }
        System.out.println("cycle complete on iteration " + i);

        i = 0;
        while (i < 100) {
            if (i == 13) break;
            System.out.println("i is " + i);
            i++;
        }
        System.out.println("cucle complete on iteration " + i);

        for (i = 0; i < 3; i++) {
            System.out.print("pass " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10) break;
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("cycles complete");
    }
}
