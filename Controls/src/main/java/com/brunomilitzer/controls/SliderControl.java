package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Slider slider = new Slider(0, 100, 20);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(10);

        root.getChildren().addAll(slider);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Slider Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
