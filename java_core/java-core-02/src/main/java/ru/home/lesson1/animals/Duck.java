package ru.home.lesson1.animals;

public class Duck extends Animal implements Swimable, Flyable {
    private final String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void toMakeASound() {
        System.out.println("уточка " + name + " кря кря");
    }

    @Override
    public void fly() {
        System.out.println(name + " полетел");
    }

    @Override
    public void swim() {
        System.out.println(name + " поплыл");
    }
}
