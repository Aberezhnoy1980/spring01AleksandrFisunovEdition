package ru.home.controlStatements;

public class ContinueLabel {
    public static void main(String[] args) {
        outer:
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 1 && i == 1) System.out.print(j + "|");
                if (j > i) {
                    System.out.println();
                    System.out.print(j + "|");
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
        System.out.println("\n   -------------------------\n   1  2  3  4  5  6  7  8  9");
    }
}
