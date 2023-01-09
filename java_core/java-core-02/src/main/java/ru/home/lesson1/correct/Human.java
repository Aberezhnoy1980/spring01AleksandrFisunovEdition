package ru.home.lesson1.correct;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void ride(Transport transport) {
        if (!transport.isOnTheWay())
            transport.move();
        currentTransport = transport;
        System.out.println(name + " поехал на " + transport.getModel());
    }

    public void stop() {
        if (currentTransport != null) {
            currentTransport.stop();
            System.out.println(name + " остановил " + currentTransport.getModel() + "\n");
            currentTransport = null;
        }
    }
}
