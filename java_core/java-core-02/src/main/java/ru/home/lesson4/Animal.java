package ru.home.lesson4;

public interface Animal {

    default void sound(String name, String sound) {
        System.out.println(name + " make a " + sound);
    }
}

