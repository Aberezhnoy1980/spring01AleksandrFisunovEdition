package ru.home.lesson1.calendar;

import java.util.Arrays;

public class Calendar {
//    public static final int MONTH_JANUARY = 1;
//    public static final int MONTH_FEBRUARY = 2;
//
//    private int currentMonth = MONTH_FEBRUARY;

    public static void main(String[] args) {

        Month currentEMonth = Month.MAY;

        System.out.println(Month.valueOf("MAY"));

        System.out.println(Arrays.toString(Month.values()));

        System.out.println(Arrays.stream(Month.values()).count());

        System.out.println(Month.values().length);

        System.out.println(Month.MAY.getIndex());

        for (Month m : Month.values()) {
            System.out.println(m.getIndex() + " month " + m.name() + " season " + m.getSeason());
        }
    }
}
