package ru.home.javaOperations.bitwise;

public class MultByTwo {
    public static void main(String[] args) {
        int i, num = 0xFFFFFFE;
        int anotherNum = num;

        for (i = 0; i < 4; i++) {
            num <<= 1;
            System.out.println(num);
        }
        System.out.println(anotherNum);
        System.out.println(anotherNum << 4);
    }
}
