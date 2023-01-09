package ru.home.lesson1.draft;

import java.util.Arrays;

public class DraftMainApp {
    public static void main(String[] args) {
        Cat cat = new Cat("White", 2);
        System.out.println(cat);
        modifyByReference(cat);
        System.out.println(cat);

        int z = 0;
        System.out.println(z);
        modifyPrimitive(z);
        System.out.println(z);

        Cat[] cats = {
                new Cat("White", 2),
                new Cat("Black", 3),
                new Cat("Purple", 1)
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].meow();
        }

        for (Cat c : cats) {
            c.meow();
        }

        System.out.println(Arrays.stream(cats).count());
        System.out.println(Arrays.stream(cats).findAny());
        System.out.println(Arrays.toString(cats));
    }

    public static void modifyByReference(Cat argCat) {
        argCat.setColor("Purple");
    }

    public static void modifyPrimitive(int n) {
        n += 10;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }


}
