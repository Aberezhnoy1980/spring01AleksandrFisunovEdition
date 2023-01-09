package ru.home.lesson1.correct;

public class LessonMainApp {
    public static void main(String[] args) {
        Car car = new Car("BMW", 100);
        Bicycle bicycle = new Bicycle("Star", 60);
        Moto moto = new Moto("Ducati", 300);
        Human human = new Human("Bob");

        human.ride(car);
        human.stop();

        human.ride(bicycle);
        human.stop();

        human.ride(moto);
        human.stop();
    }
}
