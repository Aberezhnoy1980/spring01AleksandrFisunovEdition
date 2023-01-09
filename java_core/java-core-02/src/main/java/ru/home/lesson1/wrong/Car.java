package ru.home.lesson1.wrong;

public class Car {
    private final String model;
    private int speed;
    private boolean onTheWay;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public boolean isOnTheWay() {
        return onTheWay;
    }

    public void move() {
        onTheWay = true;
    }

    public void stop() {
        onTheWay = false;
    }

}
