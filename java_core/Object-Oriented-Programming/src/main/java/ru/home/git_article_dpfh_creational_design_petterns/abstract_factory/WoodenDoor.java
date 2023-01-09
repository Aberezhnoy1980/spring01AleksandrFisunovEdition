package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class WoodenDoor implements Door {

    @Override
    public void getDescription() {
        System.out.println("I am a wooden door");
    }
}
