package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class MainApp {

    public static void main(String[] args) {

        DoorFactory woodenFactory = new WoodenDoorFactory();
        Door door = woodenFactory.makeDore();
        DoorFittingExpert expert = woodenFactory.makeFittingExpert();

        door.getDescription(); // Output: I am a wooden door
        expert.getDescription(); // I can only fit wooden doors

        DoorFactory ironDoorFactory = new IronDoorFactory();
        Door door2 = ironDoorFactory.makeDore();
        DoorFittingExpert expert2 = ironDoorFactory.makeFittingExpert();

        door2.getDescription(); // I am an iron door
        expert2.getDescription(); // I am only fit iron doors
    }
}
