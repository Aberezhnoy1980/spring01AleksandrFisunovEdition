package ru.home.javaOperations.bitwise;

public class OpBitEquals {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        a |= 4; // 0001 | 0100 = 0101, or dec 5
        b >>= 1; // 0010 >> 1 = 0001, dec 1 (alt div)
        c <<= 1; // 0011 << 1 = 0110, or dec 6 (alt mul)
        a ^= c; // 0101 ^ 0110 = 0011, or dec 3

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
