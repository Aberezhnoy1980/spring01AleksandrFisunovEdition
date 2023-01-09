package ru.home.other;

import java.util.Scanner;

class CharEncStand {
    public static void main(String[] args) {
//        sayHello();
        asciiDecode();
    }

    public static void asciiDecode() {
        char ch;
        for (int i = 1; i < 128; i++) {
            ch = (char) i;
            System.out.println("character '" + ch + "' | dec is " + i + " | bin is " + Integer.toString(ch, 2));
        }
    }

    public static void sayHello() {
        System.out.print("What's your name? ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Hello " + name + "!!!");
    }
}
