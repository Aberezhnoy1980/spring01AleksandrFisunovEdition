package ru.home.git_article_dpfh_creational_design_petterns.factory_method;

public class Developer implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about design patterns!");
    }
}
