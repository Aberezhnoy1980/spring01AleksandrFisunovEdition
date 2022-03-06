package java1.homework6;

public class Dog extends Animal {
    static int dogsCount = 0;

    public Dog(String type, String name, String color, int age, int maxRunDistance, int maxSwimDistance) {
        super(type, name, color, age, maxRunDistance, maxSwimDistance);
        dogsCount++;
    }

    public int getDogsCount() {
        return dogsCount;
    }
}
