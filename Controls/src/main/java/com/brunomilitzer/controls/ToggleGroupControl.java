package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToggleGroupControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Your Selection is: ");

        ToggleButton spring = new ToggleButton("Spring");
        ToggleButton summer = new ToggleButton("Summer");
        ToggleButton fall = new ToggleButton("Fall");
        ToggleButton winter = new ToggleButton("Winter");

        ToggleGroup seasons = new ToggleGroup();
        seasons.getToggles().addAll(spring, summer, fall, winter);

        HBox seasonsLayout = new HBox();
        seasonsLayout.getChildren().addAll(spring, summer, fall, winter);
        seasonsLayout.setAlignment(Pos.CENTER);
        seasonsLayout.setSpacing(5);

        root.getChildren().addAll(label, seasonsLayout);

        seasons.selectedToggleProperty().addListener((observableValue, toggle, t1) -> label.setText("Your selection is: " + ((Labeled) t1).getText()));

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Toggle Group Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
