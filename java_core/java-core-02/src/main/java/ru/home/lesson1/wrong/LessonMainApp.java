package ru.home.lesson1.wrong;

public class LessonMainApp {
    public static void main(String[] args) {
        Car car = new Car("BMW", 60);
        Bicycle bicycle = new Bicycle("Star", 60);
        Moto moto = new Moto("Ducati", 300);
        Human human = new Human("Bob");

        human.startCar(car);
        human.stopCar();

        human.rideBicycle(bicycle);
        human.stopBicycle();

        human.rideMoto(moto);
        human.stopMoto();
    }
}
