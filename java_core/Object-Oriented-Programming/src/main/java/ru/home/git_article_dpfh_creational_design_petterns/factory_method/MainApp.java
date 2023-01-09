package ru.home.git_article_dpfh_creational_design_petterns.factory_method;

public class MainApp {

    public static void main(String[] args) {

        DevelopmentManager developmentManager = new DevelopmentManager();
        developmentManager.takeInterview(); // Output: Asking about design patterns

        MarketingManager marketingManager = new MarketingManager();
        marketingManager.takeInterview(); //Output: Asking about community building.
    }
}
