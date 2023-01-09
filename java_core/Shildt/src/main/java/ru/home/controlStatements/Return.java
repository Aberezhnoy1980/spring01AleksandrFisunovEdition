package ru.home.controlStatements;

public class Return {
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("before return.");

        if (t) return;

        System.out.println("this operator will not be executed.");
    }
}
