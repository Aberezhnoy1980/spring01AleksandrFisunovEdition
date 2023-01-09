package ru.home.controlStatements;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class IfElse {
    public enum Months {
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

        final int monthIndex;
        Months(int monthIndex) {
            this.monthIndex = monthIndex;
        }
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        String season;
        System.out.println("Please, text month number");
        int monthIndex =  sc.nextInt();
//        String monthName =  sc.next(); // TODO не могу два сканера вызвать, видимо надо как то их распоточить или через стримы. Как дочитаю чего-нибудь наколхожу
        if (monthIndex == Months.JANUARY.monthIndex || monthIndex == Months.FEBRUARY.monthIndex || monthIndex == Months.DECEMBER.monthIndex
        /* || monthName.equalsIgnoreCase(Months.JANUARY.name()) || monthName.equalsIgnoreCase(Months.FEBRUARY.name()) || monthName.equalsIgnoreCase(Months.DECEMBER.name()) */)
        {
            season = "Winter";
        } else if (monthIndex == Months.MARCH.monthIndex || monthIndex == Months.APRIL.monthIndex || monthIndex == Months.MAY.monthIndex) {
            season = "Spring";
        } else if (monthIndex == Months.JUNE.monthIndex || monthIndex == Months.JULY.monthIndex || monthIndex == Months.AUGUST.monthIndex) {
            season = "Summer";
        } else if (monthIndex == Months.SEPTEMBER.monthIndex || monthIndex == Months.OCTOBER.monthIndex || monthIndex == Months.NOVEMBER.monthIndex) {
            season = "Autumn";
        } else season = "non-existent monthIndex";

        System.out.println(Months.values()[monthIndex - 1] + " refers to " + season);
    }
}
