package ru.home.lesson1.correct;

public class Bicycle implements Transport {
    private final String model;
    private int speed;
    private boolean busy;

    public Bicycle(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public boolean isOnTheWay() {
        return busy;
    }

    @Override
    public void move() {
        busy = true;
    }

    @Override
    public void stop() {
        busy = false;
    }

}
