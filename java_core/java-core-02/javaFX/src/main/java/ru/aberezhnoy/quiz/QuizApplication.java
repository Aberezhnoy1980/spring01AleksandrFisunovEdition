package ru.aberezhnoy.quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("quiz.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setTitle("Quiz!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
