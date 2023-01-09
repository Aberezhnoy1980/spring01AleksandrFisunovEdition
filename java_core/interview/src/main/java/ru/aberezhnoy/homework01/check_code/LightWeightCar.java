package ru.aberezhnoy.homework01.check_code;

class LightWeightCar extends Car implements Movable { //пакетный доступ (считаем, что так задумано)

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }


}
