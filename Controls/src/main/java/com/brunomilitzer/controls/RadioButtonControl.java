package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RadioButtonControl extends Application {

    Label userSelection;

    @Override
    public void init() throws Exception {
        userSelection = new Label("Your Selection: None");
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        RadioButton spring = new RadioButton("Spring");
        RadioButton summer = new RadioButton("Summer");
        RadioButton fall = new RadioButton("Fall");
        RadioButton winter = new RadioButton("Winter");

        ToggleGroup seasons = new ToggleGroup();
        seasons.getToggles().addAll(spring, summer, fall, winter);
        seasons.selectedToggleProperty().addListener(this::changed);
        root.getChildren().addAll(userSelection, spring, summer, fall, winter);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Radio Button Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldBtn, Toggle newBtn) {
        String selectedLabel = "None";

        if (newBtn != null) {
            selectedLabel = ((Labeled) newBtn).getText();
        }

        userSelection.setText("Your Selection: " + selectedLabel);
    }
}
