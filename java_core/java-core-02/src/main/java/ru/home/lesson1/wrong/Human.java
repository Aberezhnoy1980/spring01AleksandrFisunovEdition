package ru.home.lesson1.wrong;

public class Human {
    private final String name;
    private Car currentCar;
    private Bicycle currentBicycle;
    private Moto currentMoto;

    public Human(String name) {
        this.name = name;
    }

    public void startCar(Car car) {
        if (!car.isOnTheWay())
            car.move();
        currentCar = car;
        System.out.println(name + " поехал на машине " + car.getModel());
    }

    public void stopCar() {
        if (currentCar != null) {
            currentCar.stop();
            System.out.println(name + " остановил машину " + currentCar.getModel() + "\n");
            currentCar = null;
        }
    }

    public void rideBicycle(Bicycle bicycle) {
        if(!bicycle.isBusy()) {
            bicycle.ride();
            currentBicycle = bicycle;
            System.out.println(name + " поехал на велосипеде " + bicycle.getModel());
        }
    }

    public void stopBicycle() {
        if(currentBicycle != null) {
            currentBicycle.stop();
            System.out.println(name + " остановил велосипед " + currentBicycle.getModel() + "\n");
            currentBicycle = null;
        }
    }

    public void rideMoto(Moto moto) {
        if(!moto.isBusy()) {
            moto.ride();
            currentMoto = moto;
            System.out.println(name + " поехал на мотоцикле " + currentMoto.getModel());
        }
    }

    public void stopMoto() {
        if(currentMoto != null) {
            currentMoto.stop();
            System.out.println(name + " остановил мотоцикл " + currentMoto.getModel() + "\n");
            currentMoto = null;
        }
    }
}
