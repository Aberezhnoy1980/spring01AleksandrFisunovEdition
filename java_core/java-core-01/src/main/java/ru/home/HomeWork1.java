package ru.home;

public class HomeWork1 {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        t1.start();
        t2.start();

//        int[] a = new int[10];
//        a[20] = 10;
//        a[5] = a[2] / 0;
//        try {
//            return;
//        } finally {
//            System.out.println("Finally");
//        }
//
//    }
//        int intValue = 1;
//        byte byteValue = 1;
//        short shortValue = 2;
//        long longValue = 2L;
//        double doubleValue = 2.4d;
//        float floatValue = 2.8f;
//        boolean booleanValue = true;
//
//        calculate(1, 2, 4, 2);
//        System.out.println("check if (i + f) is between 10 to 20: " + isTheSumInTheRange(5, 6));
//        isNegativeOrPositive(-4);
//        System.out.println("check if the number is negative: " + isTheNumberNegative(3));
//        halloName("Bob");
//
//    }
//
//    public static float calculate(float a, float b, float c, float d) {
//        float res = a * (b + (c / d));
//        System.out.println("calculate a * (b + (c / d): " + res);
//        return res;
//    }
//
//    public static boolean isTheSumInTheRange(int i, int f) {
//        int sum = i + f;
//        return sum <= 20 && sum >= 10;
//    }
//
//    public static void isNegativeOrPositive(int j) {
//        if (j >= 0) {
//            System.out.println("check the number: positive or negative: " + j + " положительное число");
//        }
//        else System.out.println("check the number: positive or negative: " + j + " отрицательное число");
//    }
//
//    public static boolean isTheNumberNegative(int h) {
//        return h < 0;
//    }
//
//    public static void halloName(String name) {
//        System.out.println("Hello, " + name);
//    }

    }
//        public void someMethod () {
//            System.out.println("some");
//        };
//
//        notExist.someMethod();

}
