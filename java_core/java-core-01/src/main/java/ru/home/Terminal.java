package ru.home;

import java.util.Scanner;

public class Terminal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your name? ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + "!");
        sc.close();
    }
}