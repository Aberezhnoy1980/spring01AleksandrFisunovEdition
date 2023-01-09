package ru.home.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry; // false by default

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (appetite <= p.getFood()) {
            hungry = false;
            p.decreaseFood(appetite);
        } else {
            hungry = true;
            System.out.println("Cat: MEEEEEEEEEEEEEEEEOOOOOOOOOOOOOOOOOOOWWWWWWW!!!!!!!!!!!!!!!");
        }
    }

}
