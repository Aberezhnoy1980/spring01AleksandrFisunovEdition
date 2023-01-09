package ru.home.lesson1.calendar;

public enum Month {
    JANUARY(1, Season.WINTER), FEBRUARY(2, Season.WINTER), MARCH(3, Season.SPRING), APRIL(4, Season.SPRING), MAY(5, Season.SPRING), JUNE(6, Season.SUMMER), JULY(7, Season.SUMMER), AUGUST(8, Season.SUMMER), SEPTEMBER(9, Season.AUTUMN), OCTOBER(10, Season.AUTUMN), NOVEMBER(11,Season.AUTUMN), DECEMBER(12, Season.WINTER);

    private final int index;
    private final Season season;

    Month(int index, Season season) {
        this.index = index;
        this.season = season;
    }

    public int getIndex() {
        return index;
    }

    public Season getSeason() {
        return season;
    }
}
