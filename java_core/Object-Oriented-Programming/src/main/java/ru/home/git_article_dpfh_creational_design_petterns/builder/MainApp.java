package ru.home.git_article_dpfh_creational_design_petterns.builder;

public class MainApp {

    public static void main(String[] args) {

        Burger burger = new BurgerBuilder(14)
                .addPepperoni()
                .addCheese()
                .addLettuce()
                .addTomato()
                .build();
    }
}
