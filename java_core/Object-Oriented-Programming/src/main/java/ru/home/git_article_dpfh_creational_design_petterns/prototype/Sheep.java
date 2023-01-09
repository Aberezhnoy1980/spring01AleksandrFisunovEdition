package ru.home.git_article_dpfh_creational_design_petterns.prototype;

public class Sheep implements Cloneable {

    protected String name;
    protected String category;

    public Sheep(String name) {
        this.name = name;
        this.category = "Mountain Sheep";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Sheep clone() throws CloneNotSupportedException {
        return (Sheep) super.clone();
    }
}
