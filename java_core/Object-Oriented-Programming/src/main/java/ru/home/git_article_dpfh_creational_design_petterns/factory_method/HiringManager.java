package ru.home.git_article_dpfh_creational_design_petterns.factory_method;

public abstract class HiringManager {

    // Factory method
    protected abstract Interviewer makeInterviewer();

    public void takeInterview() {
        Interviewer interviewer = makeInterviewer();
        interviewer.askQuestions();
    }
}
