package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatePickerControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label date = new Label();
        DatePicker datePicker = new DatePicker();
        datePicker.setEditable(false);
        datePicker.setOnAction(actionEvent -> date.setText(datePicker.getValue().toString()));

        root.getChildren().addAll(date, datePicker);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Date Picker Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
