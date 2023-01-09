package ru.home.builder.easy_builder;

import java.time.LocalDateTime;

public class EasyBuilderApp {
    public static void main(String[] args) {
        System.out.println("Start Easy Builder App!");
        System.out.println("*****************************\n");

        Report report = new Report
                .Builder("Report for Q1")
                .setTitle("Sales")
                .setContent("Successfully")
                .setTable("Price table")
                .setPageNumber(1)
                .build();

        System.out.println(report);

        ShortReport shortReport = ShortReport.createBuilder()
                .includeTitle("Sales")
                .includeContent("content1")
                .includeContent("content3")
                .includeDateTime(LocalDateTime.now())
                .includePageCount(12)
                .build();

        System.out.println("\n" + shortReport);

        MarketCart marketCart = new MarketCart.CartBuilder()
                .includeBread(Bread
                        .createBread()
                        .withType("Black")
                        .withSize(300)
                        .build())
                .includeSausage(Sausage
                        .createSausage()
                        .withType("solyami")
                        .withSize(500)
                        .build())
                .includeOil(Oil
                        .createOil()
                        .withType("butter")
                        .withSize(1000)
                        .build())
                .includeMilk(Milk
                        .createMilk()
                        .withType("cow")
                        .withSize(5000)
                        .build())
                .build();

        System.out.println("\n" + marketCart);

        System.out.println("\n*****************************");
        System.out.println("Easy Builder App Done!");
    }
}
