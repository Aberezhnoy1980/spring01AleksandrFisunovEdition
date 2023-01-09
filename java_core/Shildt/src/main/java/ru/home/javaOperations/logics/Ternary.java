package ru.home.javaOperations.logics;

public class Ternary {
    public static void main(String[] args) {

        showAbsoluteValue(-10);
    }

    static void showAbsoluteValue(int i) {
        int k = i < 0 ? -i : i;
        System.out.println("абсолютное значение " + i + " равно " + k);
    }
}
