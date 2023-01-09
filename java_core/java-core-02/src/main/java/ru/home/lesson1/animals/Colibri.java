package ru.home.lesson1.animals;

public class Colibri extends Animal implements Flyable {
    private final String name;

    public Colibri(String name) {
        this.name = name;
    }

    @Override
    public void toMakeASound() {
        System.out.println("птичка " + name + " чирик чирик");
    }

    @Override
    public void fly() {
        System.out.println(name + " полетел");
    }
}
