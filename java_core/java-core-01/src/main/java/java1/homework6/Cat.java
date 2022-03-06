package java1.homework6;

public class Cat extends Animal {
    static int catsCount = 0;

    public Cat(String type, String name, String color, int age, int maxRunDistance, int maxSwimDistance) {
        super(type, name, color, age, maxRunDistance, maxSwimDistance);
        catsCount++;
    }

    public int getCatsCount() {
        return catsCount;
    }
}
