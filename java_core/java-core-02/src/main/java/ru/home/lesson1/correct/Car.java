package ru.home.lesson1.correct;

public class Car implements Transport {
    private final String model;
    private int speed;
    private boolean onTheWay;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public boolean isOnTheWay() {
        return onTheWay;
    }


    @Override
    public void move() {
        onTheWay = true;
    }

    @Override
    public void stop() {
        onTheWay = false;
    }

}
