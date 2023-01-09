package ru.home.lesson5.homework5;

import java.util.Arrays;

public class ArraysCalcRaceApp {
    public static void main(String[] args) throws InterruptedException {

        arrayCreate(10);

        arrayInThreadCreate(10);
    }

    public static void arrayCreate(int size) {
        float[] array = new float[size];
        Arrays.fill(array, 1);

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread of array calculation timer: " + (System.currentTimeMillis() - start) + " ms\n");
        System.out.println(Arrays.toString(array) + "\n");
    }

    public static void arrayInThreadCreate(int size) throws InterruptedException {
        float[] arraySrc = new float[size];
        float[] arrayDst = new float[size];
        float[] arrayLeft = new float[arraySrc.length / 2];
        float[] arrayRight = new float[arraySrc.length / 2];
        Arrays.fill(arraySrc, 1);
        // splitting timer
        long splitStart = System.currentTimeMillis();
        System.arraycopy(arraySrc, 0, arrayLeft, 0, arraySrc.length / 2);
        System.arraycopy(arraySrc, arraySrc.length / 2, arrayRight, 0, arraySrc.length / 2);
        System.out.println("splitting timer: " + (System.currentTimeMillis() - splitStart) + " ms");
// check
//        System.out.println(Arrays.toString(arraySrc));
//        System.out.println(Arrays.toString(arrayLeft));
//        System.out.println(Arrays.toString(arrayRight));
//        System.out.println(Arrays.toString(arrayDst));

        // first thread of array calculation timer
        long firstThreadCalcStart = System.currentTimeMillis();
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < arrayLeft.length; i++) {
                arrayLeft[i] = (float) (arrayLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("first thread of array calculation timer: " + (System.currentTimeMillis() - firstThreadCalcStart) + " ms");
        });
        firstThread.start();
        firstThread.join();
        // second thread of array calculation timer
        long secondThreadCalcStart = System.currentTimeMillis();
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < arrayLeft.length; i++) {
                arrayRight[i] = (float) (arrayRight[i] * Math.sin(0.2f + (size / 2 + i)  / 5) * Math.cos(0.2f + (size / 2 + i) / 5) * Math.cos(0.4f + (size / 2 + i) / 2));
            }
            System.out.println("second thread of array calculation timer: " + (System.currentTimeMillis() - secondThreadCalcStart) + " ms");
        });
        secondThread.start();
        secondThread.join();

        // gluing timer
        long gluingStart = System.currentTimeMillis();
        System.arraycopy(arrayLeft, 0, arrayDst, 0, arrayLeft.length);
        System.arraycopy(arrayRight, 0, arrayDst, arrayDst.length / 2, arrayRight.length);
        System.out.println("gluing timer: " + (System.currentTimeMillis() - gluingStart) + " ms");
        System.out.println("Total timer: " + (System.currentTimeMillis() - splitStart) + " ms");
// check
        System.out.println(Arrays.toString(arraySrc));
        System.out.println(Arrays.toString(arrayLeft));
        System.out.println(Arrays.toString(arrayRight));
        System.out.println(Arrays.toString(arrayDst));
    }
}








