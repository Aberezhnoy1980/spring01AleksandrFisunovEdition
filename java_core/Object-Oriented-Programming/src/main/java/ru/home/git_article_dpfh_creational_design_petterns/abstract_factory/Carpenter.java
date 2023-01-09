package ru.home.git_article_dpfh_creational_design_petterns.abstract_factory;

public class Carpenter implements DoorFittingExpert {

    @Override
    public void getDescription() {
        System.out.println("I can only fit wooden doors");
    }
}
