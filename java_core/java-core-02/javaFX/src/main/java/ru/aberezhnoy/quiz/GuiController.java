package ru.aberezhnoy.quiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    @FXML
    TextArea questionArea;

    @FXML
    RadioButton answer1, answer2, answer3, answer4;

    @FXML
    ToggleGroup answers;

    private String question = "What is your favorite fruit?";
    private String[] variants = {"Banana", "Orange", "Mandarin", "Kiwi"};
    private String correctVariant = "Mandarin";

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        questionArea.setText(question);
        answer1.setText(variants[0]);
        answer2.setText(variants[1]);
        answer3.setText(variants[2]);
        answer4.setText(variants[3]);
    }

    public void tryToAnswer(ActionEvent actionEvent) {
        if (((RadioButton) answers.getSelectedToggle()).getText().equals(correctVariant)) {
            Alert alert = new Alert((Alert.AlertType.CONFIRMATION), "well done!", ButtonType.OK);
            alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
            alert.showAndWait();
        } else {
            Alert alert = new Alert((Alert.AlertType.ERROR), "not well done!", ButtonType.OK);
            alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
            alert.showAndWait();
        }
    }

    public void show(ContextMenuEvent contextMenuEvent) {
        questionArea.appendText("Шо ты творишь мля?!?!?!?");
    }
}