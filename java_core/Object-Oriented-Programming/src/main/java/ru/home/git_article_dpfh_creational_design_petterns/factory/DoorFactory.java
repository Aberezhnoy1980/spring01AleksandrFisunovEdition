package ru.home.git_article_dpfh_creational_design_petterns.factory;

public class DoorFactory {

    public static Door makeDoor(float width, float height) {
        return new WoodenDoor(width, height);
    }
}