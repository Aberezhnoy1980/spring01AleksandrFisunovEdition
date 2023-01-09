package ru.home.lesson1.wrong;

public class Moto {
    private final String model;
    private int speed;
    private boolean busy;

    public Moto(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public boolean isBusy() {
        return busy;
    }

    public void ride() {
        busy = true;
    }

    public void stop() {
        busy = false;
    }

}
