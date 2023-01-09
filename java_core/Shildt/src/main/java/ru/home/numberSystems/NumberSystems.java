package ru.home.numberSystems;

import java.util.Arrays;

public class NumberSystems {
    public enum NumberType {
        INT, BYTE, SHORT, LONG, CHAR
    }

    public static void main(String[] args) {
        binToDec(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        decToBin(-134);
    }

    public static void decToBin(long decNumber) {
//    public static void decToBin(long decNumber, NumberType numberType) {
        int size = 0;
        String type = null;
//        switch (numberType) {
//            case BYTE:
//                size = 8;
//                break;
//            case SHORT:
//            case CHAR:
//                size = 16;
//                break;
//            case INT:
//                size = 32;
//                break;
//            case LONG:
//                size = 64;
//                break;
//        }

        if (decNumber < 128 & decNumber > -127) {
            size = 8;
            type = "byte";
        } else if (decNumber < 32_767 & decNumber > -32_768) {
            size = 16;
            type = "short";
        } else if (decNumber < 2_147_483_647 & decNumber > -2_147_483_648) {
            size = 32;
            type = "integer";
        } else {
//        (decNumber < 9_223_372_036_854_775_807 & decNumber > -9_223_372_036_854_775_808)
            size = 64;
            type = "long";
        }

        int[] powersOfTwo = new int[size];
        for (int i = 0; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = (int) Math.pow(2, i);
        }
//        System.out.println(Arrays.toString(powersOfTwo));
        int[] binNumber = new int[powersOfTwo.length];
        for (int i = powersOfTwo.length - 1; i >= 0; i--) {
            if (decNumber >= powersOfTwo[i]) {
                binNumber[binNumber.length - 1 - i] = 1;
                decNumber -= powersOfTwo[i];
            } else binNumber[binNumber.length - 1 - i] = 0;
        }
        System.out.println(Arrays.toString(binNumber) + "\n" + binNumber.length + "-bit value | type is: " + type);
    }

    public static void binToDec(int[] binNumber) {
        for (int i = 0; i < binNumber.length / 2; i++) {
            int tmp = binNumber[i];
            binNumber[i] = binNumber[binNumber.length - i - 1];
            binNumber[binNumber.length - i - 1] = tmp;
        }
        int decResult = 0;
        for (int i = 0; i < binNumber.length; i++) {
            if (binNumber[i] == 1)
                decResult += Math.pow(2, i);
        }
        System.out.println(decResult);
    }
}
