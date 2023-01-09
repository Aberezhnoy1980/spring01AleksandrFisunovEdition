package ru.aberezhnoy.homework01.check_code;


// В классе Car есть поле класса Engine, а самого класса такого нет в коде. Поэтому дополнил код простейшим классом Engine
public class Engine { // сделал класс public, но, как вариант, доступ может быть и дефолтным (если следовать остальной логике всех классов)
    private String model;

    public Engine(String model) {
        this.model = model;
    }
}
