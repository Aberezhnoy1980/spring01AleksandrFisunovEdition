package ru.home.lesson4;

public class Dog implements Animal {
    private final String name;
    private final int age;
    private final String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public static Dog newDog(String name, int age, String color) {
        return new Dog(name, age, color);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\nnew dog: " + name + "\nage: " + age + "\ncolor:  " + color;
    }
}
