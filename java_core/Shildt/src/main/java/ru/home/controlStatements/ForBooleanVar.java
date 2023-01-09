package ru.home.controlStatements;

public class ForBooleanVar {
    public static void main(String[] args) {

        int i;
        boolean done = false;

        for (i = 1; !done; i++) {
            System.out.println(i);
            if (java.lang.Thread.interrupted() || i == 5) done = true;
        }

        done = false;
        i = 0;

        for ( ; !done; ) {
            System.out.println("i = " + i);
            if (java.lang.Thread.interrupted() || i == 5) done = true;
            i++;
        }
    }
}
