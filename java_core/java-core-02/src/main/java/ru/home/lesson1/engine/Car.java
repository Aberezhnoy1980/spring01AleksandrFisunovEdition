package ru.home.lesson1.engine;

public class Car {
    private IEngine engine;

    public Car(IEngine engine) {
        this.engine = engine;
    }
    public void move() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }
}
