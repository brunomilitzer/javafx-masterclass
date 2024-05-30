package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderBackgroundColorControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Slider red = new Slider(0, 255, 0);
        Slider green = new Slider(0, 255, 0);
        Slider blue = new Slider(0, 255, 0);

        Slider[] sliders = {red, green, blue};

        for (Slider slider : sliders) {
            slider.setShowTickMarks(true);
            slider.setBlockIncrement(5);
            slider.valueProperty().addListener((observable, oldValue, newValue) -> {
                int redColor = (int) red.getValue();
                int greenColor = (int) green.getValue();
                int blueColor = (int) blue.getValue();

                root.setStyle("-fx-background-color: rgb(" + redColor + ", " + greenColor + "," + blueColor + ");");
            });
        }

        root.getChildren().addAll(red, green, blue);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Slider Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
