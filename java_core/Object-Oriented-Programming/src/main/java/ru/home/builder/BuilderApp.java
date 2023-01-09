package ru.home.builder;

public class BuilderApp {
    public static void main(String[] args) {
        System.out.println("Start Builder App");
        System.out.println("***************************\n");

        Director director = new Director();
        director.setBuilder(new LightIndustrialUnitBuilder());

        IndustrialUnit industrialUnit = director.buildIndustrialUnit();
        System.out.println(industrialUnit);

        director.setBuilder(new HeavyIndustrialUnitBuilder());
        System.out.println("\n" + director.buildIndustrialUnit());

        System.out.println("\n***************************");
        System.out.println("Builder App done");
    }
}
