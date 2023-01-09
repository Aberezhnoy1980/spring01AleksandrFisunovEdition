package ru.home.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        System.out.println("Start Singleton App");
        System.out.println("*****************\n");

        Singleton singleton = Singleton.getInstance();
        System.out.println(("1 - " + singleton));

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(("2 - " + singleton2));

        System.out.println(("3 - " + Singleton.getInstance()));

        WaterSpring waterSpring = WaterSpring.getInstance();
        float someWater = 2.5f;
        System.out.println("4 - " + waterSpring.getWater(3.5f, WaterSpring.Type.solty));

        someWater = 1.5f;
        System.out.println("5 - " + waterSpring.getWater(someWater, WaterSpring.Type.cola));

        someWater = 10.2f;
        System.out.println("5 - " + waterSpring.getWater(someWater, WaterSpring.Type.fresh));

        System.out.println(("WaterSpring - " + waterSpring));

        float waterForTea = 3.7f;
        Teapot teapot = new Teapot(waterForTea, WaterSpring.Type.cola);
        System.out.println(("6 - " + teapot.makeTea()));

        Multiton multiton = Multiton.getInstance("1");
        System.out.println(("7 - multiton 1: " + multiton));

        multiton = Multiton.getInstance("2");
        System.out.println(("8 - multiton 2: " + multiton));

        LimitedMultiton limitedMultiton = LimitedMultiton.getInstance(LimitedMultiton.Count.ONE);
        System.out.println(("9 - limited multiton ONE: " + limitedMultiton));

        limitedMultiton = LimitedMultiton.getInstance(LimitedMultiton.Count.TWO);
        System.out.println(("10 - limited multiton TWO: " + limitedMultiton));

        System.out.println("\n*****************");
        System.out.println("End Singleton App");

    }
}
