package ru.home.git_article_dpfh_creational_design_petterns.singleton;

public class MainApp {

    public static void main(String[] args) {

        President president1 = President.getInstance();
        President president2 = President.getInstance();

        System.out.println(president1.equals(president2)); // true
    }
}
