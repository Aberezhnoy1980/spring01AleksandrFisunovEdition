package ru.aberezhnoy.homework01.check_code;

class Lorry extends Car implements Movable, Stopable {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override // не был реализован абстрактный метод родителя
    void open() {
        System.out.println("Car is open");
    }
}
