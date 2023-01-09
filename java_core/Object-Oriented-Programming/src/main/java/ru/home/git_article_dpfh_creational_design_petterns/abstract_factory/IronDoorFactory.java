package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class IronDoorFactory implements DoorFactory {
    @Override
    public Door makeDore() {
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}
