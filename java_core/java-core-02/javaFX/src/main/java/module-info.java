module ru.aberezhnoy.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.aberezhnoy.quiz to javafx.fxml;
    exports ru.aberezhnoy.quiz;
}
