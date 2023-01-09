package ru.home.lesson2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Lesson2MainApp {
    // try catch finally throw throws
    public static void main(String[] args) {

        String data = "When we need to use Finally block";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("java-core-02/src/main/java/ru/home/lesson2/3.txt");
            out.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream out2 = new FileOutputStream("java-core-02/src/main/java/ru/home/lesson2/4.txt")) {
            out2.write("data.getBytes()".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7, -4, 5, 2, 3, 56};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                try {
                    throw new NegativeElementException(i, arr[i]);
                } catch (NegativeElementException e) {
                    e.printStackTrace();
                    arr[e.getIndex()] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

//        System.out.println(demo());

//        try {
//            doSomething();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            doSomethingValuable();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(sqrt(10));
//        throw new RuntimeException("1");

//        try {
//            d();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(1);
//            int[] arr = new int[100];
//            System.out.println(arr[10]);
//            a();
//            System.out.println(2);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch (RuntimeException exception) {
//            exception.printStackTrace();
//        }

//        int[] arr = new int[5];
//        System.out.println(arr[100]);
//
//        int z = Integer.parseInt("1i00");
//        System.out.println(z);
//
//        String str = null;
//        System.out.println(str.length());
//    }
    }

//    public static void a() {
//        b();
//    }
//
//    public static void b() {
//        c();
//    }
//
//    public static void c() {
//        int a = 10 / 0;
//    }

//    public static void d() {
//        try {
//            int a = 10 / 0;
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        System.out.println("End");

//        FileOutputStream out = null;
//        String data = "some data";
//        try {
//            out = new FileOutputStream("java-core-02/src/main/java/ru/home/lesson2/1.txt");
//            out.write(data.getBytes(StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//            if(out != null) {
//                try {
//                    out.close();
//                } catch (IOException ioexception) {
//                    ioexception.printStackTrace();
//                }
//            }
//        }

//    public static void doSomethingValuable() {
//        try {
//            int a = 10 / 0;
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException();
//        }
//    }
//    public static int sqrt(int n) {
//        if (n < 0) {
//            throw new IllegalArgumentException("Невозможно вычислить из отрицательного числа");
//        }
//        return n / 2;
//    }

//    public static void doSomething() throws IOException {
//        String data = "hello, Exception";
//        FileOutputStream out = new FileOutputStream("java-core-02/src/main/java/ru/home/lesson2/2.txt");
//        out.write(data.getBytes());
//        out.close();
//    }

//    public static int demo() {
//        try {
//            return 1;
//        } finally {
//            return 2;
//        }
//    }
}