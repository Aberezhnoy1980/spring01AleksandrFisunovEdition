package ru.home.lesson1.draft;

public class Cat {
    private String color;
    private int age;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", color, age);
    }

    public void meow() {
        System.out.println(color + " : meow");
    }
}
