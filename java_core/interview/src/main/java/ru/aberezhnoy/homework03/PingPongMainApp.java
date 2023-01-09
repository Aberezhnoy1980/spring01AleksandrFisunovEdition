package ru.aberezhnoy.homework03;

import java.util.Objects;

public class PingPongMainApp {

    private final Object monitor = new Object();
    private String currentVariant = "Ping";

    public static void main(String[] args) {
        PingPongMainApp pingPongMainApp = new PingPongMainApp();
        for (int i = 0; i < 10; i++) {
            new Thread(pingPongMainApp::ping)
                    .start();
            new Thread(pingPongMainApp::pong)
                    .start();
        }
    }

    public void ping() {
        synchronized (monitor) {
            try {
                while (!Objects.equals(currentVariant, "Ping")) {
                    monitor.wait();
                }
                System.out.println("Ping");
                currentVariant = "Pong";
                monitor.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pong() {
        synchronized (monitor) {
            try {
                while (!Objects.equals(currentVariant, "Pong")) {
                    monitor.wait();
                }
                System.out.println("Pong");
                currentVariant = "Ping";
                monitor.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
