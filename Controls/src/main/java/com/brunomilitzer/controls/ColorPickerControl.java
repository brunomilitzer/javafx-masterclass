package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorPickerControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(actionEvent -> {
            root.setBackground(new Background(new BackgroundFill(colorPicker.getValue(),
                    CornerRadii.EMPTY, Insets.EMPTY)));
        });

        root.getChildren().addAll(colorPicker);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Color Picker Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
