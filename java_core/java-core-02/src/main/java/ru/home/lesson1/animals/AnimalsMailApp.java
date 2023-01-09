package ru.home.lesson1.animals;

public class AnimalsMailApp {
    public static void main(String[] args) {
        Swimable[] swimables = {
                new Dog("Rex"),
                new Duck("Bob")
        };
        for (Swimable s : swimables) {
            s.swim();
        }
        Animal[] animals = {
                new Dog("Mukhtar"),
                new Colibri("Ptica"),
                new Duck("Donald")
        };

        for (Animal a : animals) {
            a.toMakeASound();
        }
    }
}
