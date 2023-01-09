package ru.home.lesson4;

public class Cat implements Animal{
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public static Cat newCat(String name, int age, String color) {
        return new Cat(name, age, color);
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
        return "\nnew cat: " + name + "\nage: " + age + "\ncolor:  " + color;
    }
}
