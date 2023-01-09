package ru.home.singleton;

public class WaterSpring {

    public enum Type {
        fresh, solty, cola;
    }

    private static WaterSpring instance = null;

    private static Type kindOfWater;

    public static WaterSpring getInstance() {
        if (instance == null) {
            instance = new WaterSpring();
        }
        return instance;
    }

    public String getWater(float liter, Type kindOfWater) {
        return (liter + " " +  kindOfWater);
    }
}
