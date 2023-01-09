package ru.home.git_article_dpfh_creational_design_petterns.prototype;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {

        Sheep original = new Sheep("Jolly");
        System.out.println(original.getName()); // Jolly
        System.out.println(original.getCategory()); // Mountain Sheep

        Sheep cloned = original.clone();
        cloned.setName("Dolly");
        System.out.println(cloned.getName()); // Dolly
        System.out.println(cloned.getCategory()); // Mountain Sheep
    }
}
