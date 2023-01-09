package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class IronDoor implements Door {

    @Override
    public void getDescription() {
        System.out.println("I am a iron door");
    }
}
