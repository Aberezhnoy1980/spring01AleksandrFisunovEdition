package ru.home.controlStatements;

public class BreakGoToLabel {
    public static void main(String[] args) {
        boolean t = true;

        first:
        {
            second:
            {
                third:
                {
                    System.out.println("precedes the break.");
                    if (t) break second;
                    System.out.println("this operator will not be executed.");
                }
                System.out.println("this operator will not be executed.");
            }
            System.out.println("this operator will follows the second.");
        }

        outer:
        for (int i = 0; i < 3; i++) {
            System.out.print("pass " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10) break outer;
                System.out.print(j + " ");
            }
            System.out.println("this line will not be shown");
        }
        System.out.println("cycle complete");

        one:
        for (int i = 0; i < 3; i++) {
            System.out.print("pass " + i + ": ");
        }
        for (int j = 0; j < 100; j++) {
//            if (j == 10) break one; error
            System.out.print(j + " ");
        }
    }
}
