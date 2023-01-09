package ru.home.lesson1.animals;

public class Dog extends Animal implements Swimable {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void toMakeASound() {
        System.out.println("собачка " + name + " гав гав");
    }

    @Override
    public void swim() {
        System.out.println(name + " поплыл");
    }
}
