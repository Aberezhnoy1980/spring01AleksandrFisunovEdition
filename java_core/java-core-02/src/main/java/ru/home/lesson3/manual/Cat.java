package ru.home.lesson3.manual;

public class Cat implements Comparable<Cat> {
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
     public int compareTo(Cat o) {
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }
        return 0;
//        return this.age - o.age;
//        return Integer.compare(this.age, anotherCat.age);
    }



    public String toString() {
        return name;
    }
}
