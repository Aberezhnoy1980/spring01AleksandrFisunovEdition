package ru.home.git_article_dpfh_creational_design_petterns.singleton;

final class President {

    private static President instance;

    private President() {
    }

    public static President getInstance() {
        if (instance == null) {
            instance = new President();
        }
        return instance;
    }
}
