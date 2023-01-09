package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class WoodenDoorFactory implements DoorFactory {
    @Override
    public Door makeDore() {
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}
