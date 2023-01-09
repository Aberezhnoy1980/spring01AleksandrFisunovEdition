package ru.home.lesson4;

import java.util.Arrays;
import java.util.function.Predicate;

public class AnimalsApp {
    public static void main(String[] args) {

        var predicat = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        };
        System.out.println(predicat.getClass().getName());

        Animal animal = new Animal() {
            @Override
            public void sound(String name, String sound) {
                Animal.super.sound(name, sound);
            }
        };
        System.out.println(animal.getClass().getName());

//        Cat[] cats = new Cat[3];
//        cats[0] = Cat.newCat("Bars", 3, "black");
//        cats[1] = Cat.newCat("Mursic", 2, "white");
//        cats[2] = Cat.newCat("Tiger", 4, "red");
//
//        cats[1].sound("Mursic", "meow");
//        System.out.println(Arrays.toString(cats));
//
//        Dog[] dogs = {
//                Dog.newDog("Tuzik", 6, "red"),
//                Dog.newDog("Rex", 7, "black"),
//                Dog.newDog("Bobik", 12, "white"),
//                Dog.newDog("Tarzan", 124, "green")
//        };
//
//        dogs[3].sound(dogs[3].getName(), "bark");
//        System.out.println(Arrays.toString(dogs));
//        System.out.println(dogs[1] + " eat " + cats[2]);
    }
}
