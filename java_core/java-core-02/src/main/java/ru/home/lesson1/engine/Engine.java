package ru.home.lesson1.engine;

public class Engine implements IEngine {
    private int power;
    private boolean active;

    @Override
    public void start() {
        active = true;
    }

    @Override
    public void stop() {
        active = false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public int getPower() {
        return power;
    }
}
