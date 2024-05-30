package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxControl extends Application {

    Label answer;
    CheckBox checkBox;

    @Override
    public void init() throws Exception {
        answer = new Label("Your answer is: None");
        checkBox = new CheckBox("Choice");
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Label question = new Label("Are you in favor:?");

        checkBox.setAllowIndeterminate(true);
        checkBox.selectedProperty().addListener(this::change);
        checkBox.indeterminateProperty().addListener(this::change);

        root.getChildren().addAll(answer, question, checkBox);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("CheckBox Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void change(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
        String choice;

        if (checkBox.isIndeterminate()) {
            choice = "Neutral";
        } else if (checkBox.isSelected()) {
            choice = "Agreed";
        } else {
            choice = "Disagree";
        }

        answer.setText("Your answer is: " + choice);
    }
}
