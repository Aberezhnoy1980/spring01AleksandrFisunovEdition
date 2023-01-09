package ru.home.controlStatements;

public class While {
    public static void main(String[] args) {
        int n = 10;
        while (n > 0) {
            System.out.println("tact " + n);
            n--;
        }
    }

    static class NoBody {
        public static void main(String[] args) {
            int i, j;
            i = 100;
            j = 200;

            // calculate average value for i & j
            while(++i < --j) ;
            System.out.println("Average is " + i);
        }
    }
}
