package ru.home.singleton;

public class Teapot {

    private final float volume;
    private WaterSpring.Type kindOfWater;

    public Teapot(float volume, WaterSpring.Type kindOfWater) {
        this.volume = volume;
        this.kindOfWater = kindOfWater;
    }

    public String makeTea() {
        return "The teapot with " + addWater(volume, kindOfWater);
    }

    private String addWater(float volume, WaterSpring.Type kindOfWater) {
        WaterSpring instance = WaterSpring.getInstance();

        System.out.println("Teapot" + instance);

        return instance.getWater(volume, kindOfWater);
    }
}
