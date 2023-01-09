package ru.home.homework6;

public class Animal {
    static int animalsCount = 0; // для класса родителя лучше модификатор доступа не ставить строгим
    String type;
    String name;
    String color;
    int age;
    int maxRunDistance;
    int maxSwimDistance;

    public Animal(String type, String name, String color, int age, int maxRunDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalsCount++;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        this.age = age;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void run(int runDistance) {
        if (runDistance < maxRunDistance) {
            System.out.println(type + " ran the distance " + runDistance);
        } else {
            System.out.println("disqualification");
        }
    }

    public void swim(int swimDistance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " can't swim");
            return;
        }
        if (swimDistance < maxSwimDistance) {
            System.out.println(type + " swam the distance " + swimDistance);
        } else {
            System.out.println("disqualification");
        }
    }

    @Override
    public String toString() {
        return ("name-" + name + ", " + "color-" + color + ", " + "Age-" + age + ", " + "Run-" + maxRunDistance + ", " + "Swim-" + maxSwimDistance + "\n");
    }
}
